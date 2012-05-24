package jet.shareplot.ui.task.share;

import java.util.List;

import jet.framework.util.exception.FormatedJetException;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.share.ShareApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class ShareListNut extends AbstractSharePlotListNut<Share> {

    private ShareApplicationComponent shareAC;
    private Portfolio portfolio;

    @Override
    protected void preInit() throws JETException {
        this.portfolio = (Portfolio) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_PORTFOLIO);
        this.shareAC = ShareApplicationComponent.getInstance(getSession());
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<Share> findItems() {
        return this.shareAC.getShares(this.portfolio);
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.SHARE_LIST";
    }

    @Override
    protected boolean isItemValid(final Share item) {
        boolean result;
        if (item == null) {
            result = true;
        } else {
            result = item.isValid();
        }
        return result;
    }

    @Override
    protected Model getItemModel(final Share item) {
        return item.get_Model();
    }

    @Override
    protected Share createNewItem() {
        final Share share = new Share(this.shareAC);
        share.setIdPortfolio(this.portfolio.getIdPortfolio());
        return share;
    }

    @Override
    protected void deleteItem(final Share item) throws FormatedJetException {
        item.delete();
    }

    @Override
    protected void saveItem(final Share item) throws FormatedJetException {
        item.save();
    }

}
