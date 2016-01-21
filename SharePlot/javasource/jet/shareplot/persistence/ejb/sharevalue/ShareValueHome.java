package jet.shareplot.persistence.ejb.sharevalue;

import java.rmi.RemoteException;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.EJBHome;

import jet.framework.util.ejb.EJBParam;

/**
 * Home interface for the bean.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface ShareValueHome extends EJBHome {

    /**
     * <code>BEAN_NAME</code>.
     */
    static final String BEAN_NAME = "ShareValue";

    /**
     * Create a record.
     * @param idShareValue value for the field idShareValue
     * @param idShare value for the field idShare
     * @param value value for the field value
     * @param valueDate value for the field valueDate
     * @return ShareValueRemote EJBObject implementation for the bean
     * @throws CreateException Thrown by the method to indicate a failure during the creation.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull ShareValueRemote create(@EJBParam(name = "idShareValue") Long idShareValue, @EJBParam(name = "idShare") Long idShare, @EJBParam(name = "value") java.math.BigDecimal value, @EJBParam(name = "valueDate") java.util.Date valueDate) throws CreateException, RemoteException;

    /**
     * Find a record by its primary key.
     * @param pkField PRimary key object
     * @return ShareValueRemote EJBObject implementation for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull ShareValueRemote findByPrimaryKey(final java.lang.@Nullable Object pkField) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull Collection<@NonNull ShareValueRemote> findAll() throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param idShare value for the argument idShare
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull Collection<@NonNull ShareValueRemote> findByShare(final @Nullable Long idShare) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param idShare value for the argument idShare
     * @param valueDate value for the argument valueDate
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull Collection<@NonNull ShareValueRemote> findByShareAndDate(final @Nullable Long idShare, final java.util.@Nullable Date valueDate) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param sqlWhereClause value for the argument sqlWhereClause
     * @param sqlArguments value for the argument sqlArguments
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull Collection<@NonNull ShareValueRemote> findByPreparedSQLQuery(final @Nullable String sqlWhereClause, final Object @Nullable [] sqlArguments) throws FinderException, RemoteException;

}
