package jet.shareplot.ui.task.share.provider;

import jet.framework.ui.utils.table.AbstractComboBoxColumnHeaderProvider;
import jet.shareplot.ac.bo.sharequantity.ChangeType;

public class QuantityTypeColumnProvider extends AbstractComboBoxColumnHeaderProvider<String> {

    private static final long serialVersionUID = -3198660826820197679L;

    public QuantityTypeColumnProvider(final String columnName) {
        super(columnName);
    }

    @Override
    protected void addItems() {
        for (final ChangeType changeType : ChangeType.values()) {
            addChangeType(changeType);
        }
    }

    private void addChangeType(final ChangeType changeType) {
        addItem(changeType.getCode(), changeType.getDisplayable());
    }
}
