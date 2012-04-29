package jet.shareplot.ac.portfolio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jet.container.managers.application.interfaces.ApplicationProxy;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.SelectNut;
import jet.framework.nuts.select.SelectNutHelper;
import jet.framework.ui.desktop.AbstractDesktopNut;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.interfaces.LifeCycleState;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.finder.portfolio.Portfolio_FindAll0;
import jet.util.SerializableKey;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Portfolio manipulation API
 * 
 * @author drobinson
 * 
 */
public class PortfolioApplicationComponent extends SimpleApplicationComponent {

    /**
     * eclipse generated serialVersionUID
     */
    private static final long serialVersionUID = 7703676644181769631L;
    /**
     * <code>NAME</code> of this application component, so it can be retreived easily.
     */
    private final static String NAME = "PortfolioApplicationComponent";
    /**
     * <code>SESSION_KEY</code> session key
     */
    private final static Object SESSION_KEY = new SerializableKey(PortfolioApplicationComponent.class, "SESSION_KEY");

    /**
     * @param session
     * @return PortfolioApplicationComponent
     * @throws JETException
     */
    public static final PortfolioApplicationComponent getInstance(final Session session) throws JETException {
        PortfolioApplicationComponent portfolioAC = (PortfolioApplicationComponent) session.getProperty(SESSION_KEY);

        if (portfolioAC != null) {
            final LifeCycleState lcs = portfolioAC.getInitializableSupport().getLifeCycleState();
            if (lcs == LifeCycleState.UNINITIALIZED) {
                session.removeProperty(SESSION_KEY);
                portfolioAC = null;
            }
        }

        if (portfolioAC == null) {
            final AbstractDesktopNut desktopNut = (AbstractDesktopNut) session.getProperty(AbstractDesktopNut.SESSION_KEY_DESKTOP);
            if (desktopNut == null) {
                throw new JETException("Can only be used with an AbstractDesktopNut for the desktop.");
            }

            final ApplicationProxy appProxy = desktopNut.getApplicationProxy();
            if (appProxy.hasApplicationComponent(NAME)) {
                try {
                    final Map<String, Object> initMap = new HashMap<String, Object>();
                    portfolioAC = (PortfolioApplicationComponent) appProxy.createApplicationComponent(NAME, desktopNut.getApplicationComponent(), initMap);
                    desktopNut.registerChildApplicationComponent(portfolioAC);
                    session.setProperty(SESSION_KEY, portfolioAC);
                } catch (final JETException e) {
                    desktopNut.logp(JETLevel.SEVERE, NAME, "getInstance", e.getMessage(), e);
                    throw new JETException("Could not instantiate the PortfolioApplicationComponent.", e);
                }
            } else {
                desktopNut.logp(JETLevel.INFO, NAME, "getInstance", "NO APPLICATION COMPONENT FOUND FOR : " + NAME);
                throw new JETException("NO APPLICATION COMPONENT FOUND FOR : " + NAME);
            }
        }

        return portfolioAC;
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

    public List<Portfolio> getPortfolios() {
        final List<Portfolio> result = new ArrayList<Portfolio>();

        final Portfolio_FindAll0 finder = new Portfolio_FindAll0();
        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.PORTFOLIO_SELECT);
        final ModelArray ma = SelectNutHelper.getModelArray(selectNut, finder, getLogger());
        if (ma != null) {
            final int size = ma.getSize();
            for (int i = 0; i < size; i++) {
                final Model model = ma.get(i);
                final Portfolio item = new Portfolio(model, this);
                result.add(item);
            }
        }

        return result;
    }

}
