package jet.shareplot.persistence.factory;

import java.io.Serializable;

import javax.annotation.Nonnull;

import jet.framework.util.models.ModelHelper;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Simple pojo factory for the Share Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public final class ShareFactory implements Serializable {

    private static final long serialVersionUID = -1939421298L;
    private static volatile Logger logger;

    private ShareFactory() {
        // Singleton, add a private constructor to prevent instantiation
    }

    /**
     * Get a ShareItem initialized from a Model that has the same structure but contains
     * only String node values. These will be converted to the proper DataModel node value
     * types.
     *
     * @param untypedModel Model with String node values
     * @return ShareItem
     */
    @Nonnull
    public static ShareItem getFromUntypedModel(final Model untypedModel) {
        final ShareItem item = new ShareItem();

        String sValue = null;

        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShare");
            if (sValue != null) {
                item.get_IdShare_Model().setNodeValue(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "codeISIN");
            item.setCodeISIN(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "codeYahoo");
            item.setCodeYahoo(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "description");
            item.setDescription(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "name");
            if (sValue == null) {
                sValue = " ";
            }
            item.setName(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        return item;
    }

    /**
     * Get logger.
     * 
     * @return Logger
     * @see "http://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java"
     */
    @Nonnull
    private static Logger getLogger() {
        Logger result = logger;
        if (result == null) {
            synchronized (ShareFactory.class) {
                result = logger;
                if (result == null) {
                    result = logger = JETLoggerManager.getJETLoggerManager().getLogger("jet.shareplot.persistence.factory");
                }
            }
        }
        return AnnotationsHelper.assertNonNull(result);
    }
}
