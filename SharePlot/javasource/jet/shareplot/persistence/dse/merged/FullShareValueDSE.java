package jet.shareplot.persistence.dse.merged;

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
import jet.shareplot.persistence.dmc.merged.FullShareValueDMC;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueHome;
import jet.shareplot.persistence.ejb.sharevalue.ShareValueRemote;
import jet.shareplot.persistence.ejb.share.ShareHome;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.shareplot.persistence.pojo.merged.FullShareValueItem;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * FullShareValue DataSourceExecutor2
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class FullShareValueDSE extends AbstractDataSourceExecutor2<ShareValueHome, ShareValueRemote> {

    private static final long serialVersionUID = 1303211696L;
    private ShareValueHome ejbHome;
    private ShareHome secondaryEJBHome;
    private DataModelConverter2<ShareValueRemote> dataModelConverter;

    @Override
    public void updateFromDataModel(final Model dataModel) throws JETException, ObjectNotFoundException {
        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ShareValueRemote ejbObject = getObjectFromStore(dataModel);
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
                final FullShareValueItem fullShareValueItem = new FullShareValueItem(dataModel);

                // check if secondary object already exists
                ShareRemote secondaryEJBObject = null;
                if ( fullShareValueItem.getIdShare() != null) {
                    try {
                        secondaryEJBObject = getSecondaryObjectFromStore(dataModel);
                    } catch (final ObjectNotFoundException e) {
                        // do nothing, will create secondary object
                    }
                }

                // create secondary item first
                if (secondaryEJBObject == null) {
                    // does not exist yet, must be created
                    final ShareHome shareHome = getSecondaryEJBHome();
                    secondaryEJBObject = shareHome.create( fullShareValueItem.getIdShare(), fullShareValueItem.getCodeISIN(), fullShareValueItem.getCodeYahoo(), fullShareValueItem.getDescription(), fullShareValueItem.getIdPortfolio(), fullShareValueItem.getName());

                    // has autoincrement PK, must update
                    fullShareValueItem.get_IdShare_Model().setNodeValue(secondaryEJBObject.getIdShare());
                }

                // create primary item
                final ShareValueHome shareValueHome = getEJBHome();
                final ShareValueRemote shareValueRemote = shareValueHome.create(fullShareValueItem.getIdShareValue(), fullShareValueItem.getIdShare(), fullShareValueItem.getValue(), fullShareValueItem.getValueDate());

                // has autoincrement PK, must update
                fullShareValueItem.get_IdShareValue_Model().setNodeValue(shareValueRemote.getIdShareValue());

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
                final ShareValueRemote shareValueRemote = getObjectFromStore(dataModel);
                shareValueRemote.remove();

                // TODO, for the moment only the primary object will be removed, the secondary
                // may be referenced elsewhere
                // final EJBObject secondaryEJBObject = getSecondaryObjectFromStore(dataModel);
                // secondaryEJBObject.remove();
                return null;
            }
        };

        callUpdateTransaction(callable);

        // if has autoincrement PK, must reset pk to null
        final FullShareValueItem fullShareValueItem = new FullShareValueItem(dataModel);
        fullShareValueItem.get_IdShareValue_Model().setNodeValue(null);
    }

    @Override
    public ShareValueHome getEJBHome() {
        if (this.ejbHome == null) {
            try {
                this.ejbHome = (ShareValueHome) new InitialContext().lookup(JetConstants.EJB_CONTEXT + ShareValueHome.BEAN_NAME);
            } catch (final NamingException e) {
                throw new IllegalArgumentException("Unable to locate EJB Home : " + ShareValueHome.BEAN_NAME, e);
            }
            if (this.ejbHome == null) {
                throw new IllegalArgumentException("Unknown EJB : " + ShareValueHome.BEAN_NAME);
            }
        }
        return this.ejbHome;
    }

    /**
     * @return Secondary ejb home interface
     */
    public ShareHome getSecondaryEJBHome() {
        if (this.secondaryEJBHome == null) {
            try {
                this.secondaryEJBHome = (ShareHome) new InitialContext().lookup(JetConstants.EJB_CONTEXT + ShareHome.BEAN_NAME);
            } catch (final NamingException e) {
                throw new IllegalArgumentException("Unable to locate EJB Home : " + ShareHome.BEAN_NAME, e);
            }
            if (this.secondaryEJBHome == null) {
                throw new IllegalArgumentException("Unknown EJB : " + ShareHome.BEAN_NAME);
            }
        }
        return this.secondaryEJBHome;
    }

    @Override
    public DataModelConverter2<ShareValueRemote> getDataModelConverter() {
        if (this.dataModelConverter == null) {
            this.dataModelConverter = new FullShareValueDMC(this);
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
    private ShareValueRemote getObjectFromStore(final Model dataModel) throws JETException, ObjectNotFoundException {
        assert dataModel != null : "Can not delete null model";

        final FullShareValueItem fullShareValueItem = new FullShareValueItem(dataModel);
        final ShareValueHome shareValueHome = getEJBHome();

        ShareValueRemote shareValueRemote;
        try {
            shareValueRemote = shareValueHome.findByPrimaryKey(fullShareValueItem.getIdShareValue());
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw e;
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return shareValueRemote;
    }

    /**
     * Get object from the persistant store corresponding to the data Model. Depending on the implementation
     * it may not be necessary to provide a full data Model.
     * <p>
     * This should be used with care as this may entail Transaction problems, depending on the underlying persistance layer.
     * </p>
     *
     * @param dataModel Model identifying the object to retreive
     * @return E Persistant object corresponding to the Model
     * @throws JETException Thrown if there was an error whilst retreiving the object
     * @throws ObjectNotFoundException Thrown if there is no corresponding object
     */
    private ShareRemote getSecondaryObjectFromStore(final Model dataModel) throws JETException, ObjectNotFoundException {
        assert dataModel != null : "Can not delete null model";

        final FullShareValueItem item = new FullShareValueItem(dataModel);
        final ShareHome home = getSecondaryEJBHome();

        ShareRemote remote;
        try {
            remote = home.findByPrimaryKey(item.getIdShareValue());
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw e;
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }
        return remote;
    }

}