package jet.shareplot.ac.bo.portfolio.portfolioshare;

import java.math.BigDecimal;
import java.util.Date;

import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.persistence.pojo.portfolio.PortfolioShareItem;

/**
 * Parameter object, for the PortfolioShare.calculateValue() method.
 * 
 * @author daniel
 * 
 */
class CalculateValueContext {

    PortfolioShareItem portfolioShareItem;
    Share share;
    Date valueDate;
    BigDecimal quantity;

    /**
     * Contrauctor.
     * 
     * @param portfolioShareItem
     * @param share Share
     * @param valueDate Date
     * @param quantity BigDecimal
     */
    CalculateValueContext(final PortfolioShareItem portfolioShareItem, final Share share, final Date valueDate, final BigDecimal quantity) {
        this.portfolioShareItem = portfolioShareItem;
        this.share = share;
        this.valueDate = valueDate;
        this.quantity = quantity;
    }
}
