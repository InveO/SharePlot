package jet.shareplot.ui.task.share;

import java.util.ArrayList;
import java.util.List;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.components.ui.events.KeyEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.models.EmptyLineListener;
import jet.framework.util.ui.UIComponentHelper;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.portfolio.Portfolio;
import jet.shareplot.ac.portfolio.PortfolioApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.shareplot.util.BooleanConstants;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Event;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class PortfolioListNut extends AbstractSharePlotNut {

    private UITableComponent2 tableList;
    private UITableListDisplay3 uiTableListDisplay3;
    private final List<Portfolio> portfolios = new ArrayList<Portfolio>();
    private PortfolioApplicationComponent portfolioAC;
    private Portfolio emptyPortfolio;
    private EmptyPortfolioListener emptyPortfolioListener;
    private UIButtonComponent saveButton;
    private UIButtonComponent deleteButton;

    @Initializer
    public final void doPortfolioListNutInit() throws JETException {

        this.portfolioAC = PortfolioApplicationComponent.getInstance(getSession());

        getUIComponents();

        initPortfolioList();
        displayPortfolioList();
    }

    private void getUIComponents() throws JETException {
        this.saveButton = (UIButtonComponent) UIComponentFinder.findComponent("saveButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.saveButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.S));
        this.deleteButton = (UIButtonComponent) UIComponentFinder.findComponent("deleteButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.deleteButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.D));
    }

    private void displayPortfolioList() {
        removeEmptyPortfolio();
        this.uiTableListDisplay3.removeAll();
        this.portfolios.clear();

        this.uiTableListDisplay3.detachModel();
        final List<Portfolio> items = this.portfolioAC.getPortfolios();
        for (final Portfolio portfolioItem : items) {
            this.uiTableListDisplay3.addRow(portfolioItem.get_Model());
            this.portfolios.add(portfolioItem);
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

            this.emptyPortfolio = new Portfolio(this.portfolioAC);
            this.emptyPortfolio.setIsFake(BooleanConstants.NO);

            this.uiTableListDisplay3.addRow(this.emptyPortfolio.get_Model());
            this.portfolios.add(this.emptyPortfolio);
            this.emptyPortfolio.get_Model().addEventListener(this.emptyPortfolioListener);
        }
    }

    private boolean isEmptyPortfolioValid() {
        boolean result;
        if (this.emptyPortfolio == null) {
            result = true;
        } else {
            result = this.emptyPortfolio.isValid();
        }
        System.err.println("[PortfolioListNut] isEmptyPortfolioValid - " + result);
        return result;
    }

    private void removeEmptyPortfolio() {
        if (this.emptyPortfolio != null) {
            this.emptyPortfolio.get_Model().removeEventListener(this.emptyPortfolioListener);
            this.uiTableListDisplay3.removeRow(this.emptyPortfolio.get_Model());
            this.portfolios.remove(this.emptyPortfolio);
            this.emptyPortfolio = null;
        }
    }

    private class EmptyPortfolioListener extends EmptyLineListener {

        private static final long serialVersionUID = -1009201544110187098L;

        @Override
        protected <T extends Enum<T>> void handleChangedValue(final Event<T> event) {
            System.err.println("[PortfolioListNut.EmptyPortfolioListener] handleChangedValue - ");
            addEmptyPortfolio();
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
        // TODO Auto-generated method stub

    }

    private void processSave() {
        removeEmptyPortfolio();

        for (final Portfolio portfolio : this.portfolios) {
            try {
                portfolio.save();
            } catch (final FormatedJetException e) {
                // TODO display message for user
                logp(JETLevel.SEVERE, "PortfolioListNut", "processSave", e.getMessage(), e);
            }
        }

        addEmptyPortfolio();
    }

}
