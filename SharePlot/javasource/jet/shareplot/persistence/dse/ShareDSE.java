package jet.shareplot.persistence.dse;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jet.framework.manager.datamodel.interfaces.AbstractDataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.JETDuplicateKeyException;
import jet.shareplot.persistence.dmc.ShareDMC;
import jet.shareplot.persistence.ejb.share.ShareHome;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Share DataSourceExecutor2
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareDSE extends AbstractDataSourceExecutor2<ShareHome, ShareRemote> {

    private static final long serialVersionUID = -1265738400L;
    private ShareHome ejbHome;
    private DataModelConverter2<ShareRemote> dataModelConverter;

    @Override
    public void updateFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ShareRemote ejbObject = getObjectFromStore(dataModel);
                getDataModelConverter().writeDataModelToObject(dataModel, ejbObject);
                return null;
            }
        };

        callUpdateTransaction(callable);
    }

    @Override
    public void createFromDataModel(final Model dataModel) throws JETException, JETDuplicateKeyException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ShareItem shareItem = new ShareItem(dataModel);

                final ShareHome shareHome = getEJBHome();
                final ShareRemote shareRemote = shareHome.create(shareItem.getIdShare(), shareItem.getCodeISIN(), shareItem.getCodeYahoo(), shareItem.getDescription(), shareItem.getIdPortfolio(), shareItem.getName());

                // has autoincrement PK, must update
                shareItem.get_IdShare_Model().setNodeValue(shareRemote.getIdShare());

                return null;
            }
        };

        callCreateTransaction(callable);
    }

    @Override
    public void removeFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ShareRemote shareRemote = getObjectFromStore(dataModel);
                shareRemote.remove();
                return null;
            }
        };

        callUpdateTransaction(callable);

        // if has autoincrement PK, must reset pk to null
        final ShareItem shareItem = new ShareItem(dataModel);
        shareItem.get_IdShare_Model().setNodeValue(null);
    }

    @Override
    public ShareHome getEJBHome() {
        if (this.ejbHome == null) {
            try {
                this.ejbHome = (ShareHome) new InitialContext().lookup(JetConstants.EJB_CONTEXT + ShareHome.BEAN_NAME);
            } catch (final NamingException e) {
                throw new IllegalArgumentException("Unable to locate EJB Home : " + ShareHome.BEAN_NAME, e);
            }
            if (this.ejbHome == null) {
                throw new IllegalArgumentException("Unknown EJB : " + ShareHome.BEAN_NAME);
            }
        }
        return this.ejbHome;
    }

    @Override
    public DataModelConverter2<ShareRemote> getDataModelConverter() {
        if (this.dataModelConverter == null) {
            this.dataModelConverter = new ShareDMC();
        }

        return this.dataModelConverter;
    }

    /**
     * Get object from the persistant store corresponding to the data Model. Depending on the implementation
     * it may not be necessary to provide a full data Model.
     * <p>
     * This should be used with care as this may entail Transaction problems, depending on the underlying persistance layer.
     * </p>
     *
     * @param dataModel Model identifying the object to retrieve
     * @return E Persistent object corresponding to the Model
     * @throws JETException Thrown if there was an error whilst retrieving the object
     * @throws ObjectNotFoundException Thrown if there is no corresponding object
     */
    private ShareRemote getObjectFromStore(final Model dataModel) throws JETException, ObjectNotFoundException {
        assert dataModel != null : "Can not delete null model";

        final ShareItem shareItem = new ShareItem(dataModel);
        final ShareHome shareHome = getEJBHome();

        ShareRemote shareRemote;
        try {
            shareRemote = shareHome.findByPrimaryKey(shareItem.getIdShare());
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw e;
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return shareRemote;
    }
}