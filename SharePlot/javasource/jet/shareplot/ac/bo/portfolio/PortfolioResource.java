package jet.shareplot.ac.bo.portfolio;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Object used in the Portfolio resource notifications
 *
 * @author JetToolsFramework
 */
public class PortfolioResource extends AbstractResourceNotification<Portfolio> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}
     */
    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.portfolio.PortfolioResource";

    private ResourceNotificationApplicationComponent resourceAC;

    /**
     * Constructor
     *
     * @param portfolioAC
     * @param portfolio
     * @param type
     */
    public PortfolioResource(final PortfolioApplicationComponent portfolioAC, final Portfolio portfolio, final NOTIFICATION_TYPE type) {
        super("Portfolio", portfolio, type);

        try {
            this.resourceAC = ResourceNotificationApplicationComponent.getInstance(portfolioAC.getSession());
        } catch (final JETException e) {
            portfolioAC.logp(JETLevel.SEVERE, "PortfolioResource", "PortfolioResource", e.getMessage(), e);
            this.resourceAC = null;
        }
    }

    /**
     * @see jet.framework.util.pojo2.AbstractResourceNotification#notifyResource()
     */
    @Override
    public void notifyResource() {
        if (this.resourceAC != null) {
            this.resourceAC.notifyListeners(RESOURCE_NAME, this);
        }
    }

}
