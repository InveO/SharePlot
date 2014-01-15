package jet.shareplot.persistence.finder.sharevalue;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.ShareValueDSE;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueHome;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findAll FinderMethod object for the ShareValue component.
 *
 * SQL Query : 
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareValue_FindAll0 implements FinderMethod {

    private static final long serialVersionUID = 1303211696L;
    private DataSourceExecutor2<ShareValueHome, ShareValueRemote> dse;


    @Override
    @Nonnull
    public String getFinderName() {
        return "findAll";
    }

    @Override
    @Nonnull
    public Map<String, Object> getArguments() {
        return new HashMap<String, Object>();
    }

    @Override
    @Nonnull
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
        List<ShareValueRemote> list;
        DataModelConverter2<ShareValueRemote> dmc;
        try {
            final ShareValueHome sharevalue = getDataSourceExecutor2().getEJBHome();
            list = (List<ShareValueRemote>) sharevalue.findAll();

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareValueRemote>(list, dmc);
    }

    private DataSourceExecutor2<ShareValueHome, ShareValueRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<ShareValueHome, ShareValueRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new ShareValueDSE();
        }
        return result;
    }
}
