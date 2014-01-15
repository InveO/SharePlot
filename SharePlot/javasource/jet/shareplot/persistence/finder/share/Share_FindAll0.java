package jet.shareplot.persistence.finder.share;

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
import jet.shareplot.persistence.dse.ShareDSE;
import jet.shareplot.persistence.ejb.share.ShareHome;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findAll FinderMethod object for the Share component.
 *
 * SQL Query : 
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class Share_FindAll0 implements FinderMethod {

    private static final long serialVersionUID = -1939421298L;
    private DataSourceExecutor2<ShareHome, ShareRemote> dse;


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
        List<ShareRemote> list;
        DataModelConverter2<ShareRemote> dmc;
        try {
            final ShareHome share = getDataSourceExecutor2().getEJBHome();
            list = (List<ShareRemote>) share.findAll();

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareRemote>(list, dmc);
    }

    private DataSourceExecutor2<ShareHome, ShareRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<ShareHome, ShareRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new ShareDSE();
        }
        return result;
    }
}
