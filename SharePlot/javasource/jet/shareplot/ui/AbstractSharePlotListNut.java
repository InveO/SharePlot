package jet.shareplot.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.components.ui.events.KeyEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.component.resource.ResourceNotificationListener;
import jet.framework.ui.utils.table.CheckBoxSelectedCellProvider;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.models.EmptyLineListener;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.framework.util.pojo2.AbstractResourceNotification.NOTIFICATION_TYPE;
import jet.framework.util.pojo2.JFBusinessItem;
import jet.framework.util.ui.UIComponentHelper;
import jet.lifecycle.annotations.Initializer;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Event;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public abstract class AbstractSharePlotListNut<T extends JFBusinessItem> extends AbstractSharePlotNut implements ResourceNotificationListener {

    protected UITableComponent2 tableList;
    protected UITableListDisplay3 uiTableListDisplay3;
    protected final List<T> items = new ArrayList<T>();
    private T emptyItem;
    private EmptyItemListener emptyItemListener;
    private UIButtonComponent saveButton;
    private UIButtonComponent deleteButton;
    private CheckBoxSelectedCellProvider selectedCellProvider;
    private ResourceNotificationApplicationComponent resourceAC;
    private boolean processNotifications = true;

    @Initializer
    public final void doAbstractSharePlotListNutInit() throws JETException {
        preInit();

        getUIComponents();

        initItemList();
        displayShareList();

        this.resourceAC = ResourceNotificationApplicationComponent.getInstance(getSession());
        this.resourceAC.addResourceNotificationListener(getResourceName(), this);

        postInit();
    }

    protected abstract String getResourceName();

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
            this.uiTableListDisplay3.addRow(item.get_Model());
            this.items.add(item);
        }
        addEmptyItem();
        this.uiTableListDisplay3.attachModel();
    }

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

    protected abstract void addListDisplayProviders(UITableListDisplay3 uiTableListDisplay);

    protected abstract String getListDisplayKey();

    protected final void addEmptyItem() {
        if (this.emptyItem == null || this.emptyItem.isValid()) {
            if (this.emptyItem != null) {
                this.emptyItem.get_Model().removeEventListener(this.emptyItemListener);
            }

            this.emptyItem = createNewItem();

            this.uiTableListDisplay3.addRow(this.emptyItem.get_Model());
            this.items.add(this.emptyItem);
            this.emptyItem.get_Model().addEventListener(this.emptyItemListener);
        }
    }

    protected abstract T createNewItem();

    protected abstract T getItemCopy(@Nonnull T item);

    private void removeEmptyItem() {
        if (this.emptyItem != null) {
            this.emptyItem.get_Model().removeEventListener(this.emptyItemListener);
            this.uiTableListDisplay3.removeRow(this.emptyItem.get_Model());
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
            final Boolean isSelected = this.selectedCellProvider.getSelectedState(item.get_Model());
            if (isSelected.booleanValue()) {
                try {
                    // if is not new delete from db
                    item.delete();

                    toRemove.add(item);
                } catch (final FormatedJetException e) {
                    // TODO display error message
                    logp(JETLevel.SEVERE, "AbstractSharePlotListNut", "processDelete", e.getMessage(), e);
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

    private void processSave() {
        removeEmptyItem();

        preSave();

        this.processNotifications = false;
        for (final T item : this.items) {
            try {
                item.save();
            } catch (final FormatedJetException e) {
                // TODO display message for user
                logp(JETLevel.SEVERE, "AbstractSharePlotListNut", "processSave", e.getMessage(), e);
            }
        }
        this.processNotifications = true;

        postSave();

        addEmptyItem();
    }

    protected abstract void postSave();

    protected abstract void preSave();

    // ResourceNotificationListener
    @Override
    public void resourceNotification(final String resourceName, final Model parameter) {
        if (this.processNotifications && resourceName.equals(getResourceName())) {
            if (parameter instanceof AbstractResourceNotification) {
                @SuppressWarnings("unchecked")
                final AbstractResourceNotification<T> resNotif = (AbstractResourceNotification<T>) parameter;
                final T resource = resNotif.getResource();

                if (resource != null) {
                    final NOTIFICATION_TYPE type = resNotif.getType();

                    if (NOTIFICATION_TYPE.CREATE.equals(type)) {
                        addNewResource(resource, -1);
                    } else if (NOTIFICATION_TYPE.UPDATE.equals(type)) {
                        final int index = removeResource(resource);
                        addNewResource(resource, index);
                    } else if (NOTIFICATION_TYPE.DELETE.equals(type)) {
                        removeResource(resource);
                    }
                }
            }
        }
    }

    private int removeResource(final T resource) {
        int index = -1;
        // find matching resource in list
        T itemToDelete = null;
        for (final T itemInList : this.items) {
            if (itemInList.isPkEquals(resource)) {
                itemToDelete = itemInList;
            }
        }
        // remove item from display list and pojo list
        if (itemToDelete != null) {
            index = this.uiTableListDisplay3.getIndexOf(itemToDelete.get_Model());
            this.uiTableListDisplay3.removeRow(itemToDelete.get_Model());
            this.items.remove(itemToDelete);
        }
        return index;
    }

    private void addNewResource(@Nonnull final T resource, final int index) {
        // add resource at index in list
        final T copy = getItemCopy(resource);
        final Model model = copy.get_Model();
        if (index < 0) {
            // if index is < 0 insert at the end of the list, empty line should be
            // removed so the new line is before the empty line
            removeEmptyItem();
            this.uiTableListDisplay3.addRow(model);
            addEmptyItem();
        } else {
            this.uiTableListDisplay3.addRow(index, model);
        }
        this.items.add(resource);
    }
}
