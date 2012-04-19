package jet.shareplot.ui.desktop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.components.interfaces.ApplicationComponent;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.desktop.navigation.menu.LaunchACMenuPlugin;
import jet.util.throwable.JETException;

/**
 * @author drobinson
 * 
 */
public class SharePlotACLauncher implements ApplicationComponentLauncher, Serializable {

    private static final long serialVersionUID = 4274429305824460930L;
    private final LaunchACMenuPlugin launchACMenuPlugin;
    private final ApplicationComponent applicationComponent;
    private final List<ApplicationComponent> childApplicationComponents;

    SharePlotACLauncher(final LaunchACMenuPlugin launchACMenuPlugin, final List<ApplicationComponent> childApplicationComponents, final ApplicationComponent applicationComponent) {
        this.launchACMenuPlugin = launchACMenuPlugin;
        this.applicationComponent = applicationComponent;
        this.childApplicationComponents = childApplicationComponents;
    }

    @Override
    public ApplicationComponent launchApplicationComponent(final String acName, final Map<String, Object> initMap) throws JETException {
        Map<String, Object> initMap2 = initMap;
        if (initMap2 == null) {
            initMap2 = new HashMap<String, Object>();
        }

        final ApplicationComponent ac = this.launchACMenuPlugin.performACLaunch(acName, this.applicationComponent, initMap2);
        this.childApplicationComponents.add(ac);

        return ac;
    }

}
