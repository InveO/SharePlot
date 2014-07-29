package jet.shareplot.persistence.finder.sharequantity;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.ShareQuantityDSE;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityHome;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPrimaryKey FinderMethod object of the ShareQuantity component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareQuantity_FindByPrimaryKey1 implements FinderMethod {

    private static final long serialVersionUID = 1612007130L;
    private DataSourceExecutor2<ShareQuantityHome, ShareQuantityRemote> dse;
    private Long idShareQuantity;

    /**
     * Set idShareQuantity argument value.
     *
     * @param idShareQuantity argument value
     */
    public void setIdShareQuantity(@Nullable final Long idShareQuantity) {
        this.idShareQuantity = idShareQuantity;
    }

    @Override
    @NonNull
    public String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    @NonNull
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShareQuantity", this.idShareQuantity);
        return args;
    }

    @Override
    @NonNull
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
        ShareQuantityRemote sharequantityRemote;
        DataModelConverter2<ShareQuantityRemote> dmc;
        try {
            final ShareQuantityHome sharequantityHome = getDataSourceExecutor2().getEJBHome();
            sharequantityRemote = sharequantityHome.findByPrimaryKey(this.idShareQuantity);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareQuantityRemote>(sharequantityRemote, dmc);
    }

    @NonNull
    private DataSourceExecutor2<ShareQuantityHome, ShareQuantityRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<ShareQuantityHome, ShareQuantityRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new ShareQuantityDSE();
        }
        return result;
    }
}
