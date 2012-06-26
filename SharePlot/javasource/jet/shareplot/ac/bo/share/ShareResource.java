package jet.shareplot.ac.bo.share;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Object used in the Share resource notifications
 *
 * @author JetToolsFramework
 */
public class ShareResource extends AbstractResourceNotification<Share> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}
     */
    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.share.ShareResource";

    private ResourceNotificationApplicationComponent resourceAC;

    /**
     * Constructor
     *
     * @param shareAC
     * @param share
     * @param type
     */
    public ShareResource(final ShareApplicationComponent shareAC, final Share share, final NOTIFICATION_TYPE type) {
        super("Share", share, type);

        try {
            this.resourceAC = ResourceNotificationApplicationComponent.getInstance(shareAC.getSession());
        } catch (final JETException e) {
            shareAC.logp(JETLevel.SEVERE, "ShareResource", "ShareResource", e.getMessage(), e);
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
