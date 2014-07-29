package jet.shareplot.ui.task.share.graph;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import jet.components.ui.table.common.model.TableContentProvider;
import jet.components.ui.table.common.model.TableContentProviderListener;
import jet.shareplot.ac.bo.sharevalue.ShareValue;
import jet.util.models.interfaces.Model;

public class ShareValueLineGraphContentProvider implements TableContentProvider {

    private final List<ShareValue> values;

    public ShareValueLineGraphContentProvider(@NonNull final List<ShareValue> values) {
        this.values = values;
    }

    @Override
    public int getRowCount() {
        return this.values.size();
    }

    @Override
    public Model getModelAt(final int row, final int col) {
        Model result = null;
        final ShareValue shareValue = this.values.get(row);
        if (col == 0) {
            result = shareValue.get_ValueDate_Model();
        }
        if (col == 1) {
            result = shareValue.get_Value_Model();
        }
        return result;
    }

    @Override
    public void addTableContentProviderListener(final TableContentProviderListener listener) {
        // nothing to do
    }

    @Override
    public void removeTableContentProviderListener(final TableContentProviderListener listener) {
        // nothing to do
    }

}
