package jet.shareplot.ac.bo.sharequantity;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Object used in the ShareQuantity resource notifications
 *
 * @author JetToolsFramework
 */
public class ShareQuantityResource extends AbstractResourceNotification<ShareQuantity> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}
     */
    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.sharequantity.ShareQuantityResource";

    private ResourceNotificationApplicationComponent resourceAC;

    /**
     * Constructor
     *
     * @param shareQuantityAC
     * @param shareQuantity
     * @param type
     */
    public ShareQuantityResource(final ShareQuantityApplicationComponent shareQuantityAC, final ShareQuantity shareQuantity, final NOTIFICATION_TYPE type) {
        super("ShareQuantity", shareQuantity, type);

        try {
            this.resourceAC = ResourceNotificationApplicationComponent.getInstance(shareQuantityAC.getSession());
        } catch (final JETException e) {
            shareQuantityAC.logp(JETLevel.SEVERE, "ShareQuantityResource", "ShareQuantityResource", e.getMessage(), e);
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
