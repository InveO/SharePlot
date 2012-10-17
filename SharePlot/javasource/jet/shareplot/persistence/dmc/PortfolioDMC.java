package jet.shareplot.persistence.dmc;

import java.rmi.RemoteException;

import javax.ejb.EJBException;

import jet.framework.manager.datamodel.interfaces.DataModelConverter;
import jet.framework.manager.datamodel.interfaces.DataModelManagerContext;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class PortfolioDMC implements DataModelConverter<PortfolioRemote> {

    @Override
    public void setDatasourceConversionModel(final Model datasourceConversionModel) {
        throw new UnsupportedOperationException("Not implemented in this case.");
    }

    @Override
    public void setLogger(final Logger logger) {
        throw new UnsupportedOperationException("Not implemented in this case.");
    }

    @Override
    public void setDataModelManagerContext(final DataModelManagerContext dataModelManagerContext) {
        throw new UnsupportedOperationException("Not implemented in this case.");
    }

    @Override
    public Model readDataModelFromObject(final PortfolioRemote dataObject) throws JETException {
        final PortfolioItem item = new PortfolioItem();

        try {
            item.get_IdPortfolio_Model().setNodeValue(dataObject.getIdPortfolio());
        } catch (final EJBException e) {
            throw new JETException("EJBException while reading from PortfolioRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while reading from PortfolioRemote.", e);
        }

        return item.get_Model();
    }

    @Override
    public void writeDataModelToObject(final Model dataModel, final PortfolioRemote dataObject) throws JETException {
        final PortfolioItem item = new PortfolioItem(dataModel);

        try {
            // do not update pk fields
            // dataObject.setIdPortfolio(item.getIdPortfolio());
            dataObject.setIsFake(item.getIsFake());
        } catch (final EJBException e) {
            throw new JETException("EJBException while writing to PortfolioRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while writing to PortfolioRemote.", e);
        }
    }

    @Override
    public void setName(final String name) {
        throw new UnsupportedOperationException("Not implemented in this case.");
    }

}
