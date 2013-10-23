package jet.shareplot.ui.task.share;

import jet.framework.util.models.UIModelHelper;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

public class ShareDetailNut extends AbstractSharePlotNut {

    private Share share;

    @Initializer
    public final void doShareDetailNutInit() throws JETException {

        this.share = (Share) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_SHARE);

        final Object[] args = { this.share.getName() };
        final Displayable titleDisp = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareDetailName", args);
        setHeaderTitle(titleDisp);

        displayShareDetails();

        displayShareGraph();

    }

    private void displayShareDetails() throws JETException {
        UIModelHelper.setDataModelNodeToField(this.share.get_CodeISIN_Model(), "isinField", false, getMainComponent(), null);
    }

    private void displayShareGraph() {
        // TODO Auto-generated method stub

    }

}
