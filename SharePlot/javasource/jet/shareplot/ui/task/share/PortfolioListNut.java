package jet.shareplot.ui.task.share;

import java.util.List;

import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.models.EmptyLineListener;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.portfolio.PortfolioApplicationComponent;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.shareplot.util.BooleanConstants;
import jet.shareplot.util.TextUtils;
import jet.util.models.interfaces.Event;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class PortfolioListNut extends AbstractSharePlotNut {

    private UITableComponent2 tableList;
    private UITableListDisplay3 uiTableListDisplay3;
    private PortfolioApplicationComponent portfolioAC;
    private PortfolioItem emptyPortfolio;
    private EmptyPortfolioListener emptyPortfolioListener;

    @Initializer
    public final void doPortfolioListNutInit() throws JETException {

        this.portfolioAC = PortfolioApplicationComponent.getInstance(getSession());

        initPortfolioList();
        displayPortfolioList();

    }

    private void displayPortfolioList() {
        removeEmptyPortfolio();
        this.uiTableListDisplay3.removeAll();

        this.uiTableListDisplay3.detachModel();
        final List<PortfolioItem> items = this.portfolioAC.getPortfolios();
        for (final PortfolioItem portfolioItem : items) {
            this.uiTableListDisplay3.addRow(portfolioItem.get_Model());
        }
        addEmptyPortfolio();
        this.uiTableListDisplay3.attachModel();

    }

    private void initPortfolioList() throws JETException {
        final Model listDisplayModel = getConfigurationNode("APPLICATION_COMPONENT_CONFIG.PORTFOLIO_LIST");
        this.tableList = (UITableComponent2) UIComponentFinder.findComponent("tableList", getMainComponent());
        this.uiTableListDisplay3 = new UITableListDisplay3(this.tableList, getUIContext(), listDisplayModel, getSession(), getLogger());

        this.emptyPortfolioListener = new EmptyPortfolioListener();

    }

    private void addEmptyPortfolio() {
        if (isEmptyPortfolioValid()) {
            if (this.emptyPortfolio != null) {
                this.emptyPortfolio.get_Model().removeEventListener(this.emptyPortfolioListener);
            }

            this.emptyPortfolio = new PortfolioItem();
            this.emptyPortfolio.setIsFake(BooleanConstants.NO);

            this.uiTableListDisplay3.addRow(this.emptyPortfolio.get_Model());
            this.emptyPortfolio.get_Model().addEventListener(this.emptyPortfolioListener);
        }
    }

    private boolean isEmptyPortfolioValid() {
        boolean result;
        if (this.emptyPortfolio == null) {
            result = true;
        } else {
            result = TextUtils.isEmpty(this.emptyPortfolio.getName());
        }
        return result;
    }

    private void removeEmptyPortfolio() {
        if (this.emptyPortfolio != null) {
            this.emptyPortfolio.get_Model().removeEventListener(this.emptyPortfolioListener);
            this.uiTableListDisplay3.removeRow(this.emptyPortfolio.get_Model());
            this.emptyPortfolio = null;
        }
    }

    private class EmptyPortfolioListener extends EmptyLineListener {

        private static final long serialVersionUID = -1009201544110187098L;

        @Override
        protected <T extends Enum<T>> void handleChangedValue(final Event<T> event) {
            addEmptyPortfolio();
        }
    }

}
