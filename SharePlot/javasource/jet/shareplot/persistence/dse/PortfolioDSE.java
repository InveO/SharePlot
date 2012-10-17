package jet.shareplot.persistence.dse;

import java.util.List;

import javax.ejb.EJBObject;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jet.framework.manager.datamodel.interfaces.DataModelManagerContext;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderCaller;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.JetConstants;
import jet.framework.util.ejb.EJBModelList;
import jet.framework.util.jta.JETDuplicateKeyException;
import jet.shareplot.persistence.ejb.portfolio.PortfolioHome;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class PortfolioDSE implements DataSourceExecutor2<EJBObject> {

    private PortfolioHome ejbHome;

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
    public ModelArray executeFinder(final FinderMethod finderMethod) throws JETException, FinderObjectNotFoundException {

        if (finderMethod instanceof FinderCaller) {
            final FinderCaller finderCaller = (FinderCaller) finderMethod;
            final List<EJBObject> list = finderCaller.callFinder(getEJBHome());
            return new EJBModelList(list, this.dataModelConverter);
        }

        // TODO Auto-generated method stub
        return null;
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

}
