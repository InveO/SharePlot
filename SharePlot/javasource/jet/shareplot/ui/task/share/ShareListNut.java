package jet.shareplot.ui.task.share;

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
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.share.ShareApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Event;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class ShareListNut extends AbstractSharePlotNut {

    private UITableComponent2 tableList;
    private UITableListDisplay3 uiTableListDisplay3;
    private final List<Share> shares = new ArrayList<Share>();
    private ShareApplicationComponent shareAC;
    private Share emptyShare;
    private Portfolio portfolio;
    private EmptyShareListener emptyShareListener;
    private UIButtonComponent saveButton;
    private UIButtonComponent deleteButton;
    private CheckBoxSelectedCellProvider selectedCellProvider;

    @Initializer
    public final void doShareListNutInit() throws JETException {

        this.portfolio = (Portfolio) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_PORTFOLIO);

        this.shareAC = ShareApplicationComponent.getInstance(getSession());

        getUIComponents();

        initShareList();
        displayShareList();
    }

    private void getUIComponents() throws JETException {
        this.saveButton = (UIButtonComponent) UIComponentFinder.findComponent("saveButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.saveButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.S));
        this.deleteButton = (UIButtonComponent) UIComponentFinder.findComponent("deleteButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.deleteButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.D));
    }

    private void displayShareList() {
        removeEmptyShare();
        this.uiTableListDisplay3.removeAll();
        this.shares.clear();

        this.uiTableListDisplay3.detachModel();
        final List<Share> items = this.shareAC.getShares(this.portfolio);
        for (final Share shareItem : items) {
            this.uiTableListDisplay3.addRow(shareItem.get_Model());
            this.shares.add(shareItem);
        }
        addEmptyShare();
        this.uiTableListDisplay3.attachModel();
    }

    private void initShareList() throws JETException {
        final Model listDisplayModel = getConfigurationNode("APPLICATION_COMPONENT_CONFIG.SHARE_LIST");
        this.tableList = (UITableComponent2) UIComponentFinder.findComponent("tableList", getMainComponent());
        this.uiTableListDisplay3 = new UITableListDisplay3(this.tableList, getUIContext(), listDisplayModel, getSession(), getLogger());

        this.selectedCellProvider = new CheckBoxSelectedCellProvider("colSelect");
        this.uiTableListDisplay3.addListTableCellModelProvider(this.selectedCellProvider);

        this.emptyShareListener = new EmptyShareListener();
    }

    private void addEmptyShare() {
        if (isEmptyShareValid()) {
            if (this.emptyShare != null) {
                this.emptyShare.get_Model().removeEventListener(this.emptyShareListener);
            }

            this.emptyShare = new Share(this.shareAC);
            this.emptyShare.setIdPortfolio(this.portfolio.getIdPortfolio());

            this.uiTableListDisplay3.addRow(this.emptyShare.get_Model());
            this.shares.add(this.emptyShare);
            this.emptyShare.get_Model().addEventListener(this.emptyShareListener);
        }
    }

    private boolean isEmptyShareValid() {
        boolean result;
        if (this.emptyShare == null) {
            result = true;
        } else {
            result = this.emptyShare.isValid();
        }
        return result;
    }

    private void removeEmptyShare() {
        if (this.emptyShare != null) {
            this.emptyShare.get_Model().removeEventListener(this.emptyShareListener);
            this.uiTableListDisplay3.removeRow(this.emptyShare.get_Model());
            this.shares.remove(this.emptyShare);
            this.emptyShare = null;
        }
    }

    private class EmptyShareListener extends EmptyLineListener {

        private static final long serialVersionUID = -1009201544110187098L;

        @Override
        protected <T extends Enum<T>> void handleChangedValue(final Event<T> event) {
            addEmptyShare();
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
        removeEmptyShare();

        final List<Share> toRemove = new ArrayList<Share>();

        // find shares to delete, and delete in DB
        for (final Share share : this.shares) {
            final Boolean isSelected = this.selectedCellProvider.getSelectedState(share.get_Model());
            if (isSelected.booleanValue()) {
                try {
                    // if is not new delete from db
                    share.delete();

                    toRemove.add(share);
                } catch (final FormatedJetException e) {
                    // TODO display error message
                    logp(JETLevel.SEVERE, "ShareListNut", "processDelete", e.getMessage(), e);
                }
            }
        }

        // remove from display
        for (final Share share : toRemove) {
            this.uiTableListDisplay3.removeRow(share.get_Model());
            this.shares.remove(share);
        }

        addEmptyShare();
    }

    private void processSave() {
        removeEmptyShare();

        for (final Share share : this.shares) {
            try {
                share.save();
            } catch (final FormatedJetException e) {
                // TODO display message for user
                logp(JETLevel.SEVERE, "ShareListNut", "processSave", e.getMessage(), e);
            }
        }

        addEmptyShare();
    }

}
