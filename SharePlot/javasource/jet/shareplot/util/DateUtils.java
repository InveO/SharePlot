package jet.shareplot.util;

import java.util.Date;

/**
 * Centralise date manipulation.
 * 
 * @author daniel
 * 
 */
public final class DateUtils {

    private DateUtils() {
        // singleton
    }

    /**
     * Centralise Date creation.
     * 
     * @return Date initialised to current date and time.
     */
    public static Date getToday() {
        return new Date();
    }

}
