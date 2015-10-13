package jet.shareplot.ui.task.share.provider;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.framework.ui.utils.table.AbstractComboBoxCellProvider;
import jet.framework.ui.utils.table.AbstractComboBoxColumnHeaderProvider;
import jet.shareplot.persistence.pojo.ShareQuantityItem;
import jet.util.models.interfaces.Model;

public class QuantityTypeCellProvider extends AbstractComboBoxCellProvider<String, ShareQuantityItem> {

    public QuantityTypeCellProvider(@NonNull final AbstractComboBoxColumnHeaderProvider<String> columnProvider) {
        super(columnProvider);
    }

    @Override
    protected jet.framework.ui.utils.table.AbstractComboBoxCellProvider.ComboBoxCellModel<String, ShareQuantityItem> getComboBoxCellModel(@NonNull final AbstractComboBoxColumnHeaderProvider<String> columnProvider, @NonNull final Model dataModel) {
        // TODO Auto-generated method stub
        return null;
    }

    private class QuantityTypeModel extends jet.framework.ui.utils.table.AbstractComboBoxCellProvider.ComboBoxCellModel<String, ShareQuantityItem> {

        private static final long serialVersionUID = -7965941469935762552L;

        public QuantityTypeModel(final @NonNull AbstractComboBoxColumnHeaderProvider<String> columnProvider, final @NonNull ShareQuantityItem item) {
            super(columnProvider, item);

            initComboBox();
        }

        @Override
        protected String getKey(final @NonNull ShareQuantityItem item) {
            return item.getChangeType();
        }

        @Override
        protected void setKey(final @NonNull ShareQuantityItem item, final @Nullable String keyString) {
            item.setChangeType(keyString);
        }

    }

}
