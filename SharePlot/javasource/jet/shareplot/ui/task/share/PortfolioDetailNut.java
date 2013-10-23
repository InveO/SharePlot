package jet.shareplot.ui.task.share;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jet.components.ui.events.MouseEvent;
import jet.components.ui.events.MouseEventType;
import jet.components.ui.events.UIEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.desktop.navigation.menu.CleanCloseException;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.portfolio.portfolioshare.PortfolioShareBOApplicationComponent;
import jet.shareplot.persistence.pojo.portfolio.PortfolioShareItem;
import jet.shareplot.ui.AbstractSharePlotDataItemListNut;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

public class PortfolioDetailNut extends AbstractSharePlotDataItemListNut<PortfolioShareItem> {

    private Portfolio portfolio;
    private PortfolioShareBOApplicationComponent portfolioShareAC;

    @Override
    public <T extends Enum<T>> void tableCellEvent(final UITableComponent2 table, final int row, final int col, final UIEvent<T> uiEvent) {
        if (this.tableList == table) {
            if (uiEvent instanceof MouseEvent) {
                // if the row is double clicked the current contact must be edited
                final MouseEvent me = (MouseEvent) uiEvent;
                if (me.getType() == MouseEventType.LEFT_CLICK) {
                    processTableLeftClick(row, col);
                }
            }
        }
    }

    private void processTableLeftClick(final int row, final int col) {
        final String colName = this.uiTableListDisplay3.getColumnName(col);

        if ("editColumn".equals(colName)) {
            final PortfolioShareItem portfolioShare = this.items.get(row);
            if (portfolioShare.getIdPortfolio() != null) {
                launchEditPortfolio(portfolioShare);
            }
        }
    }

    private void launchEditPortfolio(@Nonnull final PortfolioShareItem portfolioShare) {
        final Map<String, Object> initArgs = new HashMap<String, Object>();

        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                initArgs.put(ShareUIConstants.ARGUMENT_PORTFOLIO, getItemCopy(portfolioShare));

                acLauncher.launchApplicationComponent(TaskNameConstants.SHARE_LIST, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "PortfolioListNut", "launchEditPortfolio", e.getMessage(), e);
            } catch (final CleanCloseException e) {
                logp(JETLevel.INFO, "PortfolioListNut", "launchEditPortfolio", e.getMessage());
            }
        }
    }

    @Override
    protected void preInit() throws JETException {
        this.portfolio = (Portfolio) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_PORTFOLIO);
        this.portfolioShareAC = PortfolioShareBOApplicationComponent.getInstance(getSession());

        final Object[] args = { this.portfolio.getName() };
        final Displayable titleDisp = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.PortfolioDetailName", args);
        setHeaderTitle(titleDisp);
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<PortfolioShareItem> findItems() {
        return this.portfolioShareAC.getPortfolioShares(this.portfolio);
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.SHARE_LIST";
    }

    @Override
    protected PortfolioShareItem createNewItem() {
        final PortfolioShareItem portfolioShare = new PortfolioShareItem();
        return portfolioShare;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        // nothing to do
    }

    @Override
    protected void postSave() {
        // nothing to do
    }

    @Override
    protected void preSave() {
        // nothing to do
    }

    @Override
    protected boolean canAddEmptyItem(@Nullable final PortfolioShareItem currentEmptyItem) {
        boolean result = false;
        if (currentEmptyItem == null) {
            result = true;
        } else {
            if (!currentEmptyItem.isNotNullableNull()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    protected PortfolioShareItem getItemCopy(@Nonnull final PortfolioShareItem item) {
        return new PortfolioShareItem(item);
    }

    @Override
    protected PortfolioShareItem deleteItem(@Nonnull final PortfolioShareItem item) throws FormatedJetException {
        // TODO Auto-generated method stub
        return item;
    }

    @Override
    protected PortfolioShareItem saveItem(@Nonnull final PortfolioShareItem item) throws FormatedJetException {
        // TODO Auto-generated method stub
        return item;
    }

}
