package jet.shareplot.ac;

import java.util.HashMap;
import java.util.Map;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.lifecycle.annotations.Deinitializer;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * Implementation of the SimpleApplicationComponent class
 * 
 * This is a generated file and should not be modified.
 *
 * @author JetTools
 * 
 */
public class SelectStoreApplicationComponent extends SimpleApplicationComponent {

    /**
     * ${value}
     */
    public final static String PORTFOLIO_SELECT = "PortfolioSelect";
    /**
     * ${value}
     */
    public final static String PORTFOLIO_STORE = "PortfolioStore";
	    
    /**
     * ${value}
     */
    public final static String SHARE_SELECT = "ShareSelect";
    /**
     * ${value}
     */
    public final static String SHARE_STORE = "ShareStore";
	    
    /**
     * ${value}
     */
    public final static String SHAREQUANTITY_SELECT = "ShareQuantitySelect";
    /**
     * ${value}
     */
    public final static String SHAREQUANTITY_STORE = "ShareQuantityStore";
	    
    /**
     * ${value}
     */
    public final static String SHAREVALUE_SELECT = "ShareValueSelect";
    /**
     * ${value}
     */
    public final static String SHAREVALUE_STORE = "ShareValueStore";
	    

    private static final long serialVersionUID = -8890923097443600938L;
	
    /**
     * <code>INTERNAL_SESSION_KEY</code> session key
     */
    private final static Object INTERNAL_SESSION_KEY = new SerializableKey(SelectStoreApplicationComponent.class, "INTERNAL_SESSION_KEY");
    /**
     * <code>NAME</code> of this application component, so it can be retreived easily.
     */
    private final static String NAME = "SelectStoreApplicationComponent";

    /**
     * Get an instance of a SelectStoreApplicationComponent. This method will ensure that the same instance is
     * used within the same session.
     * 
     * The <code>SelectStoreApplicationComponent</code> should not be deinitialized. This will be done
     * automatically when the session is closed.
     * 
     * @param session Session this <code>SelectStoreApplicationComponent</code> is to be linked to
     * @return SelectStoreApplicationComponent Instantiated SelectStoreApplicationComponent
     * @throws JETException
     */
    public static final SelectStoreApplicationComponent getInstance(final Session session) throws JETException {

        SelectStoreApplicationComponent currentAC = (SelectStoreApplicationComponent) session.getProperty(INTERNAL_SESSION_KEY);

        if (currentAC == null) {
            final AbstractDesktopNut desktopNut = (AbstractDesktopNut) session.getProperty(AbstractDesktopNut.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an AbstractDesktopNut for the desktop.");
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
                    throw new JETException("Could not instantiate the SelectStoreApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return currentAC;
    }
    
    /**
     * Deinit, internal use only
     * 
     * @throws JETException
     */
    @Deinitializer
    public final void doSelectStoreNutACDeinit() throws JETException {
        getSession().removeProperty(INTERNAL_SESSION_KEY);
    }

}
