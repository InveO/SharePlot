package jet.shareplot.ac.bo.sharequantity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jet.framework.util.ui.LocalizedDisplayable;
import jet.util.models.interfaces.Displayable;

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

    @Nonnull
    private final String code;
    @Nonnull
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
        return this.code;
    }

    /**
     * Get localization Key.
     *
     * @return localization Key
     */
    @Nonnull
    public String getLocalized() {
        return this.localized;
    }

    /**
     * Get displayable.
     *
     * @return Displayable
     */
    @Nonnull
    public Displayable getDisplayable() {
        return new LocalizedDisplayable(getCode(), getLocalized());
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
