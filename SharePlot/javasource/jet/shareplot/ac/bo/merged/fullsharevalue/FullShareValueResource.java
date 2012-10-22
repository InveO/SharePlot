package jet.shareplot.ac.bo.merged.fullsharevalue;

import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.util.pojo2.AbstractResourceNotification;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Object used in the FullShareValue resource notifications
 *
 * @author JetToolsFramework
 */
public class FullShareValueResource extends AbstractResourceNotification<FullShareValue> {

    private static final long serialVersionUID = -5971798084595088560L;

    /**
     * Resource name : {@value}
     */
    public final static String RESOURCE_NAME = "jet.shareplot.ac.bo.merged.fullsharevalue.FullShareValueResource";

    private ResourceNotificationApplicationComponent resourceAC;

    /**
     * Constructor
     *
     * @param fullShareValueAC
     * @param fullShareValue
     * @param type
     */
    public FullShareValueResource(final FullShareValueApplicationComponent fullShareValueAC, final FullShareValue fullShareValue, final NOTIFICATION_TYPE type) {
        super("FullShareValue", fullShareValue, type);

        try {
            this.resourceAC = ResourceNotificationApplicationComponent.getInstance(fullShareValueAC.getSession());
        } catch (final JETException e) {
            fullShareValueAC.logp(JETLevel.SEVERE, "FullShareValueResource", "FullShareValueResource", e.getMessage(), e);
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
