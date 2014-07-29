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
import jet.framework.util.pojo2.JFDataItem;
import jet.framework.util.ui.UIComponentHelper;
import jet.lifecycle.annotations.Initializer;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Event;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Abstract Nut for handling lists.
 *
 * @author daniel
 *
 * @param <T>
 */
public abstract class AbstractSharePlotDataItemListNut<T extends JFDataItem> extends AbstractSharePlotNut {

    private static final long serialVersionUID = 1890708957130287350L;
    /**
     * UITableComponent2 that will display the list.
     */
    protected UITableComponent2 tableList;
    /**
     * UITableListDisplay3 that will handle the list.
     */
    protected UITableListDisplay3 uiTableListDisplay3;
    /**
     * List of items to display in the list.
     */
    protected final List<T> items = new ArrayList<T>();
    private @Nullable T emptyItem;
    private EmptyItemListener emptyItemListener;
    private UIButtonComponent saveButton;
    private UIButtonComponent deleteButton;
    private CheckBoxSelectedCellProvider selectedCellProvider;

    /**
     * Initializer, for internal use only.
     *
     * @throws JETException if failed to initialize
     */
    @Initializer
    public final void doAbstractSharePlotDataItemListNutInit() throws JETException {
        preInit();

        getUIComponents();

        initItemList();
        displayItemList();

        postInit();
    }

    /**
     * Method called at the start of the Initializer.
     *
     * @throws JETException if there is an error, this will interrupt the initialization.
     */
    protected abstract void preInit() throws JETException;

    /**
     * Method called at the end of the Initializer.
     *
     * @throws JETException if there is an error, this will interrupt the initialization.
     */
    protected abstract void postInit() throws JETException;

    private void getUIComponents() throws JETException {
        this.saveButton = (UIButtonComponent) UIComponentFinder.findComponent("saveButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.saveButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.S));
        this.deleteButton = (UIButtonComponent) UIComponentFinder.findComponent("deleteButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.deleteButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.D));
    }

    private void displayItemList() {
        removeEmptyItem();
        this.uiTableListDisplay3.removeAll();
        this.items.clear();

        this.uiTableListDisplay3.detachModel();
        final List<T> tmpItems = findItems();
        for (final T item : tmpItems) {
            this.uiTableListDisplay3.addRow(item.get_Model());
            this.items.add(item);
        }
        addEmptyItem();
        this.uiTableListDisplay3.attachModel();
    }

    /**
     * Get the list of items to display.
     *
     * @return list of items to display
     */
    protected abstract List<T> findItems();

    private void initItemList() throws JETException {
        final Model listDisplayModel = getConfigurationNode(getListDisplayKey());
        final UITableComponent2 table = this.tableList = (UITableComponent2) UIComponentFinder.findComponent("tableList", getMainComponent());
        this.uiTableListDisplay3 = new UITableListDisplay3(table, getUIContext(), listDisplayModel, getSession(), getLogger());

        this.selectedCellProvider = new CheckBoxSelectedCellProvider("colSelect");
        this.uiTableListDisplay3.addListTableCellModelProvider(this.selectedCellProvider);

        addListDisplayProviders(this.uiTableListDisplay3);

        this.emptyItemListener = new EmptyItemListener();
    }

    /**
     * Add providers to the UITableListDisplay3 to handle specific elements.
     *
     * @param uiTableListDisplay UITableListDisplay3 that handles the list
     */
    protected abstract void addListDisplayProviders(UITableListDisplay3 uiTableListDisplay);

    /**
     * Get the name of the list display model to use.
     *
     * @return name of the list display model to use
     */
    protected abstract String getListDisplayKey();

    /**
     * Add an empty item at the end of the list.
     */
    protected final void addEmptyItem() {
        if (canAddEmptyItem(this.emptyItem)) {
            final @Nullable T emptyIt0 = this.emptyItem;
            if (emptyIt0 != null) {
                emptyIt0.get_Model().removeEventListener(this.emptyItemListener);
            }

            final T emptyIt1 = createNewItem();
            this.emptyItem = emptyIt1;

            this.uiTableListDisplay3.addRow(emptyIt1.get_Model());
            this.items.add(emptyIt1);
            emptyIt1.get_Model().addEventListener(this.emptyItemListener);
        }
    }

    /**
     * Can a new item be added to the list.
     *
     * @param currentEmptyItem Empty item in the list
     * @return <code>true</code> if the current empty item is sufficient to add a new empty item
     */
    protected abstract boolean canAddEmptyItem(@Nullable T currentEmptyItem);

    /**
     * Create a new initialized item.
     *
     * @return new item
     */
    protected abstract T createNewItem();

    /**
     * Get a clone of the item.
     *
     * @param item Item to clone
     * @return cloned item
     */
    protected abstract T getItemCopy(@NonNull T item);

    private void removeEmptyItem() {
        @Nullable
        final T emptyIt = this.emptyItem;
        if (emptyIt != null) {
            emptyIt.get_Model().removeEventListener(this.emptyItemListener);
            this.uiTableListDisplay3.removeRow(emptyIt.get_Model());
            this.items.remove(this.emptyItem);
            this.emptyItem = null;
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
            final Boolean isSelected = this.selectedCellProvider.getSelectedState(item.get_Model());
            if (isSelected.booleanValue()) {
                try {
                    // if is not new delete from db
                    deleteItem(item);

                    toRemove.add(item);
                } catch (final FormatedJetException e) {
                    logp(JETLevel.SEVERE, "AbstractSharePlotDataItemListNut", "processDelete", e.getMessage(), e);
                }
            }
        }

        // remove from display
        for (final T item : toRemove) {
            this.uiTableListDisplay3.removeRow(item.get_Model());
            this.items.remove(item);
        }

        addEmptyItem();
    }

    /**
     * Delete an item.
     *
     * @param item Item to be deleted
     * @return deleted item
     * @throws FormatedJetException if there was an error
     */
    protected abstract T deleteItem(@NonNull T item) throws FormatedJetException;

    private void processSave() {
        removeEmptyItem();

        preSave();

        for (final T item : this.items) {
            assert item != null;
            try {
                saveItem(item);
            } catch (final FormatedJetException e) {
                logp(JETLevel.SEVERE, "AbstractSharePlotDataItemListNut", "processSave", e.getMessage(), e);
            }
        }

        postSave();

        addEmptyItem();
    }

    /**
     * Save an item.
     *
     * @param item Item to be saved
     * @return Saved item
     * @throws FormatedJetException if there was an error
     */
    protected abstract T saveItem(@NonNull T item) throws FormatedJetException;

    /**
     * Called after all the items have been saved. Will be called once.
     */
    protected abstract void postSave();

    /**
     * Called before all the items are saved. Will be called once.
     */
    protected abstract void preSave();

    /**
     * EmptyLineListener implementation.
     *
     * @author daniel
     *
     */
    private class EmptyItemListener extends EmptyLineListener {

        private static final long serialVersionUID = -1009201544110187098L;

        @Override
        protected <X extends Enum<X>> void handleChangedValue(final Event<X> event) {
            addEmptyItem();
        }
    }

}
