package jet.shareplot.ui;

import jet.components.ui.container.common.UIContainerComponent;
import jet.components.ui.label.common.UILabelComponent;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.container.nuts.ui.EventDrivenUINut;
import jet.framework.ui.desktop.DesktopDialogHelper;
import jet.framework.util.models.ModelHelper;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Abstract SharePlot nut. This will provide some base functionality.
 * 
 * @author daniel
 * 
 */
public abstract class AbstractSharePlotNut extends EventDrivenUINut {

    private static final long serialVersionUID = -7803626806863548106L;

    private DesktopDialogHelper dialogHelper;

    /**
     * Get the node at the given path from the ApplicationComponent configuration.
     * 
     * @param path XML node path
     * @return Node at the given path
     * @throws JETException If configuration path does not exist.
     */
    protected final Model getConfigurationNode(final String path) throws JETException {
        final Model acConfig = getApplicationComponent().getConfiguration();
        final Model listDisplayModel = ModelHelper.getChild(acConfig, path);
        if (listDisplayModel == null) {
            throw new JETException("The desired path is missing in the APPLICATION_COMPONENT configuration : " + path);
        }
        return listDisplayModel;
    }

    /**
     * Set the header group title and the tab title.
     * 
     * @param displayable Displayable title
     */
    public final void setTitle(final Displayable displayable) {
        setHeaderTitle(displayable);
        setTabTitle(displayable);
    }

    /**
     * Set the tab title.
     * 
     * @param displayable Title to display in the tab
     */
    protected void setTabTitle(final Displayable displayable) {
        if (displayable != null) {
            ((UIContainerComponent) getMainComponent()).setDisplayable(displayable);
        }
    }

    /**
     * Set the header group title.
     * 
     * @param displayable Title to display in the header
     */
    protected void setHeaderTitle(final Displayable displayable) {
        if (displayable != null) {
            final UILabelComponent labelTitle = (UILabelComponent) UIComponentFinder.findOptionalComponent("titleLabel", getMainComponent());
            if (labelTitle != null) {
                labelTitle.setDisplayable(displayable);
            }
        }
    }

    /**
     * Get the DesktopDialogHelper. This should eb registered in the session by the Deksktop.
     * 
     * @return DesktopDialogHelper
     */
    protected final DesktopDialogHelper getDesktopDialogHelper() {
        if (this.dialogHelper == null) {
            this.dialogHelper = (DesktopDialogHelper) getSession().getProperty(DesktopDialogHelper.SESSION_KEY);
        }
        return this.dialogHelper;
    }

}
