package jet.shareplot.ac.bo.sharequantity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jet.util.annotations.AnnotationsHelper;

public enum ChangeType {

    /**
     * Purchase.
     */
    PURCHASE("P", "SharePlot/properties/task/Share/changeType.Purchase"),

    /**
     * Sale.
     */
    SALE("S", "SharePlot/properties/task/Share/changeType.Sale"),

    /**
     *
     */
    FEE("F", "SharePlot/properties/task/Share/changeType.Fee");

    private final String code;
    private final String localized;

    private ChangeType(@Nonnull final String code, @Nonnull final String localized) {
        this.code = code;
        this.localized = localized;
    }

    /**
     * Get ChangeType.
     * 
     * @return ChangeType.
     */
    @Nonnull
    public ChangeType get() {
        return this;
    }

    /**
     * Get String value.
     * 
     * @return value
     */
    @Nonnull
    public String getCode() {
        return AnnotationsHelper.assertNonNull(this.code);
    }

    /**
     * Get localization Key.
     * 
     * @return localization Key
     */
    @Nonnull
    public String getLocalized() {
        return AnnotationsHelper.assertNonNull(this.localized);
    }

    /**
     * Get ChangeType enum value corresponding to the given String changeType.
     * 
     * @param changeType Value to get the ChangeType for
     * @return ChangeType
     */
    @Nullable
    public static ChangeType getChangeType(@Nullable final String changeType) {
        ChangeType result = null;
        if (changeType != null) {
            for (final ChangeType e : ChangeType.values()) {
                if (changeType.equals(e.getCode())) {
                    result = e;
                }
            }
        }
        return result;
    }

}
