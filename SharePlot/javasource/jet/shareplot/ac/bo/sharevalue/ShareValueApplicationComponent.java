package jet.shareplot.ac.bo.sharevalue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.interfaces.LifeCycleState;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.persistence.finder.sharevalue.ShareValue_FindByShare1;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * ShareValue manipulation API
 * 
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class ShareValueApplicationComponent extends AbstractShareValueApplicationComponent {

    private static final long serialVersionUID = 1303211696L;
    /**
     * <code>NAME</code> of this application component, so it can be retrieved easily.
     */
    private final static String NAME = "ShareValueApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key
     */
    private final static Object SESSION_KEY = new SerializableKey(ShareValueApplicationComponent.class, "SESSION_KEY");

    /**
     * Get the instance of the ShareValueApplicationComponent linked to the session. If there
     * is not already one it will be created.
     * 
     * @param session current session
     * @return ShareValueApplicationComponent
     * @throws JETException
     */
    public static final ShareValueApplicationComponent getInstance(final Session session) throws JETException {
        ShareValueApplicationComponent shareValueAC = (ShareValueApplicationComponent) session.getProperty(SESSION_KEY);

        if (shareValueAC != null) {
            final LifeCycleState lcs = shareValueAC.getInitializableSupport().getLifeCycleState();
            if (lcs == LifeCycleState.UNINITIALIZED) {
                session.removeProperty(SESSION_KEY);
                shareValueAC = null;
            }
        }

        if (shareValueAC == null) {
            final AbstractDesktopNut desktopNut = (AbstractDesktopNut) session.getProperty(AbstractDesktopNut.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an AbstractDesktopNut for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    shareValueAC = (ShareValueApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(shareValueAC);
                    session.setProperty(SESSION_KEY, shareValueAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the ShareValueApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return shareValueAC;
    }

    /**
     * Deinit, internal use only
     * 
     * @throws JETException
     */
    @Deinitializer
    public final void doAccountACDeinit() throws JETException {
        getSession().removeProperty(SESSION_KEY);
    }

    /**
     * Sample method making a call to getShareValues(final FinderMethod finder).
     * 
     * @param share Share for which the values are desired
     * 
     * @return a list of shareValue matching the FinderMethod.
     * @see List
     * @see ShareValue
     * @see #getShareValues(FinderMethod finder)
     */
    public List<ShareValue> getShareValues(final Share share) {
        final ShareValue_FindByShare1 finder = new ShareValue_FindByShare1();
        finder.setIdShare(share.getIdShare());

        return getShareValues(finder);
    }

}
