package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.framework.util.pojo2.DispatcherModel;
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
 * Simple pojo wrapper for the Portfolio Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 * 
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class PortfolioItem implements Serializable {

    private static final long serialVersionUID = 993423458L;

    private Model dataModel;
    private Logger logger;

    private DispatcherModel<PortfolioItem, Long> idPortfolioDispatcherModel;
    private DispatcherModel<PortfolioItem, String> isFakeDispatcherModel;
    private DispatcherModel<PortfolioItem, String> nameDispatcherModel;

    /**
     * Constructor used to create a new Portfolio Data Model
     */
    public PortfolioItem() {
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
        this.dataModel.setTagName("Portfolio");
        
        SimpleEventModelImpl model = null;
        
        model = new SimpleEventModelImpl("idPortfolio");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("isFake");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("name");
        this.dataModel.appendChild(model);
    }
    
    /**
     * Constructor used to edit an existing Portfolio Data Model
     * @param model Model to use to wrap in the pojo, can not be null
     * @throws IllegalArgumentException if model is null
     */
    public PortfolioItem(final Model model) {
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
     * Copy constructor used to clone an existing Portfolio Data Model
     * @param portfolio PortfolioItem to use to copy in the pojo, can not be null
     * @throws IllegalArgumentException if portfolio is null
     */
    public PortfolioItem(final PortfolioItem portfolio) {
		this();
        if (portfolio == null) {
            throw new IllegalArgumentException("portfolio argument can not be null");
        }
        
        setIdPortfolio(portfolio.getIdPortfolio());
        setIsFake(portfolio.getIsFake());
        setName(portfolio.getName());
    }
    
    /**
     * Get the Portfolio Data Model that is wrapped in this pojo
     * @return Portfolio Data Model
     */
    public final Model get_Model() {
        return this.dataModel;
    }
    
    /**
     * Get node value of Data Model node idPortfolio
     * @return Long value of Data Model node idPortfolio
     */
    public final Long getIdPortfolio() {
        return (Long) get_IdPortfolio_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node idPortfolio
     * @param idPortfolio Long value of Data Model node idPortfolio
     */
    private final void setIdPortfolio(final Long idPortfolio) {
        get_IdPortfolio_Model().setNodeValue(idPortfolio);
    }
    
    /**
     * Get Model of Data Model node idPortfolio
     * @return Model of Data Model node idPortfolio
     */
    public final DispatcherModel<PortfolioItem, Long> get_IdPortfolio_Model() {
        if (this.idPortfolioDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idPortfolio");
                this.idPortfolioDispatcherModel = new DispatcherModel<PortfolioItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("Portfolio data model does not have a child named idPortfolio. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idPortfolioDispatcherModel;
    }

    /**
     * Get node value of Data Model node isFake
     * @return String value of Data Model node isFake
     */
    public final String getIsFake() {
        return (String) get_IsFake_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node isFake
     * @param isFake String value of Data Model node isFake
     */
    public final void setIsFake(String isFake) {
        get_IsFake_Model().setNodeValue(isFake);
    }
    
    /**
     * Get Model of Data Model node isFake
     * @return Model of Data Model node isFake
     */
    public final DispatcherModel<PortfolioItem, String> get_IsFake_Model() {
        if (this.isFakeDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "isFake");
                this.isFakeDispatcherModel = new DispatcherModel<PortfolioItem, String>(this, sourceModel);

                this.isFakeDispatcherModel.addInterceptor(new StringLengthInterceptor<PortfolioItem>(1));
            } catch (final JETException e) {
                throw new JETSystemError("Portfolio data model does not have a child named isFake. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.isFakeDispatcherModel;
    }

    /**
     * Get node value of Data Model node name
     * @return String value of Data Model node name
     */
    public final String getName() {
        return (String) get_Name_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node name
     * @param name String value of Data Model node name
     */
    public final void setName(String name) {
        get_Name_Model().setNodeValue(name);
    }
    
    /**
     * Get Model of Data Model node name
     * @return Model of Data Model node name
     */
    public final DispatcherModel<PortfolioItem, String> get_Name_Model() {
        if (this.nameDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "name");
                this.nameDispatcherModel = new DispatcherModel<PortfolioItem, String>(this, sourceModel);

                this.nameDispatcherModel.addInterceptor(new StringLengthInterceptor<PortfolioItem>(45));
            } catch (final JETException e) {
                throw new JETSystemError("Portfolio data model does not have a child named name. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.nameDispatcherModel;
    }

    /**
     * Check if any node not nullable is null
     * @return true if any node not nullable is null
     */
    public final boolean isNotNullableNull() {
        String isFake = getIsFake();
        if (isFake == null) {
            this.logger.logp(JETLevel.WARNING, "PortfolioItem", "isNotNullableNull", 
                "isFake is null but is not nullable.");
            return true;
        }
        String name = getName();
        if (name == null) {
            this.logger.logp(JETLevel.WARNING, "PortfolioItem", "isNotNullableNull", 
                "name is null but is not nullable.");
            return true;
        }
        return false;
    }
    
}
