package jet.shareplot.ac;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.AbstractSelectStoreApplicationComponent;
import jet.framework.nuts.desktop.JetDesktop;
import jet.framework.util.exception.ACLaunchException;
import jet.lifecycle.annotations.Deinitializer;
import jet.util.SerializableKey;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Implementation of the AbstractSelectStoreApplicationComponent class.
 *
 * This is a generated file and should not be modified.
 *
 * @author JetTools
 */
public class SelectStoreApplicationComponent extends AbstractSelectStoreApplicationComponent {

    /**
     * {@value}.
     */
    public static final @NonNull String PORTFOLIO_STORE = "PortfolioStore";

    /**
     * {@value}.
     */
    public static final @NonNull String SHARE_STORE = "ShareStore";

    /**
     * {@value}.
     */
    public static final @NonNull String SHAREQUANTITY_STORE = "ShareQuantityStore";

    /**
     * {@value}.
     */
    public static final @NonNull String SHAREVALUE_STORE = "ShareValueStore";

    private static final long serialVersionUID = -8890923097443600938L;

    /**
     * <code>INTERNAL_SESSION_KEY</code> session key.
     */
    private static final Object INTERNAL_SESSION_KEY = new SerializableKey(SelectStoreApplicationComponent.class, "INTERNAL_SESSION_KEY");
    /**
     * <code>NAME</code> of this application component, so it can be retreived easily.
     */
    private static final String NAME = "SelectStoreApplicationComponent";

    /**
     * Get an instance of a SelectStoreApplicationComponent. This method will ensure that the same instance is
     * used within the same session.
     *
     * The <code>SelectStoreApplicationComponent</code> should not be deinitialized. This will be done
     * automatically when the session is closed.
     *
     * @param session Session this <code>SelectStoreApplicationComponent</code> is to be linked to
     * @return SelectStoreApplicationComponent Instantiated SelectStoreApplicationComponent
     * @throws ACLaunchException
     */
    public static final @NonNull SelectStoreApplicationComponent getInstance(final Session session) throws ACLaunchException {
        SelectStoreApplicationComponent currentAC = (SelectStoreApplicationComponent) session.getProperty(INTERNAL_SESSION_KEY);

        if (currentAC == null) {
            final JetDesktop desktopNut = (JetDesktop) session.getProperty(JetDesktop.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new ACLaunchException("Can only be used with an JetDesktop for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    currentAC = (SelectStoreApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(currentAC);
                    session.setProperty(INTERNAL_SESSION_KEY, currentAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new ACLaunchException("Could not instantiate the SelectStoreApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new ACLaunchException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return currentAC;
    }

    /**
     * Deinit, internal use only.
     */
    @Deinitializer
    public final void doSelectStoreNutACDeinit() {
        getSession().removeProperty(INTERNAL_SESSION_KEY);
    }
}
