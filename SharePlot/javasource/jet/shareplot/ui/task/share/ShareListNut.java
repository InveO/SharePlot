package jet.shareplot.ui.task.share;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.components.ui.events.MouseEvent;
import jet.components.ui.events.MouseEventType;
import jet.components.ui.events.UIEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.share.ShareApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.shareplot.ui.desktop.SharePlotACLauncher;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class ShareListNut extends AbstractSharePlotListNut<Share> {

    private ShareApplicationComponent shareAC;
    private Portfolio portfolio;

    @Override
    public <T extends Enum<T>> void tableCellEvent(final UITableComponent2 table, final int row, final int col, final UIEvent<T> uiEvent) {
        if (this.tableList == table) {
            if (uiEvent instanceof MouseEvent) {
                // if the row is double clicked the current contact must be edited
                final MouseEvent me = (MouseEvent) uiEvent;
                if (me.getType() == MouseEventType.LEFT_CLICK) {

                    final String colName = this.uiTableListDisplay3.getColumnName(col);

                    if ("editColumn".equals(colName)) {
                        final Share share = this.items.get(row);
                        if (share.getIdShare() != null) {
                            launchEditShare(share);
                        }
                    }
                }
            }
        }
    }

    private void launchEditShare(final Share share) {
        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                final Map<String, Object> initArgs = new HashMap<String, Object>();
                initArgs.put(ShareUIConstants.ARGUMENT_SHARE, new Share(share));
                initArgs.put(SharePlotACLauncher.AC_KEY_PARAMETER, new ShareDetailNutKey(share.getIdShare()));

                acLauncher.launchApplicationComponent(TaskNameConstants.SHARE_DETAIL, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "ShareListNut", "launchEditShare", e.getMessage(), e);
            }
        }
    }

    @Override
    protected void preInit() throws JETException {
        this.portfolio = (Portfolio) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_PORTFOLIO);
        this.shareAC = ShareApplicationComponent.getInstance(getSession());

        final Object[] objects = { this.portfolio.getName() };
        final Displayable displayable = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareListName", objects);
        setHeaderTitle(displayable);
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<Share> findItems() {
        return this.shareAC.getShares(this.portfolio);
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.SHARE_LIST";
    }

    @Override
    protected boolean isItemValid(final Share item) {
        boolean result;
        if (item == null) {
            result = true;
        } else {
            result = item.isValid();
        }
        return result;
    }

    @Override
    protected Model getItemModel(final Share item) {
        return item.get_Model();
    }

    @Override
    protected Share createNewItem() {
        final Share share = new Share(this.shareAC);
        share.setIdPortfolio(this.portfolio.getIdPortfolio());
        return share;
    }

    @Override
    protected void deleteItem(final Share item) throws FormatedJetException {
        item.delete();
    }

    @Override
    protected void saveItem(final Share item) throws FormatedJetException {
        item.save();
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        // nothing to do
    }

}
