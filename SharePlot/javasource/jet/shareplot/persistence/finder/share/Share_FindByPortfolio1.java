package jet.shareplot.persistence.finder.share;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter2;
import jet.framework.manager.datamodel.interfaces.DataSourceExecutor2;
import jet.framework.manager.datamodel.interfaces.FinderObjectNotFoundException;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.util.ejb.EJBModelList2;
import jet.shareplot.persistence.dse.ShareDSE;
import jet.shareplot.persistence.ejb.share.ShareHome;
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.util.throwable.JETException;

/**
 * Class for the findByPortfolio FinderMethod object for the Share component.
 *
 * SQL Query : where idPortfolio = ?
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class Share_FindByPortfolio1 implements FinderMethod {

    private static final long serialVersionUID = -1265738400L;
    DataSourceExecutor2<ShareHome, ShareRemote> dse;

    Long idPortfolio;
    /**
     * Set idPortfolio argument value
     *
     * @param idPortfolio argument value
     */
    public void setIdPortfolio(final Long idPortfolio) {
        this.idPortfolio = idPortfolio;
    }


    @Override
    public String getFinderName() {
        return "findByPortfolio";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idPortfolio", this.idPortfolio);
        return args;
    }

    @Override
    public ModelArray callFinder() throws JETException, FinderObjectNotFoundException {

        List<ShareRemote> list;
        DataModelConverter2<ShareRemote> dmc;
        try {
            final ShareHome share = getDataSourceExecutor2().getEJBHome();
            list = (List<ShareRemote>) share.findByPortfolio(this.idPortfolio);

            dmc = getDataSourceExecutor2().getDataModelConverter();
        } catch (final RemoteException e) {
            throw new JETException(e.getMessage(), e);
        } catch (final ObjectNotFoundException e) {
            throw new FinderObjectNotFoundException(e.getMessage(), e);
        } catch (final FinderException e) {
            throw new JETException(e.getMessage(), e);
        }

        return new EJBModelList2<ShareRemote>(list, dmc);
    }

    private DataSourceExecutor2<ShareHome, ShareRemote> getDataSourceExecutor2() {
        if (this.dse == null) {
            this.dse = new ShareDSE();
        }
        return this.dse;
    }

}
