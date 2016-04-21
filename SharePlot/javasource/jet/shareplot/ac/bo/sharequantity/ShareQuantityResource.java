package jet.shareplot.ac.bo.sharequantity;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;

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
    private @NonNull final ResourceNotificationApplicationComponent resourceAC;
    private @Nullable Long oldPK;

    /**
     * Constructor.
     *
     * @param shareQuantityAC ApplicationComponent
     * @param shareQuantity business object
     * @param type Notification type
     */
    public ShareQuantityResource(@NonNull final AbstractShareQuantityBOApplicationComponent shareQuantityAC, @NonNull final ShareQuantity shareQuantity, @NonNull final NOTIFICATION_TYPE type) {
        super("ShareQuantity", shareQuantity, type);

        this.resourceAC = ResourceNotificationApplicationComponent.getInstance(shareQuantityAC.getSession());
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
