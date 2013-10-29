package jet.shareplot.ui.task.share.provider;

import javax.annotation.Nonnull;

import jet.container.managers.session.interfaces.Session;
import jet.framework.ui.utils.CommonDisplayModelConstants;
import jet.framework.ui.utils.table.AutoCompleteListTableCellModelProvider;
import jet.framework.util.ui.table.AbstractTableContentProvider;
import jet.shareplot.ac.bo.share.Share;
import jet.shareplot.ac.bo.share.ShareAutoCompleteProvider;
import jet.shareplot.persistence.pojo.portfolio.PortfolioShareItem;
import jet.util.logger.Logger;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;

/**
 * Provide the Models for the share column in the PortfolioShare list.
 * 
 * @author daniel
 * 
 */
public class PortfolioShareShareProvider extends AutoCompleteListTableCellModelProvider {

    private static final long serialVersionUID = 4257316771233759031L;
    private final ShareAutoCompleteProvider shareAutoCompleteProvider;

    /**
     * AutoCompleteListTableCellModelProvider for a Share name column.
     * 
     * @param shareAutoCompleteProvider ShareAutoCompleteProvider
     * @param columnName Name of the column
     */
    public PortfolioShareShareProvider(@Nonnull final ShareAutoCompleteProvider shareAutoCompleteProvider, final String columnName) {
        super(shareAutoCompleteProvider, columnName, 0, true);
        this.shareAutoCompleteProvider = shareAutoCompleteProvider;
    }

    @Override
    public final SimpleEventModelImpl getAutoCompleteCellModel(final int row, final int col, @Nonnull final Model columnModel, @Nonnull final AbstractTableContentProvider listTableContentProvider, @Nonnull final Model dataModel, @Nonnull final Session session, @Nonnull final Logger logger) {
        SimpleEventModelImpl fieldModel = null;
        final String name = (String) columnModel.getAttribute(CommonDisplayModelConstants.ATTRIBUTE_NAME);
        if (this.columnName.equals(name)) {
            fieldModel = ShareNameModel.getShareNameModel(dataModel, this.shareAutoCompleteProvider);
        }
        return fieldModel;
    }

    /**
     * Share name model.
     * 
     * @author daniel
     * 
     */
    public static final class ShareNameModel extends SimpleEventModelImpl {

        private static final long serialVersionUID = -564995972416358582L;
        private final PortfolioShareItem portfolioShare;
        private final ShareAutoCompleteProvider shareAutoCompleteProvider;

        private ShareNameModel(@Nonnull final Model dataModel, final ShareAutoCompleteProvider shareAutoCompleteProvider) {
            this.portfolioShare = new PortfolioShareItem(dataModel);
            this.shareAutoCompleteProvider = shareAutoCompleteProvider;
        }

        /**
         * ShareNameModel factory method.
         * 
         * @param dataModel PortfolioShareItem dataModel
         * @param shareAutoCompleteProvider ShareAutoCompleteProvider
         * @return ShareNameModel
         */
        public static ShareNameModel getShareNameModel(@Nonnull final Model dataModel, final ShareAutoCompleteProvider shareAutoCompleteProvider) {
            final ShareNameModel result = new ShareNameModel(dataModel, shareAutoCompleteProvider);
            result.init();
            return result;
        }

        private void init() {
            final String shareName = this.portfolioShare.getShareName();
            if (shareName != null) {
                super.setNodeValue(shareName);
            }
        }

        @Override
        public void setNodeValue(final Object value) {
            if (value instanceof String) {
                final String shareName = (String) value;

                final Share share = this.shareAutoCompleteProvider.getShare(shareName);
                if (share == null) {
                    clearShare();
                } else {
                    this.portfolioShare.setIdShare(share.getIdShare());

                    super.setNodeValue(shareName);
                }
            } else {
                clearShare();
            }
        }

        private void clearShare() {
            this.portfolioShare.setIdShare(null);
            super.setNodeValue(null);
        }

    }

}
