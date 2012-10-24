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
import jet.shareplot.persistence.dmc.ShareQuantityDMC;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityHome;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityRemote;
import jet.shareplot.persistence.pojo.ShareQuantityItem;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * ShareQuantity DataSourceExecutor2
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareQuantityDSE extends AbstractDataSourceExecutor2<ShareQuantityHome, ShareQuantityRemote> {

    private static final long serialVersionUID = 1077646545L;
    private ShareQuantityHome ejbHome;
    private DataModelConverter2<ShareQuantityRemote> dataModelConverter;

    @Override
    public void updateFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ShareQuantityRemote ejbObject = getObjectFromStore(dataModel);
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
                final ShareQuantityItem shareQuantityItem = new ShareQuantityItem(dataModel);

                final ShareQuantityHome shareQuantityHome = getEJBHome();
                final ShareQuantityRemote shareQuantityRemote = shareQuantityHome.create(shareQuantityItem.getIdShareQuantity(), shareQuantityItem.getChangeFee(), shareQuantityItem.getChangeQuantity(), shareQuantityItem.getChangeType(), shareQuantityItem.getChangeValue(), shareQuantityItem.getDescription(), shareQuantityItem.getIdShare(), shareQuantityItem.getValueDate());

                // has autoincrement PK, must update
                shareQuantityItem.get_IdShareQuantity_Model().setNodeValue(shareQuantityRemote.getIdShareQuantity());

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
                final ShareQuantityRemote shareQuantityRemote = getObjectFromStore(dataModel);
                shareQuantityRemote.remove();
                return null;
            }
        };

        callUpdateTransaction(callable);

        // if has autoincrement PK, must reset pk to null
        final ShareQuantityItem shareQuantityItem = new ShareQuantityItem(dataModel);
        shareQuantityItem.get_IdShareQuantity_Model().setNodeValue(null);
    }

    @Override
    public ShareQuantityHome getEJBHome() {
        if (this.ejbHome == null) {
            try {
                this.ejbHome = (ShareQuantityHome) new InitialContext().lookup(JetConstants.EJB_CONTEXT + ShareQuantityHome.BEAN_NAME);
            } catch (final NamingException e) {
                throw new IllegalArgumentException("Unable to locate EJB Home : " + ShareQuantityHome.BEAN_NAME, e);
            }
            if (this.ejbHome == null) {
                throw new IllegalArgumentException("Unknown EJB : " + ShareQuantityHome.BEAN_NAME);
            }
        }
        return this.ejbHome;
    }

    @Override
    public DataModelConverter2<ShareQuantityRemote> getDataModelConverter() {
        if (this.dataModelConverter == null) {
            this.dataModelConverter = new ShareQuantityDMC();
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
    private ShareQuantityRemote getObjectFromStore(final Model dataModel) throws JETException, ObjectNotFoundException {
        assert dataModel != null : "Can not delete null model";

        final ShareQuantityItem shareQuantityItem = new ShareQuantityItem(dataModel);
        final ShareQuantityHome shareQuantityHome = getEJBHome();

        ShareQuantityRemote shareQuantityRemote;
        try {
            shareQuantityRemote = shareQuantityHome.findByPrimaryKey(shareQuantityItem.getIdShareQuantity());
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw e;
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return shareQuantityRemote;
    }
}