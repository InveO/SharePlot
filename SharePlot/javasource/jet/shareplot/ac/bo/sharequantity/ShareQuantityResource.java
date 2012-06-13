package jet.shareplot.ac.bo.sharequantity;

import jet.framework.util.pojo2.AbstractResourceNotification;

/**
 * Object used in the ShareQuantity resource notifications
 * 
 * @author JetToolsFramework
 */
public class ShareQuantityResource extends AbstractResourceNotification<ShareQuantity> {

    private static final long serialVersionUID = -5971798084595088560L;

    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.sharequantity.ShareQuantityResource";

    public ShareQuantityResource(final ShareQuantity shareQuantity, final NOTIFICATION_TYPE type) {
        super("ShareQuantity", shareQuantity, type);
    }

}
