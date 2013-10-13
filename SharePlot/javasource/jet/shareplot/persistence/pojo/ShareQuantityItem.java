package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import javax.annotation.Nonnull;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.framework.util.pojo2.DispatcherModel;
import jet.framework.util.pojo2.JFDataItem;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.framework.util.pojo2.JFErrorHandlerProvider;
import jet.framework.util.pojo2.interceptor.StringLengthInterceptor;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.logger.LoggerJUnit;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;
import jet.util.throwable.JETSystemError;

/**
 * Simple pojo wrapper for the ShareQuantity Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class ShareQuantityItem implements Serializable, JFErrorHandlerProvider, JFDataItem {

    private static final long serialVersionUID = 2027097663L;

    private static final String ATTRIBUTE_DISPATCHER_MODEL = "jet.shareplot.persistence.pojo.ATTRIBUTE_DISPATCHER_MODEL";

    private final Model dataModel;
    private transient Logger logger;

    private transient DispatcherModel<ShareQuantityItem> idShareQuantityDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> changeFeeDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> changeQuantityDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> changeTypeDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> changeValueDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> descriptionDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> idPortfolioDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> idShareDispatcherModel;
    private transient DispatcherModel<ShareQuantityItem> valueDateDispatcherModel;

    private transient JFErrorHandler jfErrorHandler;

    /**
     * Constructor used to create a new ShareQuantity Data Model.
     */
    public ShareQuantityItem() {
        this.dataModel = new DataModelRootNode();
        init_DataModel();
    }

    private void init_DataModel() {
        this.dataModel.setTagName("ShareQuantity");

        SimpleEventModelImpl model = null;

        model = new SimpleEventModelImpl("idShareQuantity");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("changeFee");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("changeQuantity");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("changeType");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("changeValue");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("description");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idPortfolio");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("valueDate");
        this.dataModel.appendChild(model);
    }

    /**
     * Constructor used to edit an existing ShareQuantity Data Model.
     * 
     * @param model Model to use to wrap in the pojo, can not be <code>null</code>
     */
    public ShareQuantityItem(@Nonnull final Model model) {
        this.dataModel = model;
    }

    /**
     * Copy constructor used to clone an existing ShareQuantity Data Model.
     * 
     * @param shareQuantity ShareQuantityItem to use to copy in the pojo, can not be <code>null</code>
     */
    public ShareQuantityItem(@Nonnull final ShareQuantityItem shareQuantity) {
        this();

        setIdShareQuantity(shareQuantity.getIdShareQuantity());
        setChangeFee(shareQuantity.getChangeFee());
        setChangeQuantity(shareQuantity.getChangeQuantity());
        setChangeType(shareQuantity.getChangeType());
        setChangeValue(shareQuantity.getChangeValue());
        setDescription(shareQuantity.getDescription());
        setIdPortfolio(shareQuantity.getIdPortfolio());
        setIdShare(shareQuantity.getIdShare());
        setValueDate(shareQuantity.getValueDate());
    }

    private Logger getLogger() {
        if (this.logger == null) {
            // initialise the logger
            try {
                final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
                this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
            } catch (final JETSystemError e) {
                // probably running in junit, use junitLogger
                this.logger = LoggerJUnit.getInstance();
            }
        }
        return this.logger;
    }

    @Override
    public final boolean isDirty() {
        if (get_Model() instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) get_Model();
            return dmrn.isDirty();
        }
        getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "isDirty", "Model is not a DataModelRootNode can not define if it is dirty.");
        return false;
    }

    /**
     * Check if this shareQuantity is new.
     * 
     * @return <code>true</code> if this shareQuantity is new.
     * @see JFDataItem
     */
    @Override
    public final boolean isNew() {
        return getIdShareQuantity() == null;
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#setJFErrorHandler(JFErrorHandler)
     */
    @Override
    public final void setJFErrorHandler(final JFErrorHandler jfErrorHandler) {
        this.jfErrorHandler = jfErrorHandler;
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#getJFErrorHandler()
     */
    @Override
    public final JFErrorHandler getJFErrorHandler() {
        return this.jfErrorHandler;
    }

    /**
     * Get the ShareQuantity Data Model that is wrapped in this pojo.
     * 
     * @return ShareQuantity Data Model
     * @see JFDataItem
     */
    @Override
    @Nonnull
    public final Model get_Model() {
        Model model = this.dataModel;
        assert model != null;
        return model;
    }

    /**
     * Get node value of Data Model node idShareQuantity.
     * This field should not be <code>null</code> in the database.
     * 
     * @return Long value of Data Model node idShareQuantity
     */
    public final Long getIdShareQuantity() {
        return (Long) get_IdShareQuantity_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idShareQuantity.
     * This field should not be <code>null</code> in the database.
     * 
     * @param idShareQuantity Long value of Data Model node idShareQuantity
     */
    private final void setIdShareQuantity(final Long idShareQuantity) {
        get_IdShareQuantity_Model().setNodeValue(idShareQuantity);
    }

    /**
     * Get Model of Data Model node idShareQuantity.
     * 
     * @return Model of Data Model node idShareQuantity
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_IdShareQuantity_Model() {
        if (this.idShareQuantityDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "idShareQuantity");
                this.idShareQuantityDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.idShareQuantityDispatcherModel == null) {
                    this.idShareQuantityDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.idShareQuantityDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named idShareQuantity. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.idShareQuantityDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node changeFee.
     * This field should not be <code>null</code> in the database.
     * 
     * @return java.math.BigDecimal value of Data Model node changeFee
     */
    public final java.math.BigDecimal getChangeFee() {
        return (java.math.BigDecimal) get_ChangeFee_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node changeFee.
     * This field should not be <code>null</code> in the database.
     * 
     * @param changeFee java.math.BigDecimal value of Data Model node changeFee
     */
    public final void setChangeFee(final java.math.BigDecimal changeFee) {
        get_ChangeFee_Model().setNodeValue(changeFee);
    }

    /**
     * Get Model of Data Model node changeFee.
     * 
     * @return Model of Data Model node changeFee
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_ChangeFee_Model() {
        if (this.changeFeeDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "changeFee");
                this.changeFeeDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.changeFeeDispatcherModel == null) {
                    this.changeFeeDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.changeFeeDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named changeFee. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.changeFeeDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node changeQuantity.
     * This field should not be <code>null</code> in the database.
     * 
     * @return java.math.BigDecimal value of Data Model node changeQuantity
     */
    public final java.math.BigDecimal getChangeQuantity() {
        return (java.math.BigDecimal) get_ChangeQuantity_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node changeQuantity.
     * This field should not be <code>null</code> in the database.
     * 
     * @param changeQuantity java.math.BigDecimal value of Data Model node changeQuantity
     */
    public final void setChangeQuantity(final java.math.BigDecimal changeQuantity) {
        get_ChangeQuantity_Model().setNodeValue(changeQuantity);
    }

    /**
     * Get Model of Data Model node changeQuantity.
     * 
     * @return Model of Data Model node changeQuantity
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_ChangeQuantity_Model() {
        if (this.changeQuantityDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "changeQuantity");
                this.changeQuantityDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.changeQuantityDispatcherModel == null) {
                    this.changeQuantityDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.changeQuantityDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named changeQuantity. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.changeQuantityDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node changeType.
     * This field should not be <code>null</code> in the database.
     * 
     * @return String value of Data Model node changeType
     */
    public final String getChangeType() {
        return (String) get_ChangeType_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node changeType.
     * This field should not be <code>null</code> in the database.
     * 
     * @param changeType String value of Data Model node changeType
     */
    public final void setChangeType(final String changeType) {
        get_ChangeType_Model().setNodeValue(changeType);
    }

    /**
     * Get Model of Data Model node changeType.
     * 
     * @return Model of Data Model node changeType
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_ChangeType_Model() {
        if (this.changeTypeDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "changeType");
                this.changeTypeDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.changeTypeDispatcherModel == null) {
                    this.changeTypeDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.changeTypeDispatcherModel);
                }

                this.changeTypeDispatcherModel.addInterceptor(StringLengthInterceptor.getStringLengthInterceptor(1));
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named changeType. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.changeTypeDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node changeValue.
     * This field should not be <code>null</code> in the database.
     * 
     * @return java.math.BigDecimal value of Data Model node changeValue
     */
    public final java.math.BigDecimal getChangeValue() {
        return (java.math.BigDecimal) get_ChangeValue_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node changeValue.
     * This field should not be <code>null</code> in the database.
     * 
     * @param changeValue java.math.BigDecimal value of Data Model node changeValue
     */
    public final void setChangeValue(final java.math.BigDecimal changeValue) {
        get_ChangeValue_Model().setNodeValue(changeValue);
    }

    /**
     * Get Model of Data Model node changeValue.
     * 
     * @return Model of Data Model node changeValue
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_ChangeValue_Model() {
        if (this.changeValueDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "changeValue");
                this.changeValueDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.changeValueDispatcherModel == null) {
                    this.changeValueDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.changeValueDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named changeValue. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.changeValueDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node description.
     * 
     * @return String value of Data Model node description
     */
    public final String getDescription() {
        return (String) get_Description_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node description.
     * 
     * @param description String value of Data Model node description
     */
    public final void setDescription(final String description) {
        get_Description_Model().setNodeValue(description);
    }

    /**
     * Get Model of Data Model node description.
     * 
     * @return Model of Data Model node description
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_Description_Model() {
        if (this.descriptionDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "description");
                this.descriptionDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.descriptionDispatcherModel == null) {
                    this.descriptionDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.descriptionDispatcherModel);
                }

                this.descriptionDispatcherModel.addInterceptor(StringLengthInterceptor.getStringLengthInterceptor(1000));
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named description. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.descriptionDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node idPortfolio.
     * This field should not be <code>null</code> in the database.
     * 
     * @return Long value of Data Model node idPortfolio
     */
    public final Long getIdPortfolio() {
        return (Long) get_IdPortfolio_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idPortfolio.
     * This field should not be <code>null</code> in the database.
     * 
     * @param idPortfolio Long value of Data Model node idPortfolio
     */
    public final void setIdPortfolio(final Long idPortfolio) {
        get_IdPortfolio_Model().setNodeValue(idPortfolio);
    }

    /**
     * Get Model of Data Model node idPortfolio.
     * 
     * @return Model of Data Model node idPortfolio
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_IdPortfolio_Model() {
        if (this.idPortfolioDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "idPortfolio");
                this.idPortfolioDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.idPortfolioDispatcherModel == null) {
                    this.idPortfolioDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.idPortfolioDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named idPortfolio. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.idPortfolioDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node idShare.
     * This field should not be <code>null</code> in the database.
     * 
     * @return Long value of Data Model node idShare
     */
    public final Long getIdShare() {
        return (Long) get_IdShare_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idShare.
     * This field should not be <code>null</code> in the database.
     * 
     * @param idShare Long value of Data Model node idShare
     */
    public final void setIdShare(final Long idShare) {
        get_IdShare_Model().setNodeValue(idShare);
    }

    /**
     * Get Model of Data Model node idShare.
     * 
     * @return Model of Data Model node idShare
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_IdShare_Model() {
        if (this.idShareDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "idShare");
                this.idShareDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.idShareDispatcherModel == null) {
                    this.idShareDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.idShareDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named idShare. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.idShareDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node valueDate.
     * This field should not be <code>null</code> in the database.
     * 
     * @return java.util.Date value of Data Model node valueDate
     */
    public final java.util.Date getValueDate() {
        return (java.util.Date) get_ValueDate_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node valueDate.
     * This field should not be <code>null</code> in the database.
     * 
     * @param valueDate java.util.Date value of Data Model node valueDate
     */
    public final void setValueDate(final java.util.Date valueDate) {
        get_ValueDate_Model().setNodeValue(valueDate);
    }

    /**
     * Get Model of Data Model node valueDate.
     * 
     * @return Model of Data Model node valueDate
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<ShareQuantityItem> get_ValueDate_Model() {
        if (this.valueDateDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "valueDate");
                this.valueDateDispatcherModel = (DispatcherModel<ShareQuantityItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.valueDateDispatcherModel == null) {
                    this.valueDateDispatcherModel = new DispatcherModel<ShareQuantityItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.valueDateDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("ShareQuantity data model does not have a child named valueDate. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<ShareQuantityItem> dm = this.valueDateDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Check if any node not nullable is <code>null</code>.
     * <ul>
     * <li><b>changeFee</b> can not be <code>null</code> in the database.</li>
     * <li><b>changeQuantity</b> can not be <code>null</code> in the database.</li>
     * <li><b>changeType</b> can not be <code>null</code> in the database.</li>
     * <li><b>changeValue</b> can not be <code>null</code> in the database.</li>
     * <li><b>idPortfolio</b> can not be <code>null</code> in the database.</li>
     * <li><b>idShare</b> can not be <code>null</code> in the database.</li>
     * <li><b>valueDate</b> can not be <code>null</code> in the database.</li>
     * </ul>
     *
     * @return <code>true</code> if any node not nullable is <code>null</code>
     * @see JFDataItem
     */
    @Override
    public final boolean isNotNullableNull() {
        final java.math.BigDecimal changeFee = getChangeFee();
        if (changeFee == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "changeFee is null but is not nullable.");
            return true;
        }
        final java.math.BigDecimal changeQuantity = getChangeQuantity();
        if (changeQuantity == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "changeQuantity is null but is not nullable.");
            return true;
        }
        final String changeType = getChangeType();
        if (changeType == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "changeType is null but is not nullable.");
            return true;
        }
        final java.math.BigDecimal changeValue = getChangeValue();
        if (changeValue == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "changeValue is null but is not nullable.");
            return true;
        }
        final Long idPortfolio = getIdPortfolio();
        if (idPortfolio == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "idPortfolio is null but is not nullable.");
            return true;
        }
        final Long idShare = getIdShare();
        if (idShare == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "idShare is null but is not nullable.");
            return true;
        }
        final java.util.Date valueDate = getValueDate();
        if (valueDate == null) {
            getLogger().logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull",
                "valueDate is null but is not nullable.");
            return true;
        }
        return false;
    }

    /**
     * Check if this PK is the same as the PK from another ShareQuantityItem.
     *
     * @param other ShareQuantityItem to compare with
     * @return <code>true</code> if the pk fields from the two objects have the same values
     * @see JFDataItem
     */
    @Override
    public final boolean isPkEquals(final JFDataItem other) {
        boolean result = false;
        
        if ( getIdShareQuantity() != null) {
            if (other instanceof ShareQuantityItem) {
                final ShareQuantityItem otherShareQuantity = (ShareQuantityItem) other;
                if ( getIdShareQuantity().equals(otherShareQuantity.getIdShareQuantity())) {
                    result = true;
                }
            }
        }
        
        return result;
    }
}
