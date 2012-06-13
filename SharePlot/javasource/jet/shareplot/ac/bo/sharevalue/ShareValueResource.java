package jet.shareplot.ac.bo.sharevalue;

import jet.framework.util.pojo2.AbstractResourceNotification;

/**
 * Object used in the ShareValue resource notifications
 * 
 * @author JetToolsFramework
 */
public class ShareValueResource extends AbstractResourceNotification<ShareValue> {

    private static final long serialVersionUID = -5971798084595088560L;

    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.sharevalue.ShareValueResource";

    public ShareValueResource(final ShareValue shareValue, final NOTIFICATION_TYPE type) {
        super("ShareValue", shareValue, type);
    }

}
