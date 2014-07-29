package jet.shareplot.persistence.factory;

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;

import jet.framework.util.models.ModelHelper;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Simple pojo factory for the ShareValue Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public final class ShareValueFactory implements Serializable {

    private static final long serialVersionUID = 1303211696L;
    private static volatile Logger logger;

    private ShareValueFactory() {
        // Singleton, add a private constructor to prevent instantiation
    }

    /**
     * Get a ShareValueItem initialized from a Model that has the same structure but contains
     * only String node values. These will be converted to the proper DataModel node value
     * types.
     *
     * @param untypedModel Model with String node values
     * @return ShareValueItem
     */
    @NonNull
    public static ShareValueItem getFromUntypedModel(final Model untypedModel) {
        final ShareValueItem item = new ShareValueItem();

        String sValue = null;

        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShareValue");
            if (sValue != null) {
                item.get_IdShareValue_Model().setNodeValue(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShare");
            if (sValue != null) {
                item.setIdShare(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "value");
            if (sValue != null) {
                item.setValue(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "valueDate");
            if (sValue != null) {
                final Long timestamp = Long.valueOf(sValue);
                item.setValueDate(new java.util.Date(timestamp.longValue()));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareValueItem", "getFromUntypedModel", e.getMessage(), e);
        }
        return item;
    }

    /**
     * Get logger.
     * 
     * @return Logger
     * @see "http://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java"
     */
    @NonNull
    private static Logger getLogger() {
        Logger result = logger;
        if (result == null) {
            synchronized (ShareValueFactory.class) {
                result = logger;
                if (result == null) {
                    result = logger = JETLoggerManager.getJETLoggerManager().getLogger("jet.shareplot.persistence.factory");
                }
            }
        }
        return AnnotationsHelper.assertNonNull(result);
    }
}
