package jet.shareplot.persistence.finder.portfolio;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.PortfolioDSE;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPrimaryKey FinderMethod object of the Portfolio component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class Portfolio_FindByPrimaryKey1 implements FinderMethod {

    private static final long serialVersionUID = 993423458L;
    DataSourceExecutor2<PortfolioHome, PortfolioRemote> dse;

    Long idPortfolio;

    /**
     * Set idPortfolio argument value
     *
     * @param idPortfolio argument value
     */
    public void setIdPortfolio(final Long idPortfolio) {
        this.idPortfolio = idPortfolio;
    }

    @Override
    public String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idPortfolio", this.idPortfolio);
        return args;
    }

    @Override
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {

        PortfolioRemote portfolioRemote;
        DataModelConverter2<PortfolioRemote> dmc;
        try {
            final PortfolioHome portfolioHome = getDataSourceExecutor2().getEJBHome();
            portfolioRemote = portfolioHome.findByPrimaryKey(this.idPortfolio);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<PortfolioRemote>(portfolioRemote, dmc);
    }

    private DataSourceExecutor2<PortfolioHome, PortfolioRemote> getDataSourceExecutor2() {
        if (this.dse == null) {
            this.dse = new PortfolioDSE();
        }
        return this.dse;
    }
}
