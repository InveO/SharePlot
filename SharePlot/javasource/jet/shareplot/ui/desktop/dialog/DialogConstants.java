package jet.shareplot.ui.desktop.dialog;

import jet.framework.util.ui.LocalizedDisplayable;
import jet.util.models.interfaces.Displayable;

/**
 * Dialog box constants.
 * 
 * @author daniel
 * 
 */
public final class DialogConstants {

    /**
     * Title warning localization key.
     */
    public static final String TITLE_WARNING = "SharePlot/properties/desktop/Dialog/title.Warning";

    /**
     * Title error localization key.
     */
    public static final String TITLE_ERROR = "SharePlot/properties/desktop/Dialog/title.Error";

    /**
     * Title info localization key.
     */
    public static final String TITLE_INFO = "SharePlot/properties/desktop/Dialog/title.Info";

    /**
     * Title warning localization Displayable.
     */
    public static final Displayable DISP_TITLE_WARNING = new LocalizedDisplayable(null, TITLE_WARNING);
    /**
     * Title error localization Displayable.
     */
    public static final Displayable DISP_TITLE_ERROR = new LocalizedDisplayable(null, TITLE_ERROR);
    /**
     * Title info localization Displayable.
     */
    public static final Displayable DISP_TITLE_INFO = new LocalizedDisplayable(null, TITLE_INFO);

    private DialogConstants() {
        // do not instantiate
    }

}
