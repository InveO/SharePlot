package jet.shareplot.persistence.finder.sharevalue;

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

import jet.shareplot.persistence.dse.ShareValueDSE;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueHome;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.shareplot.persistence.ic.ShareValueIC;
import jet.shareplot.persistence.imut.ShareValueImut;

/**
 * Class for the findByPrimaryKey FinderMethod object of the ShareValue component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareValue_FindByPrimaryKey1 implements FinderMethod<ShareValueImut> {

    private static final long serialVersionUID = 1303211696L;
    private DataSourceExecutor2<ShareValueHome, ShareValueRemote> dse;
    private Long idShareValue;

    /**
     * Set idShareValue argument value.
     *
     * @param idShareValue argument value
     */
    public void setIdShareValue(final Long idShareValue) {
        this.idShareValue = idShareValue;
    }

    @Override
    public @NonNull String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    public @NonNull Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShareValue", this.idShareValue);
        return args;
    }

    @Override
    public @NonNull ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
        ShareValueRemote sharevalueRemote;
        DataModelConverter2<ShareValueRemote> dmc;
        try {
            final ShareValueHome sharevalueHome = getDataSourceExecutor2().getEJBHome();
            sharevalueRemote = sharevalueHome.findByPrimaryKey(this.idShareValue);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareValueRemote>(sharevalueRemote, dmc);
    }

    private @NonNull DataSourceExecutor2<ShareValueHome, ShareValueRemote> getDataSourceExecutor2() {
        DataSourceExecutor2<ShareValueHome, ShareValueRemote> result = this.dse;
        if (result == null) {
            result = this.dse = new ShareValueDSE();
        }
        return result;
    }

    @Override
    public @NonNull List<@NonNull ShareValueImut> callImutFinder() throws JETException, FinderObjectNotFoundException {
        final List<@NonNull ShareValueImut> result = new ArrayList<>();

        final ShareValueIC ic = new ShareValueIC();

        try {
            final ShareValueHome home = getDataSourceExecutor2().getEJBHome();
            ShareValueRemote remote = home.findByPrimaryKey(this.idShareValue);

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
