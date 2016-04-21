package jet.shareplot.ac.bo.portfolio;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;

/**
 * Object used in the Portfolio resource notifications.
 *
 * @author JetToolsFramework
 */
public class PortfolioResource extends AbstractResourceNotification<Portfolio> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}.
     */
    @NonNull
    public static final String RESOURCE_NAME = "jet.shareplot.ac.bo.portfolio.PortfolioResource";
    private @NonNull final ResourceNotificationApplicationComponent resourceAC;
    private @Nullable Long oldPK;

    /**
     * Constructor.
     *
     * @param portfolioAC ApplicationComponent
     * @param portfolio business object
     * @param type Notification type
     */
    public PortfolioResource(@NonNull final AbstractPortfolioBOApplicationComponent portfolioAC, @NonNull final Portfolio portfolio, @NonNull final NOTIFICATION_TYPE type) {
        super("Portfolio", portfolio, type);

        this.resourceAC = ResourceNotificationApplicationComponent.getInstance(portfolioAC.getSession());
    }

    /**
     * Send notification to resource listeners.
     *
     * @see jet.framework.util.pojo2.AbstractResourceNotification#notifyResource()
     */
    @Override
    public void notifyResource() {
        this.resourceAC.notifyListeners(RESOURCE_NAME, this);
    }

    /**
     * @param oldPK
     */
    public void setOldPK(@Nullable final Long oldPK) {
        this.oldPK = oldPK;
    }

    /**
     * @return oldPK value
     */
    public @Nullable Long getOldPK() {
        return this.oldPK;
    }
}
