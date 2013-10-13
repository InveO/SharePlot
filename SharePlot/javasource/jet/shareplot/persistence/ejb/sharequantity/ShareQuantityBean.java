package jet.shareplot.persistence.ejb.sharequantity;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

/**
 * Class of the bean.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareQuantityBean implements EntityBean {

    /**
     * <code>serialVersionUID</code>.
     */
    private static final long serialVersionUID = 2027097663L;

    private transient EntityContext entityContext;

    // fields must remain public as it is part of the EJB specifications
    /**
     * Field idShareQuantity of type Long, database type INTEGER of length 10.
     */
    public Long idShareQuantity;
    /**
     * Field changeFee of type java.math.BigDecimal, database type DECIMAL of length 12.
     */
    public java.math.BigDecimal changeFee;
    /**
     * Field changeQuantity of type java.math.BigDecimal, database type DECIMAL of length 12.
     */
    public java.math.BigDecimal changeQuantity;
    /**
     * Field changeType of type String, database type CHAR of length 1.
     */
    public String changeType;
    /**
     * Field changeValue of type java.math.BigDecimal, database type DECIMAL of length 12.
     */
    public java.math.BigDecimal changeValue;
    /**
     * Field description of type String, database type VARCHAR of length 1000.
     */
    public String description;
    /**
     * Field idPortfolio of type Long, database type INTEGER of length 10.
     */
    public Long idPortfolio;
    /**
     * Field idShare of type Long, database type INTEGER of length 10.
     */
    public Long idShare;
    /**
     * Field valueDate of type java.util.Date, database type DATE of length 10.
     */
    public java.util.Date valueDate;

    /**
     * Get the value for the field idShareQuantity.
     *
     * @return Long value for the field idShareQuantity
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public Long getIdShareQuantity() throws EJBException {
        return this.idShareQuantity;

    }
    /**
     * Set the value for the field idShareQuantity.
     *
     * @param idShareQuantity value for the field idShareQuantity
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setIdShareQuantity(@Nullable final Long idShareQuantity) throws EJBException {
        this.idShareQuantity = idShareQuantity;
    }

    /**
     * Get the value for the field changeFee.
     *
     * @return java.math.BigDecimal value for the field changeFee
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public java.math.BigDecimal getChangeFee() throws EJBException {
        return this.changeFee;

    }
    /**
     * Set the value for the field changeFee.
     *
     * @param changeFee value for the field changeFee
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setChangeFee(@Nullable final java.math.BigDecimal changeFee) throws EJBException {
        this.changeFee = changeFee;
    }

    /**
     * Get the value for the field changeQuantity.
     *
     * @return java.math.BigDecimal value for the field changeQuantity
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public java.math.BigDecimal getChangeQuantity() throws EJBException {
        return this.changeQuantity;

    }
    /**
     * Set the value for the field changeQuantity.
     *
     * @param changeQuantity value for the field changeQuantity
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setChangeQuantity(@Nullable final java.math.BigDecimal changeQuantity) throws EJBException {
        this.changeQuantity = changeQuantity;
    }

    /**
     * Get the value for the field changeType.
     *
     * @return String value for the field changeType
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public String getChangeType() throws EJBException {
        return this.changeType;

    }
    /**
     * Set the value for the field changeType.
     *
     * @param changeType value for the field changeType
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setChangeType(@Nullable final String changeType) throws EJBException {
        this.changeType = changeType;
    }

    /**
     * Get the value for the field changeValue.
     *
     * @return java.math.BigDecimal value for the field changeValue
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public java.math.BigDecimal getChangeValue() throws EJBException {
        return this.changeValue;

    }
    /**
     * Set the value for the field changeValue.
     *
     * @param changeValue value for the field changeValue
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setChangeValue(@Nullable final java.math.BigDecimal changeValue) throws EJBException {
        this.changeValue = changeValue;
    }

    /**
     * Get the value for the field description.
     *
     * @return String value for the field description
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public String getDescription() throws EJBException {
        return this.description;

    }
    /**
     * Set the value for the field description.
     *
     * @param description value for the field description
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setDescription(@Nullable final String description) throws EJBException {
        this.description = description;
    }

    /**
     * Get the value for the field idPortfolio.
     *
     * @return Long value for the field idPortfolio
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public Long getIdPortfolio() throws EJBException {
        return this.idPortfolio;

    }
    /**
     * Set the value for the field idPortfolio.
     *
     * @param idPortfolio value for the field idPortfolio
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setIdPortfolio(@Nullable final Long idPortfolio) throws EJBException {
        this.idPortfolio = idPortfolio;
    }

    /**
     * Get the value for the field idShare.
     *
     * @return Long value for the field idShare
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public Long getIdShare() throws EJBException {
        return this.idShare;

    }
    /**
     * Set the value for the field idShare.
     *
     * @param idShare value for the field idShare
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setIdShare(@Nullable final Long idShare) throws EJBException {
        this.idShare = idShare;
    }

    /**
     * Get the value for the field valueDate.
     *
     * @return java.util.Date value for the field valueDate
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @Nullable
    public java.util.Date getValueDate() throws EJBException {
        java.util.Date date = null;
        if (this.valueDate != null) {
            date = (java.util.Date) this.valueDate.clone();
        }
        return date;

    }
    /**
     * Set the value for the field valueDate.
     *
     * @param valueDate value for the field valueDate
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    public void setValueDate(@Nullable final java.util.Date valueDate) throws EJBException {
        if (valueDate == null) {
            this.valueDate = null;
        } else {
            this.valueDate = (java.util.Date) valueDate.clone();
        }
    }


    /**
     * ejbCreate method.
     *
     * @param idShareQuantity value for the field idShareQuantity
     * @param changeFee value for the field changeFee
     * @param changeQuantity value for the field changeQuantity
     * @param changeType value for the field changeType
     * @param changeValue value for the field changeValue
     * @param description value for the field description
     * @param idPortfolio value for the field idPortfolio
     * @param idShare value for the field idShare
     * @param valueDate value for the field valueDate
     * @return java.lang.Object bean primary key
     * @throws CreateException Thrown by the method to indicate a failure during the creation.
     */
    @SuppressWarnings("hiding")
    @Nullable
    public java.lang.Object ejbCreate(final Long idShareQuantity, final java.math.BigDecimal changeFee, final java.math.BigDecimal changeQuantity, final String changeType, final java.math.BigDecimal changeValue, final String description, final Long idPortfolio, final Long idShare, final java.util.Date valueDate) throws CreateException {
        this.idShareQuantity = idShareQuantity;
        this.changeFee = changeFee;
        this.changeQuantity = changeQuantity;
        this.changeType = changeType;
        this.changeValue = changeValue;
        this.description = description;
        this.idPortfolio = idPortfolio;
        this.idShare = idShare;
        if (valueDate == null) {
            this.valueDate = null;
        } else {
            this.valueDate = (java.util.Date) valueDate.clone();
        }
        return null;
    }

    /**
     * ejbPostCreate method.
     *
     * @param idShareQuantity value for the field idShareQuantity
     * @param changeFee value for the field changeFee
     * @param changeQuantity value for the field changeQuantity
     * @param changeType value for the field changeType
     * @param changeValue value for the field changeValue
     * @param description value for the field description
     * @param idPortfolio value for the field idPortfolio
     * @param idShare value for the field idShare
     * @param valueDate value for the field valueDate
     * @throws CreateException Thrown by the method to indicate a failure during the creation.
     */
    @SuppressWarnings("hiding")
    public void ejbPostCreate(final Long idShareQuantity, final java.math.BigDecimal changeFee, final java.math.BigDecimal changeQuantity, final String changeType, final java.math.BigDecimal changeValue, final String description, final Long idPortfolio, final Long idShare, final java.util.Date valueDate) throws CreateException {
        assert this.entityContext != null : "this.entityContext can not be null";

        jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey _pk = (jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey) this.entityContext.getPrimaryKey();
        Number _number = (Number) _pk.getAutoGeneratedPrimaryKey();
        this.idShareQuantity = Long.valueOf(_number.longValue());
    }

    /**
     * Find a record by its primary key.
     *
     * @param pkField primary key
     * @return java.lang.Object primary key object
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     */
    @Nonnull
    public java.lang.Object ejbFindByPrimaryKey(@Nonnull final java.lang.Object pkField) throws FinderException {
        if (pkField instanceof jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey) {
            jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey _pk = (jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey) pkField;
            this.idShareQuantity = (Long) _pk.getAutoGeneratedPrimaryKey();
        }
        return pkField;
    }

    /**
     * Update record.
     *
     * @param changeFee value for the field changeFee
     * @param changeQuantity value for the field changeQuantity
     * @param changeType value for the field changeType
     * @param changeValue value for the field changeValue
     * @param description value for the field description
     * @param idPortfolio value for the field idPortfolio
     * @param idShare value for the field idShare
     * @param valueDate value for the field valueDate
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    @SuppressWarnings("hiding")
    public void update(final java.math.BigDecimal changeFee, final java.math.BigDecimal changeQuantity, final String changeType, final java.math.BigDecimal changeValue, final String description, final Long idPortfolio, final Long idShare, final java.util.Date valueDate) throws EJBException {
        // in the case of a m-n table this method may be empty, as pk fields can not be updated
        this.changeFee = changeFee;
        this.changeQuantity = changeQuantity;
        this.changeType = changeType;
        this.changeValue = changeValue;
        this.description = description;
        this.idPortfolio = idPortfolio;
        this.idShare = idShare;
        if (valueDate == null) {
            this.valueDate = null;
        } else {
            this.valueDate = (java.util.Date) valueDate.clone();
        }
    }

    /**
     * Finder method.
     *
     * @return Collection of records
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     */
    public Collection<ShareQuantityRemote> ejbFindAll() throws FinderException {
        return null;
    }

    /**
     * Finder method.
     *
     * @param idShare Long value for finder argument idShare
     * @return Collection of records
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     */
    @SuppressWarnings("hiding")
    public Collection<ShareQuantityRemote> ejbFindByShare(final Long idShare) throws FinderException {
        return null;
    }

    /**
     * Finder method.
     *
     * @param sqlWhereClause String value for finder argument sqlWhereClause
     * @param sqlArguments Object[] value for finder argument sqlArguments
     * @return Collection of records
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     */
    public Collection<ShareQuantityRemote> ejbFindByPreparedSQLQuery(final String sqlWhereClause, final Object[] sqlArguments) throws FinderException {
        return null;
    }


    @Override
    @SuppressWarnings("unused")
    public void ejbActivate() throws RemoteException {
        // do nothing
    }

    @Override
    @SuppressWarnings("unused")
    public void ejbLoad() throws RemoteException {
        // do nothing
    }

    @Override
    @SuppressWarnings("unused")
    public void ejbPassivate() throws RemoteException {
        // do nothing
    }

    @Override
    @SuppressWarnings("unused")
    public void ejbRemove() throws RemoteException, RemoveException {
        // do nothing
    }

    @Override
    @SuppressWarnings("unused")
    public void ejbStore() throws RemoteException {
        // do nothing
    }

    @Override
    @SuppressWarnings("unused")
    public void setEntityContext(@Nullable final EntityContext context) throws RemoteException {
        this.entityContext = context;
    }

    @Override
    @SuppressWarnings("unused")
    public void unsetEntityContext() throws RemoteException {
        this.entityContext = null;
    }
}
