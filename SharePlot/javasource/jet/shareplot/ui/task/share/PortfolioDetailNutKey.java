package jet.shareplot.ui.task.share;

import java.io.Serializable;

public class PortfolioDetailNutKey implements Serializable {

    private static final long serialVersionUID = 8989529136527290643L;

    private final Long idPortfolio;

    /**
     * @param idPortfolio
     */
    public PortfolioDetailNutKey(final Long idPortfolio) {
        assert idPortfolio != null;
        this.idPortfolio = idPortfolio;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof PortfolioDetailNutKey) {
                final PortfolioDetailNutKey other = (PortfolioDetailNutKey) obj;
                result = this.idPortfolio.equals(other.idPortfolio);
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.idPortfolio.hashCode();
    }

}
