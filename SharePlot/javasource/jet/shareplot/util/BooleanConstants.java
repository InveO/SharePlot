package jet.shareplot.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.util.annotations.AnnotationsHelper;

/**
 * Boolean constants for use in peristing to a database char(1) field.
 * 
 * @author daniel
 * 
 */
public enum BooleanConstants {

    /**
     * True.
     */
    YES("Y"),

    /**
     * False.
     */
    NO("N");

    private String dbValue;

    private BooleanConstants(@NonNull final String dbValue) {
        this.dbValue = dbValue;
    }

    /**
     * Get BooleanConstants.
     * 
     * @return BooleanConstants.
     */
    @NonNull
    public BooleanConstants get() {
        return this;
    }

    /**
     * Get String value.
     * 
     * @return value
     */
    @NonNull
    public String getDBValue() {
        return AnnotationsHelper.assertNonNull(this.dbValue);
    }

    /**
     * Get BooleanConstants enum value corresponding to the given String booleanConstant.
     * 
     * @param booleanConstant Value to get the BooleanConstants for
     * @return BooleanConstants
     */
    @Nullable
    public static BooleanConstants getBooleanConstants(@Nullable final String booleanConstant) {
        BooleanConstants result = null;
        if (booleanConstant != null) {
            for (final BooleanConstants e : BooleanConstants.values()) {
                if (booleanConstant.equals(e.getDBValue())) {
                    result = e;
                }
            }
        }
        return result;
    }

}
