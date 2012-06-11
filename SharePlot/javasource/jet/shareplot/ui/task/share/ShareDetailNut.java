package jet.shareplot.ui.task.share;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.container.managers.file.interfaces.FileManagerContext;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.manager.csv.interfaces.CSVLineProcessor;
import jet.framework.manager.csv.interfaces.CSVManagerContext;
import jet.framework.manager.csv.interfaces.CSVParameters;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.shareplot.ui.desktop.SharePlotACLauncher;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

public class ShareDetailNut extends AbstractSharePlotNut implements CSVLineProcessor {

    private Share share;
    private UIButtonComponent addChangeButton;
    private UIButtonComponent addValueButton;

    @Initializer
    public final void doShareDetailNutInit() throws JETException {

        this.share = (Share) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_SHARE);

        final Object[] args = { this.share.getName() };
        final Displayable titleDisp = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareDetailName", args);
        setHeaderTitle(titleDisp);

        this.addChangeButton = (UIButtonComponent) UIComponentFinder.findComponent("addChangeButton", getMainComponent());
        this.addValueButton = (UIButtonComponent) UIComponentFinder.findComponent("addValueButton", getMainComponent());
    }

    @Override
    public void componentClicked(final UIComponent component) {
        if (this.addChangeButton == component) {
            launchQuantityList(this.share);
        } else if (this.addValueButton == component) {
            launchValueList(this.share);
        }
    }

    private void launchValueList(final Share share2) {
        try {
            final CSVManagerContext csvCtxt = (CSVManagerContext) getManagerContext(CSVManagerContext.NAME);

            // get file content
            final FileManagerContext fileCtxt = (FileManagerContext) getManagerContext(FileManagerContext.NAME);
            final InputStream is = fileCtxt.getInputStream("/home/daniel/Downloads/easysys-export2.csv");
            final Reader reader = new InputStreamReader(is);

            // configure parameters
            final CSVParameters csvParameters = new CSVParameters();
            csvParameters.setLine(1);
            csvParameters.setSeparator(';');

            csvCtxt.readCSVFile(reader, this, csvParameters);
        } catch (final FileNotFoundException e) {
            logp(JETLevel.SEVERE, "ShareDetailNut", "launchValueList", e.getMessage(), e);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "ShareDetailNut", "launchValueList", e.getMessage(), e);
        }
    }

    private void launchQuantityList(final Share share) {
        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                final Map<String, Object> initArgs = new HashMap<String, Object>();
                initArgs.put(ShareUIConstants.ARGUMENT_SHARE, new Share(share));
                initArgs.put(SharePlotACLauncher.AC_KEY_PARAMETER, new ShareQuantityListNutKey(share.getIdShare()));

                acLauncher.launchApplicationComponent(TaskNameConstants.SHARE_QUANTITY, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "ShareDetailNut", "launchQuantityList", e.getMessage(), e);
            }
        }
    }

    @Override
    public void processCSVLine(final String[] csvLine) {
        System.err.println("[ShareDetailNut] processCSVLine - Length : " + csvLine.length);
        final StringBuilder sb = new StringBuilder();
        for (final String string : csvLine) {
            sb.append('[');
            sb.append(string);
            sb.append(']');
        }
    }

}
