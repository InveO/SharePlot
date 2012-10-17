package jet.shareplot.persistence.dse;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter;
import jet.framework.manager.datamodel.interfaces.DataModelManagerContext;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderCaller;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.JetConstants;
import jet.framework.util.ejb.EJBModelList;
import jet.framework.util.jta.JETDuplicateKeyException;
import jet.shareplot.persistence.dmc.PortfolioDMC;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class PortfolioDSE implements DataSourceExecutor2<PortfolioHome, PortfolioRemote> {

    private PortfolioHome ejbHome;
    private DataModelConverter<PortfolioRemote> dataModelConverter;

    @Override
    public void setFindersModel(final Model findersModel) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDataModelManagerContext(final DataModelManagerContext dataModelManagerContext) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDataModelConverterType(final String dataModelConverterType) throws IllegalArgumentException, JETException {
        // TODO Auto-generated method stub

    }

    @Override
    public ModelArray executeFinder(final FinderMethod finderMethod, final FinderCaller<PortfolioHome, PortfolioRemote> finderCaller) throws JETException, FinderObjectNotFoundException {
        List<PortfolioRemote> list;
        try {
            list = finderCaller.callFinder(getEJBHome());
        } catch (final RemoteException e) {
            throw new JETException("RemoteException when executing finder [" + finderMethod.getFinderName() + "] on Portfolio.", e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException("FinderException when executing finder [" + finderMethod.getFinderName() + "] on Portfolio.", e);
        }
//        return new EJBModelList((List<EJBObject>) list, (DataModelConverter<EJBObject>) getDataModelConverter());
        return new EJBModelList(list, getDataModelConverter());
    }

    @Override
    public void updateFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        // TODO Auto-generated method stub

    }

    @Override
    public void createFromDataModel(final Model dataModel) throws JETException, JETDuplicateKeyException {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDefaultValues(final Model dataModel) throws JETException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setName(final String executorName) {
        // TODO Auto-generated method stub

    }

    private PortfolioHome getEJBHome() {
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

    private DataModelConverter<PortfolioRemote> getDataModelConverter() {
        if (this.dataModelConverter == null) {
            this.dataModelConverter = new PortfolioDMC();
        }
        return this.dataModelConverter;
    }

}
