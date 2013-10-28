package jet.shareplot.util;

/**
 * Text manupilation utilities.
 * 
 * @author daniel
 * 
 */
public final class TextUtils {

    private TextUtils() {
        // private constructor, to ensure the class can not be instantiated
    }

    /**
     * Is a CharSequence empty, ie null or of 0 length.
     * 
     * @param text CharSequence to test
     * @return <code>true</code> if text is null or of 0 length
     */
    public static boolean isEmpty(final CharSequence text) {
        return text == null || text.length() == 0;
    }

}
