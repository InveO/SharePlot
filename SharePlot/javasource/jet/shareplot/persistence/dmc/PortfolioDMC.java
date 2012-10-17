package jet.shareplot.persistence.dmc;

import javax.ejb.EJBObject;

import jet.framework.manager.datamodel.interfaces.DataModelConverter;
import jet.framework.manager.datamodel.interfaces.DataModelManagerContext;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class PortfolioDMC implements DataModelConverter<EJBObject> {

    @Override
    public void setDatasourceConversionModel(final Model datasourceConversionModel) {
        throw new Ill
    }

    @Override
    public void setLogger(final Logger logger) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDataModelManagerContext(final DataModelManagerContext dataModelManagerContext) {
        // TODO Auto-generated method stub

    }

    @Override
    public Model readDataModelFromObject(final EJBObject dataObject) throws JETException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void writeDataModelToObject(final Model dataModel, final EJBObject dataObject) throws JETException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setName(final String name) {
        // TODO Auto-generated method stub

    }

}
