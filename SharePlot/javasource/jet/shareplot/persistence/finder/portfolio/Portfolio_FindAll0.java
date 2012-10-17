package jet.shareplot.persistence.finder.portfolio;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;

import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.nuts.select.FinderCaller;
import jet.framework.nuts.select.FinderMethod;
import jet.shareplot.persistence.dse.PortfolioDSE;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;

/**
 * Class for the findAll FinderMethod object for the Portfolio component.
 * 
 * SQL Query :
 * 
 * Generated by JetTools, do not edit this file directly.
 */
public class Portfolio_FindAll0 implements FinderMethod, FinderCaller<PortfolioHome, PortfolioRemote> {

    private static final long serialVersionUID = 993423458L;
    DataSourceExecutor2<PortfolioHome, PortfolioRemote> dse;

    @Override
    public String getFinderName() {
        return "findAll";
    }

    @Override
    public Map<String, Object> getArguments() {
        return new HashMap<String, Object>();
    }

    @Override
    public List<PortfolioRemote> callFinder(final PortfolioHome portfolioHome) throws RemoteException, FinderException {
        return (List<PortfolioRemote>) portfolioHome.findAll();
    }

    @Override
    public DataSourceExecutor2<PortfolioHome, PortfolioRemote> getDataSourceExecutor2() {
        if (this.dse == null) {
            this.dse = new PortfolioDSE();
        }
        return this.dse;
    }
}
