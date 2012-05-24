package jet.shareplot.ui;

import jet.components.ui.container.common.UIContainerComponent;
import jet.components.ui.label.common.UILabelComponent;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.container.nuts.ui.EventDrivenUINut;
import jet.framework.util.models.ModelHelper;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public abstract class AbstractSharePlotNut extends EventDrivenUINut {

    private Displayable tabTitle;
    private Displayable headerTitle;

    /**
     * Get the node at the given path from the ApplicationComponent configuration
     * 
     * @param path XML node path
     * @return Node at the given path
     * @throws JETException
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
     * Set the header group title and the tab title
     * 
     * @param displayable Displayable title
     */
    public final void setTitle(final Displayable displayable) {
        setHeaderTitle(displayable);
        setTabTitle(displayable);
    }

    /**
     * Set the tab title
     * 
     * @param displayable
     */
    protected void setTabTitle(final Displayable displayable) {
        if (displayable != null) {
            this.tabTitle = displayable;
            ((UIContainerComponent) getMainComponent()).setDisplayable(displayable);
        }
    }

    /**
     * Set the header group title
     * 
     * @param displayable
     */
    protected void setHeaderTitle(final Displayable displayable) {
        if (displayable != null) {
            this.headerTitle = displayable;
            final UILabelComponent labelTitle = (UILabelComponent) UIComponentFinder.findOptionalComponent("titleLabel", getMainComponent());
            if (labelTitle != null) {
                labelTitle.setDisplayable(displayable);
            }
        }
    }

}
