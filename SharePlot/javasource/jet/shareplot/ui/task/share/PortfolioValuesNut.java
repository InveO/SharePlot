package jet.shareplot.ui.task.share;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.components.ui.events.KeyEvent;
import jet.components.ui.text.common.UIDateComponent;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.util.ui.UIComponentHelper;
import jet.lifecycle.annotations.Deinitializer;
import jet.lifecycle.annotations.Initializer;
import jet.shareplot.ac.bo.portfolio.Portfolio;
import jet.shareplot.ac.bo.share.ShareBOApplicationComponent;
import jet.shareplot.ui.AbstractSharePlotNut;
import jet.util.throwable.JETException;

public class PortfolioValuesNut extends AbstractSharePlotNut {

    private UIButtonComponent saveButton;
    private UIDateComponent dateField;
    private Portfolio portfolio;
    private ShareBOApplicationComponent shareAC;

    @Initializer
    public final void doPortfolioValuesNutInit() throws JETException {

        this.saveButton = (UIButtonComponent) UIComponentFinder.findComponent("saveButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.saveButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.S));

        // get date field
        this.dateField = (UIDateComponent) UIComponentFinder.findComponent("date", getMainComponent());

        // get share list
        this.portfolio = (Portfolio) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_PORTFOLIO);
        this.shareAC = ShareBOApplicationComponent.getInstance(getSession());

    }

    @Deinitializer
    public final void doPortfolioValuesNutDeInit() {

    }

    @Override
    public void componentClicked(final UIComponent component) {

    }

}
