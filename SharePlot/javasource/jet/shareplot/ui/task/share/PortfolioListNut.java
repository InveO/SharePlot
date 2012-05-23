package jet.shareplot.ui.task.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.components.ui.events.KeyEvent;
import jet.components.ui.events.MouseEvent;
import jet.components.ui.events.MouseEventType;
import jet.components.ui.events.UIEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.utils.table.CheckBoxSelectedCellProvider;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.models.EmptyLineListener;
import jet.framework.util.ui.UIComponentHelper;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.portfolio.PortfolioApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.shareplot.ui.task.TaskNameConstants;
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
    private CheckBoxSelectedCellProvider selectedCellProvider;

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

        this.selectedCellProvider = new CheckBoxSelectedCellProvider("colSelect");
        this.uiTableListDisplay3.addListTableCellModelProvider(this.selectedCellProvider);

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
        removeEmptyPortfolio();

        final List<Portfolio> toRemove = new ArrayList<Portfolio>();

        // find portfolios to delete, and delete in DB
        for (final Portfolio portfolio : this.portfolios) {
            final Boolean isSelected = this.selectedCellProvider.getSelectedState(portfolio.get_Model());
            if (isSelected.booleanValue()) {
                try {
                    // if is not new delete from db
                    portfolio.delete();

                    toRemove.add(portfolio);
                } catch (final FormatedJetException e) {
                    // TODO display error message
                    logp(JETLevel.SEVERE, "PortfolioListNut", "processDelete", e.getMessage(), e);
                }
            }
        }

        // remove from display
        for (final Portfolio portfolio : toRemove) {
            this.uiTableListDisplay3.removeRow(portfolio.get_Model());
            this.portfolios.remove(portfolio);
        }

        addEmptyPortfolio();
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

    @Override
    public <T extends Enum<T>> void tableCellEvent(final UITableComponent2 table, final int row, final int col, final UIEvent<T> uiEvent) {
        if (this.tableList == table) {
            if (uiEvent instanceof MouseEvent) {
                // if the row is double clicked the current contact must be edited
                final MouseEvent me = (MouseEvent) uiEvent;
                if (me.getType() == MouseEventType.LEFT_CLICK) {

                    final String colName = this.uiTableListDisplay3.getColumnName(col);

                    if ("editColumn".equals(colName)) {
                        final Portfolio portfolio = this.portfolios.get(row);
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

                acLauncher.launchApplicationComponent(TaskNameConstants.SHARE_LIST, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "PortfolioListNut", "launchEditPortfolio", e.getMessage(), e);
            }
        }
    }

}
