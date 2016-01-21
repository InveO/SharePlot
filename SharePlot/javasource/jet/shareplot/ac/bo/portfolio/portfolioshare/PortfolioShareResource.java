package jet.shareplot.ac.bo.portfolio.portfolioshare;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Object used in the PortfolioShare resource notifications.
 *
 * @author JetToolsFramework
 */
public class PortfolioShareResource extends AbstractResourceNotification<PortfolioShare> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}.
     */
    @NonNull
    public static final String RESOURCE_NAME = "jet.shareplot.ac.bo.portfolio.portfolioshare.PortfolioShareResource";

    private ResourceNotificationApplicationComponent resourceAC;

    /**
     * Constructor.
     *
     * @param portfolioShareAC ApplicationComponent
     * @param portfolioShare business object
     * @param type Notification type
     */
    public PortfolioShareResource(final PortfolioShareBOApplicationComponent portfolioShareAC, final PortfolioShare portfolioShare, final NOTIFICATION_TYPE type) {
        super("PortfolioShare", portfolioShare, type);

        this.resourceAC = ResourceNotificationApplicationComponent.getInstance(portfolioShareAC.getSession());
    }

    /**
     * Send notification to resource listeners.
     *
     * @see jet.framework.util.pojo2.AbstractResourceNotification#notifyResource()
     */
    @Override
    public void notifyResource() {
        if (this.resourceAC != null) {
            this.resourceAC.notifyListeners(RESOURCE_NAME, this);
        }
    }

}
