package jet.shareplot.ui.desktop.pojo2;

import jet.container.managers.session.interfaces.Session;
import jet.framework.ui.desktop.DesktopDialogHelper;
import jet.framework.util.pojo2.InterceptorContext;
import jet.framework.util.pojo2.InterceptorValidationException;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.ui.desktop.dialog.DialogConstants;

/**
 * Implementation of the JFErrorHandler.
 * 
 * @author daniel
 * 
 */
public class SharePlotErrorHandler implements JFErrorHandler {

    private static final long serialVersionUID = 1415084048426887553L;
    private final DesktopDialogHelper dialogHelper;

    /**
     * Constructor.
     * 
     * @param session Current session
     */
    public SharePlotErrorHandler(final Session session) {
        this.dialogHelper = (DesktopDialogHelper) session.getProperty(DesktopDialogHelper.SESSION_KEY);
    }

    @Override
    public void displayError(final InterceptorValidationException e, final InterceptorContext interceptorContext) {
        this.dialogHelper.displayMessageDialog(null, DialogConstants.TITLE_INFO, e.getMessage(), e.getLocalizedMessage());
    }
}
