package jet.shareplot.persistence.factory.merged;

import java.io.Serializable;

import jet.framework.util.models.ModelHelper;
import jet.shareplot.persistence.pojo.merged.FullShareValueItem;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Simple pojo factory for the FullShareValue Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public final class FullShareValueFactory implements Serializable {

    private static final long serialVersionUID = 1L;
    private static volatile Logger LOGGER;

    private FullShareValueFactory() {
        // Singleton, add a private constructor to prevent instantiation
    }

    /**
     * Get a FullShareValueItem initialized from a Model that has the same structure but contains
     * only String node values. These will be converted to the proper DataModel node value
     * types.
     *
     * @param untypedModel Model with String node values
     * @return FullShareValueItem
     */
    public static FullShareValueItem getFromUntypedModel(final Model untypedModel) {
        final FullShareValueItem item = new FullShareValueItem();

        String sValue = null;

        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShareValue");
            if (sValue != null) {
                item.get_IdShareValue_Model().setNodeValue(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "codeISIN");
            item.setCodeISIN(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "codeYahoo");
            item.setCodeYahoo(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "description");
            item.setDescription(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idPortfolio");
            if (sValue != null) {
                item.setIdPortfolio(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShare");
            if (sValue != null) {
                item.setIdShare(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "name");
            if (sValue == null) {
                sValue = " ";
            }
            item.setName(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "value");
            if (sValue != null) {
                item.setValue(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "valueDate");
            if (sValue != null) {
                final Long timestamp = Long.valueOf(sValue);
                item.setValueDate(new java.util.Date(timestamp.longValue()));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "FullShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        return item;
    }

    /**
     * @return Logger
     * @see "http://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java"
     */
    private static Logger getLogger() {
        Logger result = LOGGER;
        if (result == null) {
            synchronized(FullShareValueFactory.class) {
                result = LOGGER;
                if (result == null) {
                    LOGGER = result = JETLoggerManager.getJETLoggerManager().getLogger("jet.shareplot.persistence.factory.merged");
                }
            }
        }
        return result;
    }

}