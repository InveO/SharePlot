package jet.shareplot.persistence.ejb.share;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.EJBHome;

import jet.framework.util.ejb.EJBParam;

/**
 * Home interface for the bean.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface ShareHome extends EJBHome {

    /**
     * <code>BEAN_NAME</code>.
     */
    static final String BEAN_NAME = "Share";

    /**
     * Create a record.
     * @param idShare value for the field idShare
     * @param codeISIN value for the field codeISIN
     * @param codeYahoo value for the field codeYahoo
     * @param description value for the field description
     * @param name value for the field name
     * @return ShareRemote EJBObject implementation for the bean
     * @throws CreateException Thrown by the method to indicate a failure during the creation.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    ShareRemote create(@EJBParam(name = "idShare") Long idShare, @EJBParam(name = "codeISIN") String codeISIN, @EJBParam(name = "codeYahoo") String codeYahoo, @EJBParam(name = "description") String description, @EJBParam(name = "name") String name) throws CreateException, RemoteException;

    /**
     * Find a record by its primary key.
     * @param pkField PRimary key object
     * @return ShareRemote EJBObject implementation for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    ShareRemote findByPrimaryKey(@Nullable final java.lang.Object pkField) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareRemote> findAll() throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param sqlWhereClause value for the argument sqlWhereClause
     * @param sqlArguments value for the argument sqlArguments
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareRemote> findByPreparedSQLQuery(@Nullable final String sqlWhereClause, @Nullable final Object[] sqlArguments) throws FinderException, RemoteException;

}
