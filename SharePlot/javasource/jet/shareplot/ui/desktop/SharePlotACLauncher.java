package jet.shareplot.ui.desktop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.components.interfaces.ApplicationComponent;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.desktop.navigation.menu.CleanCloseException;
import jet.framework.ui.desktop.navigation.menu.LaunchACMenuPlugin;
import jet.framework.ui.desktop.navigation.menu.SwitchWindowMenuPlugin;
import jet.framework.ui.desktop.navigation.menu.TaskUnicityPlugin;
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
    private final TaskUnicityPlugin taskUnicityPlugin;
    private final SwitchWindowMenuPlugin switchWindowPlugin;
    /**
     * <code>AC_KEY_PARAMETER</code> ${value}
     */
    public final static String AC_KEY_PARAMETER = "jet.shareplot.ui.desktop.SharePlotACLauncher.AC_KEY_PARAMETER";

    SharePlotACLauncher(final LaunchACMenuPlugin launchACMenuPlugin, final List<ApplicationComponent> childApplicationComponents, final ApplicationComponent applicationComponent, final TaskUnicityPlugin taskUnicityPlugin, final SwitchWindowMenuPlugin switchWindowPlugin) {
        this.launchACMenuPlugin = launchACMenuPlugin;
        this.applicationComponent = applicationComponent;
        this.childApplicationComponents = childApplicationComponents;
        this.taskUnicityPlugin = taskUnicityPlugin;
        this.switchWindowPlugin = switchWindowPlugin;
    }

    @Override
    public ApplicationComponent launchApplicationComponent(final String acName, final Map<String, Object> initMap) throws JETException, CleanCloseException {
        Map<String, Object> initMap2 = initMap;
        if (initMap2 == null) {
            initMap2 = new HashMap<String, Object>();
        }
        final Object keyObject = initMap2.get(AC_KEY_PARAMETER);

        final TaskUnicityPlugin.UnicityKey unicityKey = this.taskUnicityPlugin.switchToExistingKeyInstance(keyObject);

        final ApplicationComponent ac;
        if (unicityKey.hasInstance()) {
            ac = unicityKey.getApplicationComponent();
        } else {
            ac = this.launchACMenuPlugin.performACLaunch(acName, this.applicationComponent, initMap2);
            this.childApplicationComponents.add(ac);
            this.taskUnicityPlugin.addInstance(keyObject, ac);
            this.switchWindowPlugin.addSwitchWindowMenuItem(ac);
        }

        return ac;
    }

}
