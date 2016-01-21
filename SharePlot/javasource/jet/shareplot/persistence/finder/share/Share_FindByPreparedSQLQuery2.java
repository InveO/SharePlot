package jet.shareplot.persistence.finder.share;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
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

import jet.shareplot.persistence.dse.ShareDSE;
import jet.shareplot.persistence.ejb.share.ShareHome;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.shareplot.persistence.ic.ShareIC;
import jet.shareplot.persistence.imut.ShareImut;

/**
 * Class for the findByPreparedSQLQuery FinderMethod object for the Share component.
 *
 * SQL Query : where @@@_SQL
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class Share_FindByPreparedSQLQuery2 implements FinderMethod<ShareImut> {

    private static final long serialVersionUID = -1939421298L;
    private DataSourceExecutor2<ShareHome, ShareRemote> dse;
    private @Nullable String sqlWhereClause;
    private Object @Nullable [] sqlArguments;

    /**
     * Set sqlWhereClause argument value.
     *
     * @param sqlWhereClause argument value
     */
    public void setSqlWhereClause(final String sqlWhereClause) {
        this.sqlWhereClause = sqlWhereClause;
    }

    /**
     * Set sqlArguments argument value.
     *
     * @param sqlArguments argument value
     */
    public void setSqlArguments(final Object[] sqlArguments) {
        this.sqlArguments = new Object @Nullable [sqlArguments.length];
        System.arraycopy(sqlArguments, 0, this.sqlArguments, 0, sqlArguments.length);
    }


    @Override
    public @NonNull String getFinderName() {
        return "findByPreparedSQLQuery";
    }

    @Override
    public @NonNull Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("sqlWhereClause", this.sqlWhereClause);
        args.put("sqlArguments", this.sqlArguments);
        return args;
    }

    @Override
    public @NonNull ModelArray callFinder() throws JETException, FinderObjectNotFoundException {
        Collection<@NonNull ShareRemote> list;
        DataModelConverter2<ShareRemote> dmc;
        try {
            final ShareHome share = getDataSourceExecutor2().getEJBHome();
            list = share.findByPreparedSQLQuery(this.sqlWhereClause, this.sqlArguments);

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

    @Override
    public @NonNull List<@NonNull ShareImut> callImutFinder() throws JETException, FinderObjectNotFoundException {
        final List<@NonNull ShareImut> result = new ArrayList<>();

        final ShareIC ic = new ShareIC();

        try {
            final ShareHome home = getDataSourceExecutor2().getEJBHome();
            final Collection<@NonNull ShareRemote> list = home.findByPreparedSQLQuery(this.sqlWhereClause, this.sqlArguments);

            for (final ShareRemote remote : list) {
                result.add(ic.readImutFromRemote(remote));
            }
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
