package jet.shareplot.ui.task.share.provider;

import jet.framework.ui.utils.table.AbstractComboBoxColumnHeaderProvider;
import jet.shareplot.ac.bo.sharequantity.ShareQuantity;

public class QuantityTypeColumnProvider extends AbstractComboBoxColumnHeaderProvider<String> {

    private static final long serialVersionUID = -3198660826820197679L;

    public QuantityTypeColumnProvider(final String columnName) {
        super(columnName);
    }

    @Override
    protected void addItems() {
        addItem(ShareQuantity.CHANGE_TYPE_PURCHASE, "SharePlot/properties/task/Share/changeType.Purchase");
        addItem(ShareQuantity.CHANGE_TYPE_SALE, "SharePlot/properties/task/Share/changeType.Sale");
        addItem(ShareQuantity.CHANGE_TYPE_FEE, "SharePlot/properties/task/Share/changeType.Fee");
    }
}
