package jet.shareplot.ui.task.share;

import java.util.List;

import jet.components.ui.graph.common.Animation;
import jet.components.ui.graph.common.Animation.Easing;
import jet.components.ui.graph.common.Axis;
import jet.components.ui.graph.common.GraphConfiguration;
import jet.components.ui.graph.common.LineChartConfiguration;
import jet.components.ui.graph.common.UIGraphComponent;
import jet.components.ui.table.common.model.TableContentProvider;
import jet.components.ui.table.common.model.TableRendererProvider;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.util.models.UIModelHelper;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.sharevalue.ShareValue;
import jet.shareplot.ac.bo.sharevalue.ShareValueBOApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.shareplot.ui.desktop.graph.LineGraphTableRendererProvider;
import jet.shareplot.ui.task.share.graph.ShareValueLineGraphContentProvider;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

public class ShareDetailNut extends AbstractSharePlotNut {

    private Share share;
    private ShareValueBOApplicationComponent shareValueAC;

    @Initializer
    public final void doShareDetailNutInit() throws JETException {

        this.share = (Share) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_SHARE);
        this.shareValueAC = ShareValueBOApplicationComponent.getInstance(getSession());

        final Object[] args = { this.share.getName() };
        final Displayable titleDisp = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareDetailName", args);
        setHeaderTitle(titleDisp);

        displayShareDetails();

        displayShareGraph();

    }

    private void displayShareDetails() throws JETException {
        UIModelHelper.setDataModelNodeToField(this.share.get_CodeISIN_Model(), "isinField", false, getMainComponent(), null);
    }

    private void displayShareGraph() throws JETException {

        final UIGraphComponent graph = (UIGraphComponent) UIComponentFinder.findComponent("lineChart", getMainComponent());

        final GraphConfiguration config = new LineChartConfiguration(new Axis("Date"), new Axis("Value"), new Animation(1000, Easing.out));
        graph.setGraphConfiguration(config);

        final List<ShareValue> values = this.shareValueAC.getShareValues(this.share);

        // first column in TCP is horizontal values
        // following columns in TCP is vertical values
        final TableRendererProvider tableRendererProvider = new LineGraphTableRendererProvider();
        graph.setTableRendererProvider(tableRendererProvider);
        final TableContentProvider shareValueContentProvider = new ShareValueLineGraphContentProvider(values);
        graph.setTableContentProvider(shareValueContentProvider);

    }

}
