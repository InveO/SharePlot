package jet.shareplot.ac.bo.portfolio.portfolioshare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.nuts.desktop.JetDesktop;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.interfaces.LifeCycleState;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.persistence.pojo.portfolio.PortfolioShareItem;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

/**
 * PortfolioShare manipulation API.
 * 
 * Generated by JetTools, you can edit this file directly, once created it will not be overwritten
 * 
 * @author JetToolsFramework
 */
public class PortfolioShareBOApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 1L;
    /**
     * <code>NAME</code> of this application component, so it can be retrieved easily.
     */
    private static final String NAME = "PortfolioShareBOApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key.
     */
    private static final Object SESSION_KEY = new SerializableKey(PortfolioShareBOApplicationComponent.class, "SESSION_KEY");

    /**
     * Get the instance of the PortfolioShareBOApplicationComponent linked to the session. If there
     * is not already one it will be created.
     * 
     * @param session current session
     * @return PortfolioShareBOApplicationComponent
     * @throws JETException if there is an error initializing the ApplicationComponent
     */
    @Nonnull
    public static final PortfolioShareBOApplicationComponent getInstance(final Session session) throws JETException {
        PortfolioShareBOApplicationComponent portfolioShareAC = (PortfolioShareBOApplicationComponent) session.getProperty(SESSION_KEY);

        if (portfolioShareAC != null) {
            // system to bypass the test in junit tests, can not be exploited outside junit mocking mechanism
            final Object junitKey = session.getProperty(new Object());
            if (junitKey == null) {
                final LifeCycleState lcs = portfolioShareAC.getInitializableSupport().getLifeCycleState();
                if (lcs == LifeCycleState.UNINITIALIZED) {
                    session.removeProperty(SESSION_KEY);
                    portfolioShareAC = null;
                }
            }
        }

        if (portfolioShareAC == null) {
            final JetDesktop desktopNut = (JetDesktop) session.getProperty(JetDesktop.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an JetDesktop for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    portfolioShareAC = (PortfolioShareBOApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(portfolioShareAC);
                    session.setProperty(SESSION_KEY, portfolioShareAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the PortfolioShareBOApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return portfolioShareAC;
    }

    /**
     * Deinit, internal use only.
     * 
     * @throws JETException if there is an error deinitializing the ApplicationComponent
     */
    @Deinitializer
    public final void doAccountACDeinit() throws JETException {
        getSession().removeProperty(SESSION_KEY);
    }

    @Nonnull
    public List<PortfolioShareItem> getPortfolioShares(@Nullable final Portfolio portfolio) {
        final List<PortfolioShareItem> result = new ArrayList<>();

        if (portfolio != null) {

        }

        return result;
    }
}