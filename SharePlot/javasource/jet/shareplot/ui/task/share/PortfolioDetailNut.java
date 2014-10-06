package jet.shareplot.ui.task.share;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import jet.shareplot.ac.bo.portfolio.portfolioshare.PortfolioShare;
import jet.shareplot.ac.bo.portfolio.portfolioshare.PortfolioShareBOApplicationComponent;
import jet.shareplot.ac.bo.share.ShareAutoCompleteProvider;
import jet.shareplot.ac.bo.share.ShareBOApplicationComponent;
import jet.shareplot.ac.bo.sharequantity.ChangeType;
import jet.shareplot.ac.bo.sharequantity.ShareQuantity;
import jet.shareplot.ac.bo.sharequantity.ShareQuantityBOApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotDataItemListNut;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.shareplot.ui.task.share.provider.PortfolioShareShareProvider;
import jet.shareplot.util.DateUtils;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class PortfolioDetailNut extends AbstractSharePlotDataItemListNut<PortfolioShare> {

    private Portfolio portfolio;
    private PortfolioShareBOApplicationComponent portfolioShareAC;
    private ShareBOApplicationComponent shareAC;
    private ShareQuantityBOApplicationComponent shareQuantityAC;

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
            final PortfolioShare portfolioShare = this.items.get(row);
            if (portfolioShare.getIdPortfolio() != null) {
                launchEditPortfolio(portfolioShare);
            }
        }
    }

    private void launchEditPortfolio(@NonNull final PortfolioShare portfolioShare) {
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
        this.shareAC = ShareBOApplicationComponent.getInstance(getSession());
        this.shareQuantityAC = ShareQuantityBOApplicationComponent.getInstance(getSession());

        final Object @NonNull [] args = { this.portfolio.getName() };
        final Displayable titleDisp = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.PortfolioDetailName", args);
        setHeaderTitle(titleDisp);
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<PortfolioShare> findItems() {
        return this.portfolioShareAC.getPortfolioShares(this.portfolio);
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.SHARE_LIST";
    }

    @Override
    protected PortfolioShare createNewItem() {
        final PortfolioShare portfolioShare = new PortfolioShare(AnnotationsHelper.assertNonNull(this.portfolioShareAC));
        portfolioShare.setIdPortfolio(this.portfolio.getIdPortfolio());
        portfolioShare.setPortfolioName(this.portfolio.getName());
        portfolioShare.setValueDate(DateUtils.getToday());
        return portfolioShare;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        final ShareAutoCompleteProvider shareAutoCompleteProvider = this.shareAC.getShareAutoCompleteProvider();
        final PortfolioShareShareProvider portfolioShareShareProvider = new PortfolioShareShareProvider(shareAutoCompleteProvider, "shareColumn");
        uiTableListDisplay.addListTableCellModelProvider(portfolioShareShareProvider);
        uiTableListDisplay.addListTableColumnHeaderProvider(portfolioShareShareProvider);
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
    protected boolean canAddEmptyItem(@Nullable final PortfolioShare currentEmptyItem) {
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
    protected PortfolioShare getItemCopy(@NonNull final PortfolioShare item) {
        return new PortfolioShare(item);
    }

    @Override
    protected PortfolioShare deleteItem(@NonNull final PortfolioShare item) throws FormatedJetException {
        final Long idPortfolio = item.getIdPortfolio();
        final Long idShare = item.getIdShare();
        if (idPortfolio != null && idShare != null) {
            final List<ShareQuantity> shareQuantitys = this.shareQuantityAC.getShareQuantitys(idPortfolio, idShare);
            for (final ShareQuantity shareQuantity : shareQuantitys) {
                shareQuantity.delete();
            }
        }
        return item;
    }

    @Override
    protected PortfolioShare saveItem(@NonNull final PortfolioShare item) throws FormatedJetException {

        final ShareQuantity shareQuantity = new ShareQuantity(AnnotationsHelper.assertNonNull(this.shareQuantityAC));

        shareQuantity.setChangeFee(BigDecimal.ZERO);
        shareQuantity.setChangeQuantity(item.getChangeQuantity());
        shareQuantity.setChangeType(ChangeType.PURCHASE.getCode());
        shareQuantity.setChangeValue(BigDecimal.ZERO);
        shareQuantity.setDescription(null);
        shareQuantity.setIdPortfolio(item.getIdPortfolio());
        shareQuantity.setIdShare(item.getIdShare());
        shareQuantity.setValueDate(item.getValueDate());

        shareQuantity.save();

        return item;
    }
}
