package jet.shareplot.ui.task.share;

import java.util.HashMap;
import java.util.Map;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

public class ShareDetailNut extends AbstractSharePlotNut {

    private Share share;
    private UIButtonComponent addChangeButton;

    @Initializer
    public final void doShareDetailNutInit() throws JETException {

        this.share = (Share) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_SHARE);

        final Object[] args = { this.share.getName() };
        final Displayable titleDisp = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareDetail", args);
        setHeaderTitle(titleDisp);

        this.addChangeButton = (UIButtonComponent) UIComponentFinder.findComponent("addChangeButton", getMainComponent());
    }

    @Override
    public void componentClicked(final UIComponent component) {
        if (this.addChangeButton == component) {
            launchQuantityList(this.share);
        }
    }

    private void launchQuantityList(final Share share) {
        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                final Map<String, Object> initArgs = new HashMap<String, Object>();
                initArgs.put(ShareUIConstants.ARGUMENT_SHARE, new Share(share));

                acLauncher.launchApplicationComponent(TaskNameConstants.SHARE_QUANTITY, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "ShareDetailNut", "launchQuantityList", e.getMessage(), e);
            }
        }
    }

}
