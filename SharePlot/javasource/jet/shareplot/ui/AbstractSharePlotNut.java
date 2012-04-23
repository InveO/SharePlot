package jet.shareplot.ui;

import jet.container.nuts.ui.EventDrivenUINut;
import jet.framework.util.models.ModelHelper;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public abstract class AbstractSharePlotNut extends EventDrivenUINut {

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

}
