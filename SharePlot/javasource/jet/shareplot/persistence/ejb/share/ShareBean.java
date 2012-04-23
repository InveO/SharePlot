package jet.shareplot.persistence.ejb.share;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

/**
 * Class of the bean
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareBean implements EntityBean {
    
    /**
     * <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1353749886L;

    transient private EntityContext entityContext = null;

    /**
     * <code>idShare</code>
     */
    public Long idShare = null;

    /**
     * <code>name</code>
     */
    public String name = null;

    /**
     * <code>description</code>
     */
    public String description = null;

    /**
     * <code>code</code>
     */
    public String code = null;

    /**
     * <code>datePurchase</code>
     */
    public java.util.Date datePurchase = null;

    /**
     * <code>purchasePrice</code>
     */
    public java.math.BigDecimal purchasePrice = null;

    /**
     * <code>entryFee</code>
     */
    public java.math.BigDecimal entryFee = null;


    /**
     * @return Long
     * @throws EJBException
     */
    public Long getIdShare() throws EJBException {
        return this.idShare;

    }
    /**
     * @param idShare
     * @throws EJBException
     */
    public void setIdShare(Long idShare) throws EJBException {
        this.idShare = idShare;
    }

    /**
     * @return String
     * @throws EJBException
     */
    public String getName() throws EJBException {
        return this.name;

    }
    /**
     * @param name
     * @throws EJBException
     */
    public void setName(String name) throws EJBException {
        this.name = name;
    }

    /**
     * @return String
     * @throws EJBException
     */
    public String getDescription() throws EJBException {
        return this.description;

    }
    /**
     * @param description
     * @throws EJBException
     */
    public void setDescription(String description) throws EJBException {
        this.description = description;
    }

    /**
     * @return String
     * @throws EJBException
     */
    public String getCode() throws EJBException {
        return this.code;

    }
    /**
     * @param code
     * @throws EJBException
     */
    public void setCode(String code) throws EJBException {
        this.code = code;
    }

    /**
     * @return java.util.Date
     * @throws EJBException
     */
    public java.util.Date getDatePurchase() throws EJBException {
        java.util.Date date = null;
        if (this.datePurchase != null) {
            date = (java.util.Date) this.datePurchase.clone();
        }
        return date;

    }
    /**
     * @param datePurchase
     * @throws EJBException
     */
    public void setDatePurchase(java.util.Date datePurchase) throws EJBException {
        if (datePurchase == null) {
            this.datePurchase = null;
        } else {
            this.datePurchase = (java.util.Date) datePurchase.clone();
        }
    }

    /**
     * @return java.math.BigDecimal
     * @throws EJBException
     */
    public java.math.BigDecimal getPurchasePrice() throws EJBException {
        return this.purchasePrice;

    }
    /**
     * @param purchasePrice
     * @throws EJBException
     */
    public void setPurchasePrice(java.math.BigDecimal purchasePrice) throws EJBException {
        this.purchasePrice = purchasePrice;
    }

    /**
     * @return java.math.BigDecimal
     * @throws EJBException
     */
    public java.math.BigDecimal getEntryFee() throws EJBException {
        return this.entryFee;

    }
    /**
     * @param entryFee
     * @throws EJBException
     */
    public void setEntryFee(java.math.BigDecimal entryFee) throws EJBException {
        this.entryFee = entryFee;
    }


    /**
     * @param idShare
     * @param name
     * @param description
     * @param code
     * @param datePurchase
     * @param purchasePrice
     * @param entryFee
     * @return java.lang.Object
     * @throws CreateException
     */
    @SuppressWarnings({"hiding"})
    public java.lang.Object ejbCreate( Long idShare, String name, String description, String code, java.util.Date datePurchase, java.math.BigDecimal purchasePrice, java.math.BigDecimal entryFee) throws CreateException {
        this.idShare = idShare;
        this.name = name;
        this.description = description;
        this.code = code;
        if (datePurchase == null) {
            this.datePurchase = null;
        } else {
            this.datePurchase = (java.util.Date) datePurchase.clone();
        }
        this.purchasePrice = purchasePrice;
        this.entryFee = entryFee;
        return null;
    }

    /**
     * @param idShare
     * @param name
     * @param description
     * @param code
     * @param datePurchase
     * @param purchasePrice
     * @param entryFee
     * @throws CreateException
     */
    @SuppressWarnings({"hiding"})
    public void ejbPostCreate( Long idShare, String name, String description, String code, java.util.Date datePurchase, java.math.BigDecimal purchasePrice, java.math.BigDecimal entryFee) throws CreateException {
        assert this.entityContext != null : "this.entityContext can not be null";
        
        jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey _pk = (jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey) this.entityContext.getPrimaryKey();
        Number _number = (Number) _pk.getAutoGeneratedPrimaryKey();
        this.idShare = Long.valueOf(_number.longValue());
    }

    /**
     * @param pkField
     * @return java.lang.Object
     * @throws FinderException
     */
    public java.lang.Object ejbFindByPrimaryKey(java.lang.Object pkField) throws FinderException {
        if (pkField instanceof jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey) {
            jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey _pk = (jet.container.managers.jdbc.interfaces.AutoGeneratedPrimaryKey) pkField;
            this.idShare = (Long) _pk.getAutoGeneratedPrimaryKey();
        }
        return pkField;
    }

    /**
     * @param name
     * @param description
     * @param code
     * @param datePurchase
     * @param purchasePrice
     * @param entryFee
     * @throws EJBException
     */
    @SuppressWarnings({"hiding"})
    public void update( String name, String description, String code, java.util.Date datePurchase, java.math.BigDecimal purchasePrice, java.math.BigDecimal entryFee) throws EJBException {
        // in the case of a m-n table this method may be empty, as pk fields can not be updated
        this.name = name;
        this.description = description;
        this.code = code;
        if (datePurchase == null) {
            this.datePurchase = null;
        } else {
            this.datePurchase = (java.util.Date) datePurchase.clone();
        }
        this.purchasePrice = purchasePrice;
        this.entryFee = entryFee;
    }

    /**
     * @return Collection
     * @throws FinderException
     */
     @SuppressWarnings({"hiding"})
    public Collection<ShareRemote> ejbFindAll() throws FinderException {
        return null;
    }
    
    /**
     * @param sqlWhereClause
     * @param sqlArguments
     * @return Collection
     * @throws FinderException
     */
     @SuppressWarnings({"hiding"})
    public Collection<ShareRemote> ejbFindByPreparedSQLQuery(String sqlWhereClause,Object[] sqlArguments) throws FinderException {
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
    public void setEntityContext(EntityContext context) throws RemoteException {
        this.entityContext = context;
    }

    @Override
    @SuppressWarnings("unused")
    public void unsetEntityContext() throws RemoteException {
        this.entityContext = null;
    }

}