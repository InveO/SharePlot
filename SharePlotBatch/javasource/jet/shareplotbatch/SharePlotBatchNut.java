package jet.shareplotbatch;

import java.util.List;

import jet.container.nuts.Nut;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.portfolio.PortfolioBOApplicationComponent;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

public class SharePlotBatchNut extends Nut {

    @Initializer
    public final void doSharePlotBatchNutInit() {
        try {
            final PortfolioBOApplicationComponent portfolioAC = PortfolioBOApplicationComponent.getInstance(getSession());

            final List<Portfolio> portfolios = portfolioAC.getPortfolios();
            for (final Portfolio portfolio : portfolios) {
                System.err.println("[SharePlotBatchNut] doSharePlotBatchNutInit - " + portfolio.getName());
            }
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "SharePlotBatchNut", "doSharePlotBatchNutInit", e.getMessage(), e);
        }
    }

}
