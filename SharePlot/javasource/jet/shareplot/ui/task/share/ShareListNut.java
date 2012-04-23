package jet.shareplot.ui.task.share;

import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class ShareListNut extends AbstractSharePlotNut {

    private UITableComponent2 tableList;
    private UITableListDisplay3 uiTableListDisplay3;

    @Initializer
    public final void doShareListNutInit() throws JETException {

        initShareList();

    }

    private void initShareList() throws JETException {
        final Model listDisplayModel = getConfigurationNode("APPLICATION_COMPONENT_CONFIG.SHARE_LIST");
        this.tableList = (UITableComponent2) UIComponentFinder.findComponent("tableList", getMainComponent());
        this.uiTableListDisplay3 = new UITableListDisplay3(this.tableList, getUIContext(), listDisplayModel, getSession(), getLogger());
    }

}
