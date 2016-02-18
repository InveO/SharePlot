package jet.shareplot.ui.desktop.dialog;

import org.eclipse.jdt.annotation.NonNull;

import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.framework.ui.desktop.DesktopDialogHelper;
import jet.framework.ui.desktop.info.dialog.contexts.AbstractDialogContext;
import jet.framework.ui.desktop.info.dialog.contexts.MessageDialogContext;
import jet.framework.util.ui.LocalizedDisplayable;
import jet.java.util.JETLocale;
import jet.util.JetVersion;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;

/**
 * Dialog box helper class.
 *
 * @author daniel
 *
 */
public class SharePlotDialogHelper implements DesktopDialogHelper {

    private static final long serialVersionUID = 4641804985188680979L;
    private static final String VERSION_LABEL = "SharePlot/properties/desktop/Global/label.Version";
    private static final String SEND_LABEL = "SharePlot/properties/desktop/Buttons/button.Send";
    private static final String CANCEL_LABEL = "SharePlot/properties/desktop/Buttons/button.Cancel";
    private static final String OK_LABEL = "SharePlot/properties/desktop/Buttons/button.Ok";
    private static final String NO_LABEL = "SharePlot/properties/desktop/Buttons/button.No";
    private static final String YES_LABEL = "SharePlot/properties/desktop/Buttons/button.Yes";
    private static final String TITLE_FG_COLOR = "dialogTitleFGColor";
    private static final String TITLE_FONT = "dialogTitleFont";
    private static final String TITLE_BG_COLOR = "dialogTitleBGColor";
    private static final int DEFAULT_DIALOG_WIDTH = 450;
    private static final int DEFAULT_DIALOG_HEIGHT = 250;

    private final AbstractDesktopNut abstractDesktopNut;
    private final JETLocale locale;

    /**
     * Constructor. This should only be called by the desktop. It will then be registered in the session
     * and will be retrieved via the session when required.
     *
     * @param abstractDesktopNut Desktop nut
     * @param locale Locale in which the dialogs are to be displayed
     */
    public SharePlotDialogHelper(final AbstractDesktopNut abstractDesktopNut, final JETLocale locale) {
        this.abstractDesktopNut = abstractDesktopNut;
        this.locale = locale;
    }

    @Override
    public void displayMessageDialog(final String title, final String localizedTitle, final String message, final String localizedMessage) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);
        final Displayable mesDisp = new LocalizedDisplayable(message, localizedMessage);

        displayMessageDialog(titDisp, mesDisp);
    }

    @Override
    public void displayMessageDialog(final Displayable title, final Displayable message) {
        // bug 5264: log the content of the message dialogs
        final StringBuilder sb = new StringBuilder();
        sb.append(title.getDisplayableString(AnnotationsHelper.assertNonNull(this.locale)));
        sb.append("\n");
        sb.append(message.getDisplayableString(AnnotationsHelper.assertNonNull(this.locale)));
        this.abstractDesktopNut.logp(JETLevel.INFO, "SharePlotDialogHelper", "displayMessageDialog", sb.toString());

        final MessageDialogContext dialogContext = new MessageDialogContext(title, message, this.abstractDesktopNut.getSession());

        this.abstractDesktopNut.displayDialog(dialogContext);
    }

    private String getVersionDialogLabel() {
        final StringBuilder sb = new StringBuilder();
        final Displayable disp = new LocalizedDisplayable(null, VERSION_LABEL);
        sb.append(disp.getDisplayableString(AnnotationsHelper.assertNonNull(this.locale)));
        sb.append(" ");
        sb.append(getVersion());

        return sb.toString();
    }

    private String getVersion() {
        final JetVersion ver = this.abstractDesktopNut.getApplicationProxy().getApplicationVersion();
        return ver.getVersion();
    }

    @Override
    public <T> @NonNull T displayDialogBox(@NonNull final AbstractDialogContext<T> dialogContext) {
        this.abstractDesktopNut.displayDialog(dialogContext);
        return dialogContext.getResult();
    }

}
