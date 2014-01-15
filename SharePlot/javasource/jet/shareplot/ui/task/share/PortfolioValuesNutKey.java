package jet.shareplot.ui.task.share;

import java.io.Serializable;

/**
 * @author drobinson
 * 
 */
public class PortfolioValuesNutKey implements Serializable {

    private static final long serialVersionUID = -5870011731143456024L;

    private final Long idPortfolio;

    /**
     * @param idPortfolio
     */
    public PortfolioValuesNutKey(final Long idPortfolio) {
        assert idPortfolio != null;
        this.idPortfolio = idPortfolio;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof PortfolioValuesNutKey) {
                final PortfolioValuesNutKey other = (PortfolioValuesNutKey) obj;
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
