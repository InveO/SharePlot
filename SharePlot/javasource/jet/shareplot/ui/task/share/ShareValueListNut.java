package jet.shareplot.ui.task.share;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;

import jet.components.ui.button.common.UIButtonComponent;
import jet.components.ui.common.common.UIComponent;
import jet.components.ui.events.KeyEvent;
import jet.container.managers.download.interfaces.DownloadContext;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.framework.manager.csv.interfaces.CSVLineProcessor;
import jet.framework.manager.csv.interfaces.CSVManagerContext;
import jet.framework.manager.csv.interfaces.CSVParameters;
import jet.framework.manager.csv.interfaces.DateParser;
import jet.framework.manager.csv.interfaces.DoubleParser;
import jet.framework.ui.utils.table.UITableListDisplay3;
import jet.framework.util.download.ByteArrayMultiFileReceiver;
import jet.framework.util.download.ByteArrayMultiFileReceiverListener;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.ui.LocalizedMessageFormatDisplayable;
import jet.framework.util.ui.UIComponentHelper;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.sharevalue.ShareValue;
import jet.shareplot.ac.bo.sharevalue.ShareValueBOApplicationComponent;
import jet.shareplot.ac.bo.sharevalue.ShareValueResource;
import jet.shareplot.ui.AbstractSharePlotListNut;
import jet.util.annotations.AnnotationsHelper;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Displayable;
import jet.util.throwable.JETException;

public class ShareValueListNut extends AbstractSharePlotListNut<ShareValue> implements ByteArrayMultiFileReceiverListener, CSVLineProcessor {

    private ShareValueBOApplicationComponent shareValueAC;
    private Share share;
    private UIButtonComponent importButton;
    private ByteArrayMultiFileReceiver byteArrayMultiFileReceiver;

    @Override
    protected void preInit() throws JETException {
        this.share = (Share) getApplicationComponent().getProperty(ShareUIConstants.ARGUMENT_SHARE);
        this.shareValueAC = ShareValueBOApplicationComponent.getInstance(getSession());

        final Object[] objects = { this.share.getName() };
        final Displayable displayable = new LocalizedMessageFormatDisplayable("SharePlot/properties/task/Share/title.ShareValueListName", objects);
        setHeaderTitle(displayable);
    }

    @Override
    protected void postInit() throws JETException {
        this.importButton = (UIButtonComponent) UIComponentFinder.findComponent("importButton", getMainComponent());
        UIComponentHelper.setTriggerComponentClickedOn(this.importButton, new KeyEvent(KeyEvent.CTRL_MASK, KeyEvent.Key.I));
    }

    @Override
    protected List<ShareValue> findItems() {
        return this.shareValueAC.getShareValues(this.share);
    }

    @Override
    protected String getListDisplayKey() {
        return "APPLICATION_COMPONENT_CONFIG.VALUE_LIST";
    }

    @Override
    protected ShareValue createNewItem() {
        final ShareValue quantity = new ShareValue(getShareValueAC());
        quantity.setIdShare(this.share.getIdShare());
        return quantity;
    }

    @Override
    protected void addListDisplayProviders(final UITableListDisplay3 uiTableListDisplay) {
        // nothing to do
    }

    @Override
    @Nonnull
    protected String getResourceName() {
        return AnnotationsHelper.assertNonNull(ShareValueResource.RESOURCE_NAME);
    }

    @Override
    protected ShareValue getItemCopy(@Nonnull final ShareValue item) {
        return new ShareValue(item);
    }

    @Override
    protected void postSave() {
        // nothing to do
    }

    @Override
    protected void preSave() {
        // nothing to do
    }

    @Override
    public void componentClicked(final UIComponent component) {
        super.componentClicked(component);
        if (this.importButton == component) {
            processImport();
        }
    }

    private void processImport() {
        try {
            final DownloadContext dc = (DownloadContext) getManagerContext(DownloadContext.NAME);
            this.byteArrayMultiFileReceiver = new ByteArrayMultiFileReceiver(getLogger());
            this.byteArrayMultiFileReceiver.addByteArrayMultiFileReceiverListener(this);
            dc.startUpload(this.byteArrayMultiFileReceiver, 1);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "ShareValueListNut", "processImport", e.getMessage(), e);
        }

    }

    /* (non-Javadoc)
     * @see jet.framework.util.download.ByteArrayMultiFileReceiverListener#fileReceived(boolean)
     */
    @Override
    public void fileReceived(final boolean isSuccess) {
        if (isSuccess && this.byteArrayMultiFileReceiver.getFileCount() > 0) {
            for (int i = 0; i < this.byteArrayMultiFileReceiver.getFileCount(); i++) {
                importFile(i);
            }
        } else if (this.byteArrayMultiFileReceiver.getFileCount() > 0) {
            logp(JETLevel.INFO, "ShareValueListNut", "fileReceived", "File is empty");
        }
    }

    private void importFile(final int i) {
        try {
            final CSVManagerContext csvCtxt = (CSVManagerContext) getManagerContext(CSVManagerContext.NAME);

            // get file content
            final byte[] file = this.byteArrayMultiFileReceiver.getByteArray(i);
            final ByteArrayInputStream is = new ByteArrayInputStream(file);

            // configure parameters
            final CSVParameters csvParameters = new CSVParameters();
            csvParameters.setLine(1);
            csvParameters.setSeparator(';');

            csvCtxt.readCSVFile(is, this, csvParameters);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "ShareValueListNut", "importFile", e.getMessage(), e);
        }
    }

    @Override
    public void processCSVLine(final String[] csvLine) {

        final String dateString = csvLine[0];
        final String valueString = csvLine[1];

        try {
            final Date date = DateParser.parse(DateParser.Format.ENGLISH, dateString);
            final BigDecimal value = DoubleParser.parseBigDecimal(DoubleParser.Format.COMMA, valueString);

            final ShareValue shareValue = new ShareValue(getShareValueAC());
            shareValue.setIdShare(this.share.getIdShare());
            shareValue.setValue(value);
            shareValue.setValueDate(date);

            shareValue.save();

        } catch (final ParseException e) {
            logp(JETLevel.SEVERE, "ShareValueListNut", "processCSVLine", e.getMessage(), e);
        } catch (final FormatedJetException e) {
            logp(JETLevel.SEVERE, "ShareValueListNut", "processCSVLine", e.getMessage(), e);
        }

    }

    @Nonnull
    private ShareValueBOApplicationComponent getShareValueAC() {
        return AnnotationsHelper.assertNonNull(this.shareValueAC);
    }

}
