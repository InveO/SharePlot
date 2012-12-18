package jet.shareplotbatch;

import java.util.List;

import jet.framework.component.SelectStoreProvider;
import jet.framework.manager.batchsession.interfaces.BatchSessionListener;
import jet.framework.nuts.desktop.AbstractBatchDesktopNut;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.portfolio.PortfolioBOApplicationComponent;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class SharePlotBatchNut extends AbstractBatchDesktopNut implements BatchSessionListener {

    @Initializer
    public final void doSharePlotBatchNutInit() {

        try {
            // place SelectStoreProvider in session so it can be used from the SimpleApplicationComponent
            final SelectStoreApplicationComponent selectStoreProvider = SelectStoreApplicationComponent.getInstance(getSession());
            getSession().setProperty(SelectStoreProvider.SELECT_STORE_SESSION_KEY, selectStoreProvider);

            getSession().setProperty(BatchSessionListener.SESSION_KEY, this);

            System.err.println("[SharePlotBatchNut] doSharePlotBatchNutInit - " + getSession());

            final PortfolioBOApplicationComponent portfolioAC = PortfolioBOApplicationComponent.getInstance(getSession());

            final List<Portfolio> portfolios = portfolioAC.getPortfolios();
            for (final Portfolio portfolio : portfolios) {
                System.err.println("[SharePlotBatchNut] doSharePlotBatchNutInit - " + portfolio.getName());
            }
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "SharePlotBatchNut", "doSharePlotBatchNutInit", e.getMessage(), e);
        }
    }

    @Override
    public void processSessionUpdate(final Model argument) {
        logp(JETLevel.SEVERE, "SharePlotBatchNut", "processSessionUpdate", "Argument :: " + argument);
    }

}
