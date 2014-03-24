package jet.shareplot.persistence.ejb.sharequantity;

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
public interface ShareQuantityHome extends EJBHome {

    /**
     * <code>BEAN_NAME</code>.
     */
    static final String BEAN_NAME = "ShareQuantity";

    /**
     * Create a record.
     * @param idShareQuantity value for the field idShareQuantity
     * @param changeFee value for the field changeFee
     * @param changeQuantity value for the field changeQuantity
     * @param changeType value for the field changeType
     * @param changeValue value for the field changeValue
     * @param description value for the field description
     * @param idPortfolio value for the field idPortfolio
     * @param idShare value for the field idShare
     * @param totalQuantity value for the field totalQuantity
     * @param valueDate value for the field valueDate
     * @return ShareQuantityRemote EJBObject implementation for the bean
     * @throws CreateException Thrown by the method to indicate a failure during the creation.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    ShareQuantityRemote create(@EJBParam(name = "idShareQuantity") Long idShareQuantity, @EJBParam(name = "changeFee") java.math.BigDecimal changeFee, @EJBParam(name = "changeQuantity") java.math.BigDecimal changeQuantity, @EJBParam(name = "changeType") String changeType, @EJBParam(name = "changeValue") java.math.BigDecimal changeValue, @EJBParam(name = "description") String description, @EJBParam(name = "idPortfolio") Long idPortfolio, @EJBParam(name = "idShare") Long idShare, @EJBParam(name = "totalQuantity") java.math.BigDecimal totalQuantity, @EJBParam(name = "valueDate") java.util.Date valueDate) throws CreateException, RemoteException;

    /**
     * Find a record by its primary key.
     * @param pkField PRimary key object
     * @return ShareQuantityRemote EJBObject implementation for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    ShareQuantityRemote findByPrimaryKey(@Nullable final java.lang.Object pkField) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareQuantityRemote> findAll() throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param idPortfolio value for the argument idPortfolio
     * @param idShare value for the argument idShare
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareQuantityRemote> findByShareAndPortfolio(@Nullable final Long idPortfolio, @Nullable final Long idShare) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param idPortfolio value for the argument idPortfolio
     * @param idShare value for the argument idShare
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareQuantityRemote> findByShareAndPortfolioLimit(@Nullable final Long idPortfolio, @Nullable final Long idShare) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param idPortfolio value for the argument idPortfolio
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareQuantityRemote> findByPortfolio(@Nullable final Long idPortfolio) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param sqlWhereClause value for the argument sqlWhereClause
     * @param sqlArguments value for the argument sqlArguments
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nonnull
    Collection<ShareQuantityRemote> findByPreparedSQLQuery(@Nullable final String sqlWhereClause, @Nullable final Object[] sqlArguments) throws FinderException, RemoteException;

}
