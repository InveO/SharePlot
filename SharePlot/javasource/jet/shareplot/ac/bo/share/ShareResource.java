package jet.shareplot.ac.bo.share;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;

/**
 * Object used in the Share resource notifications.
 *
 * @author JetToolsFramework
 */
public class ShareResource extends AbstractResourceNotification<Share> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}.
     */
    @NonNull
    public static final String RESOURCE_NAME = "jet.shareplot.ac.bo.share.ShareResource";
    private @NonNull final ResourceNotificationApplicationComponent resourceAC;
    private @Nullable Long oldPK;

    /**
     * Constructor.
     *
     * @param shareAC ApplicationComponent
     * @param share business object
     * @param type Notification type
     */
    public ShareResource(@NonNull final AbstractShareBOApplicationComponent shareAC, @NonNull final Share share, @NonNull final NOTIFICATION_TYPE type) {
        super("Share", share, type);

        this.resourceAC = ResourceNotificationApplicationComponent.getInstance(shareAC.getSession());
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
