package jet.shareplot.ui.desktop.dialog;

import jet.framework.util.ui.LocalizedDisplayable;
import jet.util.models.interfaces.Displayable;

public final class DialogConstants {

    private DialogConstants() {
        // do not instantiate
    }

    /**
     * {@value}
     */
    public final static String TITLE_WARNING = "SharePlot/properties/desktop/Dialog/title.Warning";

    /**
     * {@value}
     */
    public final static String TITLE_ERROR = "SharePlot/properties/desktop/Dialog/title.Error";

    /**
     * {@value}
     */
    public final static String TITLE_INFO = "SharePlot/properties/desktop/Dialog/title.Info";

    /**
     * {@value}
     */
    public final static Displayable DISP_TITLE_WARNING = new LocalizedDisplayable(null, TITLE_WARNING);
    /**
     * {@value}
     */
    public final static Displayable DISP_TITLE_ERROR = new LocalizedDisplayable(null, TITLE_ERROR);
    /**
     * {@value}
     */
    public final static Displayable DISP_TITLE_INFO = new LocalizedDisplayable(null, TITLE_INFO);

}
