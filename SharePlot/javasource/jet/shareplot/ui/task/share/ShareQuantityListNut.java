package jet.shareplot.ui.task.share;

import java.util.List;

import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.sharequantity.ShareQuantity;
import jet.shareplot.ac.bo.sharequantity.ShareQuantityApplicationComponent;
import jet.shareplot.ac.bo.sharequantity.ShareQuantityResource;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.shareplot.ui.task.share.provider.QuantityTypeCellProvider;
import jet.shareplot.ui.task.share.provider.QuantityTypeColumnProvider;
import jet.util.models.interfaces.Displayable;
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
    protected ShareQuantity createNewItem() {
        final ShareQuantity quantity = new ShareQuantity(this.shareQuantityAC);
        quantity.setIdShare(this.share.getIdShare());
        return quantity;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        final QuantityTypeColumnProvider quantityTypeColumnProvider = new QuantityTypeColumnProvider("typeColumn");
        uiTableListDisplay.addListTableColumnHeaderProvider(quantityTypeColumnProvider);
        uiTableListDisplay.addListTableCellModelProvider(new QuantityTypeCellProvider(quantityTypeColumnProvider));
    }

    @Override
    protected String getResourceName() {
        return ShareQuantityResource.RESOURCE_NAME;
    }

    @Override
    protected ShareQuantity getItemCopy(final ShareQuantity item) {
        return new ShareQuantity(item);
    }
}
