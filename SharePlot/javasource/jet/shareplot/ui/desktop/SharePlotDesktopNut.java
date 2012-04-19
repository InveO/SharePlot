package jet.shareplot.ui.desktop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jet.components.interfaces.ApplicationComponent;
import jet.components.ui.container.common.UIContainerComponent;
import jet.components.ui.label.common.UILabelComponent;
import jet.container.managers.session.interfaces.SessionManagerContext;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.container.nuts.ui.UIAnchorService;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.desktop.navigation.menu.DesktopMenuPlugin;
import jet.framework.ui.desktop.navigation.menu.DesktopMenuPluginListener;
import jet.framework.ui.desktop.navigation.menu.LaunchACMenuPlugin;
import jet.framework.ui.desktop.navigation.menu.LaunchACMenuPluginListener;
import jet.framework.util.desktop.navigation.menu.ActionModel;
import jet.framework.util.desktop.navigation.menu.MenuItemModel;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.annotations.Initializer;
import jet.util.JetVersion;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * @author drobinson
 * 
 */
public class SharePlotDesktopNut extends AbstractDesktopNut implements DesktopMenuPluginListener, LaunchACMenuPluginListener {

    private static final long serialVersionUID = 4588448882094005306L;
    private static final String EDITOR_GROUP = "bodyGroup";
    /**
     * <code>ANCHOR_EDITOR</code>
     */
    public static final String ANCHOR_EDITOR = "ANCHOR_EDITOR";

    /**
     * <code>PROPERTY_MENU_ITEM</code>
     */
    public static final Object PROPERTY_MENU_ITEM = new SerializableKey(SharePlotDesktopNut.class, "PROPERTY_MENU_ITEM");

    private DesktopMenuPlugin desktopMenuPlugin;
    private final List<ApplicationComponent> childApplicationComponents = new ArrayList<ApplicationComponent>();
    private LaunchACMenuPlugin launchACMenuPlugin;

    /**
     * Init, internal use only
     * 
     * @throws JETException
     */
    @Initializer
    public final void doSharePlotDesktopNutInit() throws JETException {
        // add timeout mechanism
        final SessionManagerContext smc = (SessionManagerContext) getManagerContext(SessionManagerContext.NAME);
        // session timeout after 12 hours
        smc.setSessionTimeout(getSession(), 12 * 60 * 60 * 1000);
        // refresh session if screen active every 30 minutes
        smc.setRefreshTimer(getSession(), 30 * 60 * 1000);

        this.desktopMenuPlugin = new DesktopMenuPlugin(getSession(), getUIContext(), getLogger());

        this.desktopMenuPlugin.initializeMenu(getMainComponent(), SharePlotMenuConstants.GROUP_MAIN_MENU, SharePlotMenuConstants.MAIN_MENU_BAR);
        this.desktopMenuPlugin.setDesktopMenuPluginListener(this);

        this.launchACMenuPlugin = new LaunchACMenuPlugin(ANCHOR_EDITOR, getLogger());
        this.launchACMenuPlugin.setLaunchACMenuPluginListener(this);

        addAnchorToAnchorService(getUIAnchorService(), ANCHOR_EDITOR, EDITOR_GROUP);

        final SharePlotACLauncher shareplotACLauncher = new SharePlotACLauncher(this.launchACMenuPlugin, this.childApplicationComponents, getApplicationComponent());
        getSession().setProperty(ApplicationComponentLauncher.SESSION_KEY, shareplotACLauncher);

        final UILabelComponent versionLabel = (UILabelComponent) UIComponentFinder.findComponent("labelVersionNumber", getMainComponent());
        final JetVersion ver = getApplicationProxy().getApplicationVersion();
        versionLabel.setText(ver.getVersion() + "  " + ver.getTime());

    }

    /**
     * De init, internal use only
     * 
     * @throws JETException
     */
    @Deinitializer
    public final void doSharePlotDesktopNutDeinitialization() throws JETException {
        getSession().removeProperty(ApplicationComponentLauncher.SESSION_KEY);
        final int size = this.childApplicationComponents.size();
        for (int i = 0; i < size; i++) {
            final ApplicationComponent ac = this.childApplicationComponents.get(0);
            logp(JETLevel.INFO, "SharePlotDesktopNut", "doSharePlotDesktopNutDeinitialization", "Deinitializing : " + ac.getName());
            ac.getInitializableSupport().deinitialize();
        }
    }

    private void addAnchorToAnchorService(final UIAnchorService anchorService, final String anchorName, final String groupName) throws JETException {
        final UIContainerComponent group = (UIContainerComponent) UIComponentFinder.findComponent(groupName, getMainComponent());
        anchorService.addAnchor(anchorName, group);
    }

    // DesktopMenuPluginListener
    @Override
    public void performMenuAction(final ActionModel action, final MenuItemModel menuItemModel) {

        logp(JETLevel.INFO, "SharePlotDesktopNut", "performMenuAction", action.getId());

        final String actionType = action.getType();
        if (LaunchACMenuPlugin.ACTION_TYPE.equals(actionType)) {
            final ApplicationComponent ac = this.launchACMenuPlugin.performACLaunch(action, this);
            if (ac != null) {
                this.childApplicationComponents.add(ac);
                ac.setProperty(PROPERTY_MENU_ITEM, menuItemModel);
            }
        }
    }

    @Override
    public void childACDeinitializeCleanup(final ApplicationComponent ac) {
        this.childApplicationComponents.remove(ac);
    }

    @Override
    public void getChildACParameters(final Map<String, Object> initMap) {
        // nothing to do
        initMap.put(UIAnchorService.PARAM_FRAME_HEIGHT, Integer.valueOf(480));
        initMap.put(UIAnchorService.PARAM_FRAME_WIDTH, Integer.valueOf(640));
    }

}
