package jet.shareplot.ac.portfolio;

import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.shareplot.util.TextUtils;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class Portfolio extends PortfolioItem {

    private final PortfolioApplicationComponent portfolioAC;

    public Portfolio(final PortfolioApplicationComponent portfolioAC) {
        super();
        this.portfolioAC = portfolioAC;
    }

    public Portfolio(final Model model, final PortfolioApplicationComponent portfolioAC) {
        super(model);
        this.portfolioAC = portfolioAC;
    }

    public Portfolio(final Portfolio portfolio) {
        super(portfolio);
        this.portfolioAC = portfolio.portfolioAC;
    }

    public boolean isValid() {
        System.err.println("[Portfolio] isValid - isNotNullableNull() : " + isNotNullableNull());
        System.err.println("[Portfolio] isValid - TextUtils.isEmpty(getName() : " + TextUtils.isEmpty(getName()));
        return !isNotNullableNull() && !TextUtils.isEmpty(getName());
    }

    public void save() throws FormatedJetException {
        if (isValid()) {
            final StoreNut storeNut = this.portfolioAC.getStoreNut(SelectStoreApplicationComponent.PORTFOLIO_STORE);
            try {
                if (getIdPortfolio() == null) {
                    storeNut.createDataModel(get_Model());
                } else {
                    storeNut.updateDataModel(get_Model());
                }
            } catch (final FinderObjectNotFoundException e) {
                this.portfolioAC.logp(JETLevel.SEVERE, "Portfolio", "save", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, "SharePlot/properties/task/Share/dialog.CanNotSavePortfolio", args, e);
            } catch (final JETException e) {
                this.portfolioAC.logp(JETLevel.SEVERE, "Portfolio", "save", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, "SharePlot/properties/task/Share/dialog.CanNotSavePortfolio", args, e);
            }
        } else {
            final Object[] args = { getName() };
            throw new FormatedJetException(null, "SharePlot/properties/task/Share/dialog.PortfolioNotValid", args, null);
        }
    }

    public void delete() throws FormatedJetException {
        if (getIdPortfolio() != null) {
            final StoreNut storeNut = this.portfolioAC.getStoreNut(SelectStoreApplicationComponent.PORTFOLIO_STORE);
            try {
                storeNut.removeDataModel(get_Model());
            } catch (final FinderObjectNotFoundException e) {
                this.portfolioAC.logp(JETLevel.SEVERE, "Portfolio", "delete", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, "SharePlot/properties/task/Share/dialog.CanNotDeletePortfolio", args, e);
            } catch (final JETException e) {
                this.portfolioAC.logp(JETLevel.SEVERE, "Portfolio", "delete", e.getMessage(), e);
                final Object[] args = { getName() };
                throw new FormatedJetException(null, "SharePlot/properties/task/Share/dialog.CanNotDeletePortfolio", args, e);
            }
        }
    }

}
