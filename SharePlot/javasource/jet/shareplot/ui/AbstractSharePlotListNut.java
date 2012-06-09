package jet.shareplot.ui;

import java.util.ArrayList;
import java.util.List;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.components.ui.events.KeyEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.ui.utils.table.CheckBoxSelectedCellProvider;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.models.EmptyLineListener;
import jet.framework.util.ui.UIComponentHelper;
import jet.lifecycle.annotations.Initializer;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Event;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public abstract class AbstractSharePlotListNut<T> extends AbstractSharePlotNut {

    protected UITableComponent2 tableList;
    protected UITableListDisplay3 uiTableListDisplay3;
    protected final List<T> items = new ArrayList<T>();
    private T emptyItem;
    private EmptyItemListener emptyItemListener;
    private UIButtonComponent saveButton;
    private UIButtonComponent deleteButton;
    private CheckBoxSelectedCellProvider selectedCellProvider;

    @Initializer
    public final void doAbstractSharePlotListNutInit() throws JETException {
        preInit();

        getUIComponents();

        initItemList();
        displayShareList();

        postInit();
    }

    protected abstract void preInit() throws JETException;

    protected abstract void postInit() throws JETException;

    private void getUIComponents() throws JETException {
        this.saveButton = (UIButtonComponent) UIComponentFinder.findComponent("saveButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.saveButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.S));
        this.deleteButton = (UIButtonComponent) UIComponentFinder.findComponent("deleteButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.deleteButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.D));
    }

    private void displayShareList() {
        removeEmptyItem();
        this.uiTableListDisplay3.removeAll();
        this.items.clear();

        this.uiTableListDisplay3.detachModel();
        final List<T> tmpItems = findItems();
        for (final T item : tmpItems) {
            this.uiTableListDisplay3.addRow(getItemModel(item));
            this.items.add(item);
        }
        addEmptyItem();
        this.uiTableListDisplay3.attachModel();
    }

    protected abstract List<T> findItems();

    private void initItemList() throws JETException {
        final Model listDisplayModel = getConfigurationNode(getListDisplayKey());
        this.tableList = (UITableComponent2) UIComponentFinder.findComponent("tableList", getMainComponent());
        this.uiTableListDisplay3 = new UITableListDisplay3(this.tableList, getUIContext(), listDisplayModel, getSession(), getLogger());

        this.selectedCellProvider = new CheckBoxSelectedCellProvider("colSelect");
        this.uiTableListDisplay3.addListTableCellModelProvider(this.selectedCellProvider);

        addListDisplayProviders(this.uiTableListDisplay3);

        this.emptyItemListener = new EmptyItemListener();
    }

    protected abstract void addListDisplayProviders(UITableListDisplay3 uiTableListDisplay);

    protected abstract String getListDisplayKey();

    protected final void addEmptyItem() {
        if (isItemValid(this.emptyItem)) {
            if (this.emptyItem != null) {
                getItemModel(this.emptyItem).removeEventListener(this.emptyItemListener);
            }

            this.emptyItem = createNewItem();

            this.uiTableListDisplay3.addRow(getItemModel(this.emptyItem));
            this.items.add(this.emptyItem);
            getItemModel(this.emptyItem).addEventListener(this.emptyItemListener);
        }
    }

    protected abstract boolean isItemValid(T item);

    protected abstract Model getItemModel(T item);

    protected abstract T createNewItem();

    private void removeEmptyItem() {
        if (this.emptyItem != null) {
            getItemModel(this.emptyItem).removeEventListener(this.emptyItemListener);
            this.uiTableListDisplay3.removeRow(getItemModel(this.emptyItem));
            this.items.remove(this.emptyItem);
            this.emptyItem = null;
        }
    }

    private class EmptyItemListener extends EmptyLineListener {

        private static final long serialVersionUID = -1009201544110187098L;

        @Override
        protected <X extends Enum<X>> void handleChangedValue(final Event<X> event) {
            addEmptyItem();
        }
    }

    @Override
    public void componentClicked(final UIComponent component) {
        if (component == this.saveButton) {
            processSave();
        } else if (component == this.deleteButton) {
            processDelete();
        }
    }

    private void processDelete() {
        removeEmptyItem();

        final List<T> toRemove = new ArrayList<T>();

        // find shares to delete, and delete in DB
        for (final T item : this.items) {
            final Boolean isSelected = this.selectedCellProvider.getSelectedState(getItemModel(item));
            if (isSelected.booleanValue()) {
                try {
                    // if is not new delete from db
                    deleteItem(item);

                    toRemove.add(item);
                } catch (final FormatedJetException e) {
                    // TODO display error message
                    logp(JETLevel.SEVERE, "AbstractSharePlotListNut", "processDelete", e.getMessage(), e);
                }
            }
        }

        // remove from display
        for (final T item : toRemove) {
            this.uiTableListDisplay3.removeRow(getItemModel(item));
            this.items.remove(item);
        }

        addEmptyItem();
    }

    protected abstract void deleteItem(T item) throws FormatedJetException;

    protected abstract void saveItem(T item) throws FormatedJetException;

    private void processSave() {
        removeEmptyItem();

        for (final T item : this.items) {
            try {
                saveItem(item);
            } catch (final FormatedJetException e) {
                // TODO display message for user
                logp(JETLevel.SEVERE, "AbstractSharePlotListNut", "processSave", e.getMessage(), e);
            }
        }

        addEmptyItem();
    }

}
