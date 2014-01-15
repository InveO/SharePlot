package jet.shareplot.ui.desktop.graph;

import jet.components.ui.table.common.UITablableComponent;
import jet.components.ui.table.common.model.TableContentProvider;
import jet.components.ui.table.common.model.TableRendererProvider;
import jet.components.ui.table.common.model.TableRendererProviderListener;
import jet.container.managers.ui.interfaces.UIComponentsFile;
import jet.container.managers.ui.interfaces.style.UIStyle;

public class LineGraphTableRendererProvider implements TableRendererProvider {

    @Override
    public UITablableComponent getTableColumnHeaderModel(final int col) {
        return null;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getColumnIndex(final String columnName) {
        return 0;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        String result = null;
        if (columnIndex == 0) {
            result = "Dates";
        }
        if (columnIndex == 1) {
            result = "OBAM";
        }
        return result;
    }

    @Override
    public String getTooltipTextAt(final int row, final int col) {
        return null;
    }

    @Override
    public UIStyle getColumnStyleAt(final int col, final UIComponentsFile uiComponentsFile) {
        return null;
    }

    @Override
    public UIStyle getCellStyleAt(final int row, final int col, final TableContentProvider tableContentProvider, final UIComponentsFile uiComponentsFile) {
        return null;
    }

    @Override
    public void addTableRendererProviderListener(final TableRendererProviderListener listener) {

    }

    @Override
    public void removeTableRendererProviderListener(final TableRendererProviderListener listener) {

    }

    @Override
    public boolean isCellEditable(final int row, final int col, final TableContentProvider tableContentProvider) {
        return false;
    }

}
