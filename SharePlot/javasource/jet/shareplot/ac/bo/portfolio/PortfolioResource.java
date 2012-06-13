package jet.shareplot.ac.bo.portfolio;

import jet.framework.util.pojo2.AbstractResourceNotification;

public class PortfolioResource extends AbstractResourceNotification<Portfolio> {

    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.portfolio.PortfolioResource";

    public PortfolioResource(final Portfolio portfolio, final NOTIFICATION_TYPE type) {
        super("Portfolio", portfolio, type);
    }

}
