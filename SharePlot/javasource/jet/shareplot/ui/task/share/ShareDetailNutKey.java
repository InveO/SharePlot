package jet.shareplot.ui.task.share;

import java.io.Serializable;

/**
 * @author drobinson
 * 
 */
public class ShareDetailNutKey implements Serializable {

    private static final long serialVersionUID = -5870011731143456024L;

    private final Long idShare;

    /**
     * @param idShare
     */
    public ShareDetailNutKey(final Long idShare) {
        assert idShare != null;
        this.idShare = idShare;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof ShareDetailNutKey) {
                final ShareDetailNutKey other = (ShareDetailNutKey) obj;
                result = this.idShare.equals(other.idShare);
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.idShare.hashCode();
    }

}
