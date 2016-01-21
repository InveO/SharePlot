package jet.shareplot.persistence.finder.portfolio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.framework.util.pojo2.validator.ValidationException;
import jet.util.throwable.JETException;

import jet.shareplot.persistence.dse.PortfolioDSE;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.shareplot.persistence.ic.PortfolioIC;
import jet.shareplot.persistence.imut.PortfolioImut;

/**
 * Class for the findByPrimaryKey FinderMethod object of the Portfolio component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class Portfolio_FindByPrimaryKey1 implements FinderMethod<PortfolioImut> {

    private static final long serialVersionUID = 993423458L;
    private DataSourceExecutor2<PortfolioHome, PortfolioRemote> dse;
    private Long idPortfolio;

    /**
     * Set idPortfolio argument value.
     *
     * @param idPortfolio argument value
     */
    public void setIdPortfolio(final Long idPortfolio) {
        this.idPortfolio = idPortfolio;
    }

    @Override
    public @NonNull String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    public @NonNull Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idPortfolio", this.idPortfolio);
        return args;
    }

    @Override
    public @NonNull ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
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

    private @NonNull DataSourceExecutor2<PortfolioHome, PortfolioRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<PortfolioHome, PortfolioRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new PortfolioDSE();
        }
        return result;
    }

    @Override
    public @NonNull List<@NonNull PortfolioImut> callImutFinder() throws JETException, FinderObjectNotFoundException {
        final List<@NonNull PortfolioImut> result = new ArrayList<>();

        final PortfolioIC ic = new PortfolioIC();

        try {
            final PortfolioHome home = getDataSourceExecutor2().getEJBHome();
            PortfolioRemote remote = home.findByPrimaryKey(this.idPortfolio);

            result.add(ic.readImutFromRemote(remote));
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ValidationException e) {
            // should be impossible as only valid imuts should be written to the DB
            throw new JETException(e.getMessage(), e);
        }

        return result;
    }
}
