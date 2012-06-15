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
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.portfolio.PortfolioApplicationComponent;
import jet.shareplot.ac.bo.portfolio.PortfolioResource;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.shareplot.ui.desktop.SharePlotACLauncher;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.shareplot.util.BooleanConstants;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

public class PortfolioListNut extends AbstractSharePlotListNut<Portfolio> {

    private PortfolioApplicationComponent portfolioAC;

    @Override
    public <T extends Enum<T>> void tableCellEvent(final UITableComponent2 table, final int row, final int col, final UIEvent<T> uiEvent) {
        if (this.tableList == table) {
            if (uiEvent instanceof MouseEvent) {
                // if the row is double clicked the current contact must be edited
                final MouseEvent me = (MouseEvent) uiEvent;
                if (me.getType() == MouseEventType.LEFT_CLICK) {

                    final String colName = this.uiTableListDisplay3.getColumnName(col);

                    if ("editColumn".equals(colName)) {
                        final Portfolio portfolio = this.items.get(row);
                        if (portfolio.getIdPortfolio() != null) {
                            launchEditPortfolio(portfolio);
                        }
                    }
                }
            }
        }
    }

    private void launchEditPortfolio(final Portfolio portfolio) {
        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                final Map<String, Object> initArgs = new HashMap<String, Object>();
                initArgs.put(ShareUIConstants.ARGUMENT_PORTFOLIO, new Portfolio(portfolio));
                initArgs.put(SharePlotACLauncher.AC_KEY_PARAMETER, new ShareListNutKey(portfolio.getIdPortfolio()));

                acLauncher.launchApplicationComponent(TaskNameConstants.SHARE_LIST, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "PortfolioListNut", "launchEditPortfolio", e.getMessage(), e);
            }
        }
    }

    @Override
    protected void preInit() throws JETException {
        this.portfolioAC = PortfolioApplicationComponent.getInstance(getSession());
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<Portfolio> findItems() {
        return this.portfolioAC.getPortfolios();
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.PORTFOLIO_LIST";
    }

    @Override
    protected Portfolio createNewItem() {
        final Portfolio portfolio = new Portfolio(this.portfolioAC);
        portfolio.setIsFake(BooleanConstants.NO);
        return portfolio;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        // nothing to do
    }

    @Override
    protected String getResourceName() {
        return PortfolioResource.RESOURCE_NAME;
    }

    @Override
    protected Portfolio getItemCopy(final Portfolio item) {
        return new Portfolio(item);
    }

}
