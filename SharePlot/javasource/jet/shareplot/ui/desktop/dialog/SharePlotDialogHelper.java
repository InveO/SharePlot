package jet.shareplot.ui.desktop.dialog;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.framework.ui.desktop.DesktopDialogHelper;
import jet.framework.ui.desktop.info.dialog.OKMessageDialogNut;
import jet.framework.ui.desktop.info.dialog.YesNoMessageDialogNut;
import jet.framework.util.ui.LocalizedDisplayable;
import jet.java.util.JETLocale;
import jet.util.JetVersion;
import jet.util.models.SimpleModelImpl;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;

public class SharePlotDialogHelper implements DesktopDialogHelper {

    private static final int DEFAULT_DIALOG_WIDTH = 450;
    private static final int DEFAULT_DIALOG_HEIGHT = 250;

    private final AbstractDesktopNut abstractDesktopNut;
    private final JETLocale locale;

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
        param.setAttribute(YesNoMessageDialogNut.LOCALIZED_YES_LABEL, "SharePlot/properties/desktop/Buttons/button.Yes");
        param.setAttribute(YesNoMessageDialogNut.LOCALIZED_NO_LABEL, "SharePlot/properties/desktop/Buttons/button.No");
        param.setAttribute(OKMessageDialogNut.VERSION, getVersionDialogLabel());

        this.abstractDesktopNut.displayDialog(title, DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT, "dialogTitleBGColor", "dialogTitleFont", "dialogTitleFGColor", param, "YesNoMessageDialog");

        Boolean result = null;
        result = (Boolean) param.getNodeValue();
        return result;
    }

    @Override
    public void displayMessageDialog(final String title, final String localizedTitle, final String message, final String localizedMessage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void displayMessageDialog(final Displayable title, final Displayable message) {
        // TODO Auto-generated method stub

    }

    @Override
    public String displayQuestionDialog(final String title, final String localizedTitle, final String message, final String localizedMessage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String displayQuestionDialog(final Displayable title, final Displayable message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void displayApplicationComponent(final String title, final String localizedTitle, final String acName, final Map<String, Object> initMap) {
        // TODO Auto-generated method stub

    }

    @Override
    public Model displayListTableDialog(final String title, final String localizedTitle, final List<Model> modelList, final Model listDisplayModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Model displayListTableDialog(final Displayable title, final List<Model> modelList, final Model listDisplayModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Model displaySendEmailDialogBox(final String title, final String localizedTitle, final String emailTitle, final String emailTo, final String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Model displaySendEmailDialogBox(final Displayable title, final String emailTitle, final String emailTo, final String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String displaySendDialogBox(final String title, final String localizedTitle, final String emailTitle, final String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String displaySendDialogBox(final Displayable title, final String emailTitle, final String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Locale getDialogLocale() {
        return this.locale.getLocale();
    }

    private String getVersionDialogLabel() {
        final StringBuilder sb = new StringBuilder();
        final Displayable disp = new LocalizedDisplayable(null, "SharePlot/properties/desktop/Global/label.Version");
        sb.append(disp.getDisplayableString(this.locale));
        sb.append(" ");
        sb.append(getVersion());

        return sb.toString();
    }

    private String getVersion() {
        final JetVersion ver = this.abstractDesktopNut.getApplicationProxy().getApplicationVersion();
        return ver.getVersion();
    }

}
