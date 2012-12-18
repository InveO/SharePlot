package jet.shareplot.persistence.dse;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jet.framework.manager.datamodel.interfaces.AbstractDataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.JETDuplicateKeyException;
import jet.shareplot.persistence.dmc.PortfolioDMC;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Portfolio DataSourceExecutor2
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class PortfolioDSE extends AbstractDataSourceExecutor2<PortfolioHome, PortfolioRemote> {

    private static final long serialVersionUID = 993423458L;
    private transient PortfolioHome ejbHome;
    private DataModelConverter2<PortfolioRemote> dataModelConverter;

    @Override
    public void updateFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final PortfolioRemote ejbObject = getObjectFromStore(dataModel);
                getDataModelConverter().writeDataModelToObject(dataModel, ejbObject);
                return null;
            }
        };

        callUpdateTransaction(callable);
    }

    @Override
    public void createFromDataModel(final Model dataModel) throws JETException, JETDuplicateKeyException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final PortfolioItem portfolioItem = new PortfolioItem(dataModel);

                final PortfolioHome portfolioHome = getEJBHome();
                final PortfolioRemote portfolioRemote = portfolioHome.create(portfolioItem.getIdPortfolio(), portfolioItem.getIsFake(), portfolioItem.getName());

                // has autoincrement PK, must update
                portfolioItem.get_IdPortfolio_Model().setNodeValue(portfolioRemote.getIdPortfolio());

                return null;
            }
        };

        callCreateTransaction(callable);
    }

    @Override
    public void removeFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final PortfolioRemote portfolioRemote = getObjectFromStore(dataModel);
                portfolioRemote.remove();
                return null;
            }
        };

        callUpdateTransaction(callable);

        // if has autoincrement PK, must reset pk to null
        final PortfolioItem portfolioItem = new PortfolioItem(dataModel);
        portfolioItem.get_IdPortfolio_Model().setNodeValue(null);
    }

    @Override
    public PortfolioHome getEJBHome() {
        if (this.ejbHome == null) {
            try {
                this.ejbHome = (PortfolioHome) new InitialContext().lookup(JetConstants.EJB_CONTEXT + PortfolioHome.BEAN_NAME);
            } catch (final NamingException e) {
                throw new IllegalArgumentException("Unable to locate EJB Home : " + PortfolioHome.BEAN_NAME, e);
            }
            if (this.ejbHome == null) {
                throw new IllegalArgumentException("Unknown EJB : " + PortfolioHome.BEAN_NAME);
            }
        }
        return this.ejbHome;
    }

    @Override
    public DataModelConverter2<PortfolioRemote> getDataModelConverter() {
        if (this.dataModelConverter == null) {
            this.dataModelConverter = new PortfolioDMC();
        }

        return this.dataModelConverter;
    }

    /**
     * Get object from the persistant store corresponding to the data Model. Depending on the implementation
     * it may not be necessary to provide a full data Model.
     * <p>
     * This should be used with care as this may entail Transaction problems, depending on the underlying persistance layer.
     * </p>
     *
     * @param dataModel Model identifying the object to retrieve
     * @return E Persistent object corresponding to the Model
     * @throws JETException Thrown if there was an error whilst retrieving the object
     * @throws ObjectNotFoundException Thrown if there is no corresponding object
     */
    private PortfolioRemote getObjectFromStore(final Model dataModel) throws JETException, ObjectNotFoundException {
        assert dataModel != null : "Can not delete null model";

        final PortfolioItem portfolioItem = new PortfolioItem(dataModel);
        final PortfolioHome portfolioHome = getEJBHome();

        PortfolioRemote portfolioRemote;
        try {
            portfolioRemote = portfolioHome.findByPrimaryKey(portfolioItem.getIdPortfolio());
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw e;
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return portfolioRemote;
    }
}