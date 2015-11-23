package jet.shareplot.ac.bo.sharequantity;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Object used in the ShareQuantity resource notifications.
 *
 * @author JetToolsFramework
 */
public class ShareQuantityResource extends AbstractResourceNotification<ShareQuantity> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}.
     */
    @NonNull
    public static final String RESOURCE_NAME = "jet.shareplot.ac.bo.sharequantity.ShareQuantityResource";

    private ResourceNotificationApplicationComponent resourceAC;

    private Long oldPK;

    /**
     * Constructor.
     *
     * @param shareQuantityAC ApplicationComponent
     * @param shareQuantity business object
     * @param type Notification type
     */
    public ShareQuantityResource(final AbstractShareQuantityBOApplicationComponent shareQuantityAC, final ShareQuantity shareQuantity, final NOTIFICATION_TYPE type) {
        super("ShareQuantity", shareQuantity, type);

        try {
            this.resourceAC = ResourceNotificationApplicationComponent.getInstance(shareQuantityAC.getSession());
        } catch (final JETException e) {
            shareQuantityAC.logp(JETLevel.SEVERE, "ShareQuantityResource", "ShareQuantityResource", e.getMessage(), e);
            this.resourceAC = null;
        }
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

    /**
     * @param oldPK
     */
    public void setOldPK(final Long oldPK) {
        this.oldPK = oldPK;
    }

    /**
     * @return oldPK value
     */
    public @Nullable Long getOldPK() {
        return this.oldPK;
    }
}
