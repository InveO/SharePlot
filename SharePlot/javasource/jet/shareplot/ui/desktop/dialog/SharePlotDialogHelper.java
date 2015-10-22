package jet.shareplot.ui.desktop.dialog;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.container.nuts.Nut;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.framework.ui.desktop.DesktopDialogHelper;
import jet.framework.ui.desktop.info.dialog.AbstractDialogNut;
import jet.framework.ui.desktop.info.dialog.ListDialogParameterModel;
import jet.framework.ui.desktop.info.dialog.ListTableDialogNut;
import jet.framework.ui.desktop.info.dialog.OKMessageDialogNut;
import jet.framework.ui.desktop.info.dialog.QuestionDialogNut;
import jet.framework.ui.desktop.info.dialog.SendEmailDialogNut;
import jet.framework.ui.desktop.info.dialog.YesNoMessageDialogNut;
import jet.framework.util.ui.LocalizedDisplayable;
import jet.java.util.JETLocale;
import jet.util.JetVersion;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.models.SimpleModelImpl;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETSystemError;

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
    public Boolean displayYesNoDialog(final String title, final String localizedTitle, final String message, final String localizedMessage) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);
        final Displayable mesDisp = new LocalizedDisplayable(message, localizedMessage);

        return displayYesNoDialog(titDisp, mesDisp);
    }

    @Override
    public Boolean displayYesNoDialog(final Displayable title, final Displayable message) {
        final Model param = new SimpleModelImpl();
        param.setAttribute(YesNoMessageDialogNut.LOCALIZED_MESSAGE, message);
        param.setAttribute(YesNoMessageDialogNut.LOCALIZED_YES_LABEL, YES_LABEL);
        param.setAttribute(YesNoMessageDialogNut.LOCALIZED_NO_LABEL, NO_LABEL);
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR, param, "YesNoMessageDialog");

        Boolean result = null;
        result = (Boolean) param.getNodeValue();
        return result;
    }

    @Override
    public void displayMessageDialog(final String title, final String localizedTitle, final String message, final String localizedMessage) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);
        final Displayable mesDisp = new LocalizedDisplayable(message, localizedMessage);

        displayMessageDialog(titDisp, mesDisp);
    }

    @Override
    public void displayMessageDialog(final Displayable title, final Displayable message) {
        final Model param = new SimpleModelImpl();
        param.setAttribute(OKMessageDialogNut.LOCALIZED_MESSAGE, message);
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());

        // bug 5264: log the content of the message dialogs
        final StringBuilder sb = new StringBuilder();
        sb.append(title.getDisplayableString(AnnotationsHelper.assertNonNull(this.locale)));
        sb.append("\n");
        sb.append(message.getDisplayableString(AnnotationsHelper.assertNonNull(this.locale)));
        this.abstractDesktopNut.logp(JETLevel.INFO, "SharePlotDialogHelper", "displayMessageDialog", sb.toString());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR, param, "OKMessageDialog");
    }

    @Override
    public String displayQuestionDialog(final String title, final String localizedTitle, final String message, final String localizedMessage) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);
        final Displayable mesDisp = new LocalizedDisplayable(message, localizedMessage);

        return displayQuestionDialog(titDisp, mesDisp);
    }

    @Override
    public String displayQuestionDialog(final Displayable title, final Displayable message) {
        final Model param = new SimpleModelImpl();
        param.setAttribute(QuestionDialogNut.LOCALIZED_MESSAGE, message);
        param.setAttribute(QuestionDialogNut.LOCALIZED_OK_LABEL, OK_LABEL);
        param.setAttribute(QuestionDialogNut.LOCALIZED_KO_LABEL, CANCEL_LABEL);
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR, param, "QuestionDialog");

        String result = null;
        result = (String) param.getNodeValue();
        return result;
    }

    @Override
    public @NonNull Model displayApplicationComponent(@Nullable final String title, @NonNull final String localizedTitle, @NonNull final String acName, final int width, final int height, @NonNull final Map<@NonNull String, @Nullable Object> initMap) {
        throw new JETSystemError("Not implemented");
    }

    @Override
    public Model displayApplicationComponent(final String title, final String localizedTitle, final String acName, final Map<String, Object> initMap) {
        final Model param = new SimpleModelImpl();
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());
        initMap.put(Nut.USER_DEFINED_PARAMETERS, param);
        this.abstractDesktopNut.displayDialogApplicationComponent(acName, this.abstractDesktopNut.getApplicationComponent(), initMap, title, localizedTitle, DEFAULT_DIALOG_WIDTH * 2, DEFAULT_DIALOG_HEIGHT * 2, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR);

        return param;
    }

    @Override
    public Model displayListTableDialog(final String title, final String localizedTitle, final List<@NonNull Model> modelList, final Model listDisplayModel) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);

        return displayListTableDialog(titDisp, modelList, listDisplayModel);
    }

    @Override
    public Model displayListTableDialog(final Displayable title, final List<@NonNull Model> modelList, final Model listDisplayModel) {
        final ListDialogParameterModel listDialogParameterModel = new ListDialogParameterModel(modelList, listDisplayModel, "SharePlot/properties/desktop/Buttons/button.Select", null, CANCEL_LABEL, null);

        final Model param = new SimpleModelImpl();
        param.setAttribute(ListTableDialogNut.LISTDIALOGPARAMETERMODEL, listDialogParameterModel);
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR, param, "ListTableDialog");

        Model result = null;
        result = (Model) param.getNodeValue();
        return result;
    }

    @Override
    public Model displaySendEmailDialogBox(final String title, final String localizedTitle, final String emailTitle, final String emailTo, final String message) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);

        return displaySendEmailDialogBox(titDisp, emailTitle, emailTo, message);
    }

    @Override
    public Model displaySendEmailDialogBox(final Displayable title, final String emailTitle, final String emailTo, final String message) {
        final Model param = new SimpleModelImpl();
        param.setAttribute(SendEmailDialogNut.MESSAGE, message);
        param.setAttribute(SendEmailDialogNut.TITLE, emailTitle);
        param.setAttribute(SendEmailDialogNut.EMAILTO, emailTo);
        param.setAttribute(SendEmailDialogNut.LOCALIZED_SEND_LABEL, SEND_LABEL);
        param.setAttribute(SendEmailDialogNut.LOCALIZED_CANCEL_LABEL, CANCEL_LABEL);
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR, param, "SendEmailDialog");

        final Model result = (Model) param.getNodeValue();
        return result;
    }

    @Override
    public String displaySendDialogBox(final String title, final String localizedTitle, final String emailTitle, final String message) {
        final Displayable titDisp = new LocalizedDisplayable(title, localizedTitle);

        return displaySendDialogBox(titDisp, emailTitle, message);
    }

    @Override
    public String displaySendDialogBox(final Displayable title, final String emailTitle, final String message) {
        final Model param = new SimpleModelImpl();
        param.setAttribute(SendEmailDialogNut.MESSAGE, message);
        param.setAttribute(SendEmailDialogNut.TITLE, emailTitle);
        param.setAttribute(SendEmailDialogNut.LOCALIZED_SEND_LABEL, SEND_LABEL);
        param.setAttribute(SendEmailDialogNut.LOCALIZED_CANCEL_LABEL, CANCEL_LABEL);
        param.setAttribute(AbstractDialogNut.VERSION, getVersionDialogLabel());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, TITLE_BG_COLOR, TITLE_FONT, TITLE_FG_COLOR, param, "SendDialog");

        final String result = (String) param.getNodeValue();
        return result;
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
    public String displayQuestionDialog(final String title, final String localizedTitle, final String message, final String localizedMessage, final String defaultValue) {
        // nothing to do for the moment
        return null;
    }

    @Override
    public String displayQuestionDialog(final Displayable title, final Displayable message, final String defaultValue) {
        // nothing to do for the moment
        return null;
    }

}
