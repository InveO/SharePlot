package jet.shareplot.util;

public class TextUtils {

    private TextUtils() {
        // private constructor, to ensure the class can not be instantiated
    }

    public static boolean isEmpty(final CharSequence text) {
        return text == null || text.length() == 0;
    }

}
