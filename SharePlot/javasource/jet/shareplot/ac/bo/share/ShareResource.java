package jet.shareplot.ac.bo.share;

import jet.framework.util.pojo2.AbstractResourceNotification;

/**
 * Object used in the Share resource notifications
 * 
 * @author JetToolsFramework
 */
public class ShareResource extends AbstractResourceNotification<Share> {

    private static final long serialVersionUID = -5971798084595088560L;

    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.share.ShareResource";

    public ShareResource(final Share share, final NOTIFICATION_TYPE type) {
        super("Share", share, type);
    }

}
