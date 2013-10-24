package jet.shareplot.ui.task.share;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import jet.components.ui.events.MouseEvent;
import jet.components.ui.events.MouseEventType;
import jet.components.ui.events.UIEvent;
import jet.components.ui.table.common.UITableComponent2;
import jet.framework.ui.desktop.ApplicationComponentLauncher;
import jet.framework.ui.desktop.navigation.menu.CleanCloseException;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.share.ShareBOApplicationComponent;
import jet.shareplot.ac.bo.share.ShareResource;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.shareplot.ui.desktop.SharePlotACLauncher;
import jet.shareplot.ui.task.TaskNameConstants;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.throwable.JETException;

public class ShareListNut extends AbstractSharePlotListNut<Share> {

    private ShareBOApplicationComponent shareAC;

    @Override
    public <T extends Enum<T>> void tableCellEvent(final UITableComponent2 table, final int row, final int col, final UIEvent<T> uiEvent) {
        if (this.tableList == table) {
            if (uiEvent instanceof MouseEvent) {
                // if the row is double clicked the current contact must be edited
                final MouseEvent me = (MouseEvent) uiEvent;
                if (me.getType() == MouseEventType.LEFT_CLICK) {

                    final String colName = this.uiTableListDisplay3.getColumnName(col);

                    if ("editColumn".equals(colName)) {
                        final Share share = this.items.get(row);
                        launchEditor(TaskNameConstants.SHARE_DETAIL, share, new ShareDetailNutKey(share.getIdShare()));
                    } else if ("editValueColumn".equals(colName)) {
                        final Share share = this.items.get(row);
                        launchEditor(TaskNameConstants.SHARE_VALUE, share, new ShareValueListNutKey(share.getIdShare()));
                    }
                }
            }
        }
    }

    private void launchEditor(final String editorName, @Nonnull final Share share, final Object key) {
        final ApplicationComponentLauncher acLauncher = (ApplicationComponentLauncher) getSession().getProperty(ApplicationComponentLauncher.SESSION_KEY);

        if (acLauncher != null) {
            try {
                final Map<String, Object> initArgs = new HashMap<String, Object>();
                initArgs.put(ShareUIConstants.ARGUMENT_SHARE, new Share(share));
                initArgs.put(SharePlotACLauncher.AC_KEY_PARAMETER, key);

                acLauncher.launchApplicationComponent(editorName, initArgs);
            } catch (final JETException e) {
                logp(JETLevel.SEVERE, "ShareListNut", "launchEditor", e.getMessage(), e);
            } catch (final CleanCloseException e) {
                logp(JETLevel.INFO, "PortfolioListNut", "launchPortfolioEditor", e.getMessage());
            }
        }
    }

    @Override
    protected void preInit() throws JETException {
        this.shareAC = ShareBOApplicationComponent.getInstance(getSession());
    }

    @Override
    protected void postInit() throws JETException {
        // nothing to do
    }

    @Override
    protected List<Share> findItems() {
        return this.shareAC.getShares();
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.SHARE_LIST";
    }

    @Override
    protected Share createNewItem() {
        final ShareBOApplicationComponent assertNonNull = AnnotationsHelper.assertNonNull(this.shareAC);
        final Share share = new Share(assertNonNull);
        return share;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        // nothing to do
    }

    @Override
    @Nonnull
    protected String getResourceName() {
        return AnnotationsHelper.assertNonNull(ShareResource.RESOURCE_NAME);
    }

    @Override
    protected Share getItemCopy(@Nonnull final Share item) {
        return new Share(item);
    }

    @Override
    protected void postSave() {
        // nothing to do
    }

    @Override
    protected void preSave() {
        // nothing to do
    }

}
