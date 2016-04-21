package jet.shareplot.ac.bo.sharevalue;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;

/**
 * Object used in the ShareValue resource notifications.
 *
 * @author JetToolsFramework
 */
public class ShareValueResource extends AbstractResourceNotification<ShareValue> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}.
     */
    @NonNull
    public static final String RESOURCE_NAME = "jet.shareplot.ac.bo.sharevalue.ShareValueResource";
    private @NonNull final ResourceNotificationApplicationComponent resourceAC;
    private @Nullable Long oldPK;

    /**
     * Constructor.
     *
     * @param shareValueAC ApplicationComponent
     * @param shareValue business object
     * @param type Notification type
     */
    public ShareValueResource(@NonNull final AbstractShareValueBOApplicationComponent shareValueAC, @NonNull final ShareValue shareValue, @NonNull final NOTIFICATION_TYPE type) {
        super("ShareValue", shareValue, type);

        this.resourceAC = ResourceNotificationApplicationComponent.getInstance(shareValueAC.getSession());
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
