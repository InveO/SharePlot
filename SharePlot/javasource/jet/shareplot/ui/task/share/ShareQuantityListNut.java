package jet.shareplot.ui.task.share;

import java.util.List;

import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.sharequantity.ShareQuantity;
import jet.shareplot.ac.bo.sharequantity.ShareQuantityApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.shareplot.ui.task.share.provider.QuantityTypeCellProvider;
import jet.shareplot.ui.task.share.provider.QuantityTypeColumnProvider;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class ShareQuantityListNut extends AbstractSharePlotListNut<ShareQuantity> {

    private ShareQuantityApplicationComponent shareQuantityAC;
    private Share share;

    @Override
    protected void preInit() throws JETException {
        this.share = (Share) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_SHARE);
        this.shareQuantityAC = ShareQuantityApplicationComponent.getInstance(getSession());

        final Object[] objects = { this.share.getName() };
        final Displayable displayable = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareQuantityListName", objects);
        setHeaderTitle(displayable);
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<ShareQuantity> findItems() {
        return this.shareQuantityAC.getShareQuantitys(this.share);
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.QUANTITY_LIST";
    }

    @Override
    protected boolean isItemValid(final ShareQuantity item) {
        boolean result;
        if (item == null) {
            result = true;
        } else {
            result = item.isValid();
        }
        return result;
    }

    @Override
    protected Model getItemModel(final ShareQuantity item) {
        return item.get_Model();
    }

    @Override
    protected ShareQuantity createNewItem() {
        final ShareQuantity quantity = new ShareQuantity(this.shareQuantityAC);
        quantity.setIdShare(this.share.getIdShare());
        return quantity;
    }

    @Override
    protected void deleteItem(final ShareQuantity item) throws FormatedJetException {
        item.delete();
    }

    @Override
    protected void saveItem(final ShareQuantity item) throws FormatedJetException {
        item.save();
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        final QuantityTypeColumnProvider quantityTypeColumnProvider = new QuantityTypeColumnProvider("typeColumn");
        uiTableListDisplay.addListTableColumnHeaderProvider(quantityTypeColumnProvider);
        uiTableListDisplay.addListTableCellModelProvider(new QuantityTypeCellProvider(quantityTypeColumnProvider));
    }
}
