package jet.shareplot.ac.bo.sharevalue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.RollbackException;
import javax.transaction.TransactionManager;

import jet.container.managers.jta.interfaces.JTAManagerContext;
import jet.framework.component.SimpleApplicationComponent;
import jet.framework.manager.datamodel.interfaces.ModelArray;
import jet.framework.nuts.select.FinderMethod;
import jet.framework.nuts.select.SelectNut;
import jet.framework.nuts.select.SelectNutHelper;
import jet.framework.util.JetConstants;
import jet.framework.util.jta.TransactionHelper;
import jet.shareplot.ac.SelectStoreApplicationComponent;
import jet.shareplot.persistence.finder.sharevalue.ShareValue_FindAll0;
import jet.util.logger.JETLevel;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * ShareValue manipulation API
 *
 * Generated by JetTools, do not change this file, it will be overriden at each generation
 *
 * @author JetToolsFramework
 */
abstract class AbstractShareValueApplicationComponent extends SimpleApplicationComponent {

    private static final long serialVersionUID = 1303211696L;

    private TransactionManager transactionManager;

    /**
     * Return all shareValue matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the ShareValues
     * @return a list of shareValue matching the FinderMethod.
     * @see List
     * @see ShareValue
     */
    protected List<ShareValue> getShareValues(final FinderMethod finder) {
        final List<ShareValue> result = new ArrayList<ShareValue>();
        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.SHAREVALUE_SELECT);
        final AbstractShareValueApplicationComponent shareValueAC = this;

        final Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                final ModelArray ma = SelectNutHelper.getModelArray(selectNut, finder, getLogger());
                if (ma != null) {
                    final int size = ma.getSize();
                    for (int i = 0; i < size; i++) {
                        final Model model = ma.get(i);
                        final ShareValue shareValue = new ShareValue(model, shareValueAC);
                        result.add(shareValue);
                    }
                }
                return null;
            }
        };
        try {
            final TransactionManager transactionMgr = getTransactionManager();
            TransactionHelper.runTransaction(callable, transactionMgr);
        } catch (final ObjectNotFoundException e) {
            logp(JETLevel.SEVERE, "AbstractShareValueApplicationComponent", "getShareValues", e.getMessage(), e);
        } catch (final JETException e) {
            logp(JETLevel.SEVERE, "AbstractShareValueApplicationComponent", "getShareValues", e.getMessage(), e);
        } catch (final RollbackException e) {
            logp(JETLevel.SEVERE, "AbstractShareValueApplicationComponent", "getShareValues", e.getMessage(), e);
        } catch (final NamingException e) {
            logp(JETLevel.SEVERE, "AbstractShareValueApplicationComponent", "getShareValues", e.getMessage(), e);
        }

        return result;
    }

    private TransactionManager getTransactionManager() throws NamingException {
        if (this.transactionManager == null) {
            final JTAManagerContext jtaCtxt = (JTAManagerContext) new InitialContext().lookup(JetConstants.MANAGERS_CONTEXT + JTAManagerContext.NAME);
            this.transactionManager = jtaCtxt.getTransactionManager();
        }
        return this.transactionManager;
    }

    /**
     * Return the first shareValue matching the FinderMethod.
     *
     * @param finder FinderMethod to use to fetch the ShareValue
     * @return the shareValue matching the FinderMethod.
     * @see ShareValue
     */
    protected ShareValue getShareValue(final FinderMethod finder) {
        final ShareValue result;

        final SelectNut selectNut = getSelectNut(SelectStoreApplicationComponent.SHAREVALUE_SELECT);
        final Model model = SelectNutHelper.getModel(selectNut, finder, getLogger());
        if (model != null) {
            result = new ShareValue(model, this);
        } else {
            result = null;
        }

        return result;
    }

    /**
     * Sample method making a call to getShareValues(final FinderMethod finder).
     *
     * @return a list of shareValue matching the FinderMethod.
     * @see List
     * @see ShareValue
     * @see #getShareValues(FinderMethod finder)
     */
    public List<ShareValue> getShareValues() {
        final ShareValue_FindAll0 finder = new ShareValue_FindAll0();

        return getShareValues(finder);
    }

}
