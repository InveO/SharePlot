package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
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
public class ShareQuantityItem implements Cloneable, Serializable {

    private static final long serialVersionUID = -1994630651L;

    private Model dataModel;
    private Logger logger;

    /**
     * Constructor used to create a new ShareQuantity Data Model
     */
    public ShareQuantityItem() {
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }
		
        init_DataModel();
    }

    private void init_DataModel() {
        this.dataModel = new DataModelRootNode();
        this.dataModel.setTagName("ShareQuantity");
        
        SimpleEventModelImpl model = null;
        
        model = new SimpleEventModelImpl("idShareQuantity");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("valueDate");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("changeType");
        this.dataModel.appendChild(model);
    }
    
    /**
     * Constructor used to edit an existing ShareQuantity Data Model
     * @param model Model to use to wrap in the pojo, can not be null
     * @throws IllegalArgumentException if model is null
     */
    public ShareQuantityItem(final Model model) {
        if (model == null) {
            throw new IllegalArgumentException("model argument can not be null");
        }
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }
        
        this.dataModel = model;
    }
    
    /**
     * Get a ShareQuantityItem initialized from a Model that has the same structure but contains
     * only String node values. These will be converted to the proper DataModel node value
     * types.
     * 
     * @param untypedModel Model with String node values
     * @return ShareQuantityItem
     */
    public final static ShareQuantityItem getFromUntypedModel(final Model untypedModel) {
        final ShareQuantityItem item = new ShareQuantityItem();
        
        String sValue = null;
        
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShareQuantity");
            if (sValue != null) {
                item.setIdShareQuantity(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShare");
            if (sValue != null) {
                item.setIdShare(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "valueDate");
            if (sValue != null) {
                Long timestamp = Long.valueOf(sValue);
                item.setValueDate(new java.util.Date(timestamp.longValue()));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "changeType");
            if (sValue == null) {
                sValue = " ";
            }
            item.setChangeType(sValue);                
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        return item;
    }

    /**
     * Get the ShareQuantity Data Model that is wrapped in this pojo
     * @return ShareQuantity Data Model
     */
    public Model get_Model() {
        return this.dataModel;
    }
    
    /**
     * Create a clone of the ShareQuantityItem pojo, the will clone the underlying data model
     * @return ShareQuantityItem pojo
     */
    @Override
    public ShareQuantityItem clone() throws CloneNotSupportedException {
        final ShareQuantityItem clonedItem = (ShareQuantityItem) super.clone();
        clonedItem.init_DataModel();
        clonedItem.setIdShareQuantity(getIdShareQuantity());
        clonedItem.setIdShare(getIdShare());
        clonedItem.setValueDate(getValueDate());
        clonedItem.setChangeType(getChangeType());
        return clonedItem;
    }

    /**
     * Get node value of Data Model node idShareQuantity
     * @return Long value of Data Model node idShareQuantity
     */
    public Long getIdShareQuantity() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "idShareQuantity");
            return (Long) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named idShareQuantity. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node idShareQuantity
     * @param idShareQuantity Long value of Data Model node idShareQuantity
     */
    private final void setIdShareQuantity(final Long idShareQuantity) {
        Long tmp = idShareQuantity;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "idShareQuantity", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named idShareQuantity. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node idShareQuantity
     * @return Model of Data Model node idShareQuantity
     */
    public Model get_IdShareQuantity_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "idShareQuantity");
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named idShareQuantity. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node idShare
     * @return Long value of Data Model node idShare
     */
    public Long getIdShare() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "idShare");
            return (Long) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named idShare. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node idShare
     * @param idShare Long value of Data Model node idShare
     */
    public final void setIdShare(Long idShare) {
        Long tmp = idShare;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "idShare", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named idShare. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node idShare
     * @return Model of Data Model node idShare
     */
    public Model get_IdShare_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "idShare");
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named idShare. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node valueDate
     * @return java.util.Date value of Data Model node valueDate
     */
    public java.util.Date getValueDate() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "valueDate");
            return (java.util.Date) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named valueDate. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node valueDate
     * @param valueDate java.util.Date value of Data Model node valueDate
     */
    public final void setValueDate(java.util.Date valueDate) {
        java.util.Date tmp = valueDate;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "valueDate", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named valueDate. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node valueDate
     * @return Model of Data Model node valueDate
     */
    public Model get_ValueDate_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "valueDate");
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named valueDate. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node changeType
     * @return String value of Data Model node changeType
     */
    public String getChangeType() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "changeType");
            return (String) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named changeType. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node changeType
     * @param changeType String value of Data Model node changeType
     */
    public final void setChangeType(String changeType) {
        String tmp = changeType;
        if (tmp != null && tmp.length() > 1) {
            tmp = tmp.substring(0, 1);
            this.logger.logp(JETLevel.WARNING, "ShareQuantityItem", "setChangeType", 
                "Data truncated [" + changeType + "] -> [" + tmp + "]");
        }
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "changeType", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named changeType. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node changeType
     * @return Model of Data Model node changeType
     */
    public Model get_ChangeType_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "changeType");
        } catch (final JETException e) {
            throw new JETSystemError("ShareQuantity data model does not have a child named changeType. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Check if any node not nullable is null
     * @return true if any node not nullable is null
     */
    public boolean isNotNullableNull() {
        Long idShare = getIdShare();
        if (idShare == null) {
            this.logger.logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull", 
                "idShare is null but is not nullable.");
            return true;
        }
        java.util.Date valueDate = getValueDate();
        if (valueDate == null) {
            this.logger.logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull", 
                "valueDate is null but is not nullable.");
            return true;
        }
        String changeType = getChangeType();
        if (changeType == null) {
            this.logger.logp(JETLevel.WARNING, "ShareQuantityItem", "isNotNullableNull", 
                "changeType is null but is not nullable.");
            return true;
        }
        return false;
    }
    
    
}