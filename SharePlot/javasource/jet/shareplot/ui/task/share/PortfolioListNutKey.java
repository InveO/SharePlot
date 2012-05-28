package jet.shareplot.ui.task.share;

import java.io.Serializable;

public class PortfolioListNutKey implements Serializable {

    private static final long serialVersionUID = 8989529136527290643L;

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof PortfolioListNutKey) {
                final PortfolioListNutKey key = (PortfolioListNutKey) obj;
                if (key.hashCode() == hashCode()) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return "jet.shareplot.ui.task.share.PortfolioListNutKey".hashCode();
    }

}
