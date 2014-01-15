package jet.shareplot.ui.task.share;

import java.io.Serializable;

/**
 * @author drobinson
 * 
 */
public class ShareListNutKey implements Serializable {

    private static final long serialVersionUID = -5870011731143456024L;

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof ShareListNutKey) {
                final ShareListNutKey key = (ShareListNutKey) obj;
                if (key.hashCode() == hashCode()) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return "jet.shareplot.ui.task.share.ShareListNutKey".hashCode();
    }

}
