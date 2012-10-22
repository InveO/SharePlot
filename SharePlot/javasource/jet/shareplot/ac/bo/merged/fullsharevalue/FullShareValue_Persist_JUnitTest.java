package jet.shareplot.ac.bo.merged.fullsharevalue;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.util.throwable.JETException;

/**
 * JUnit tests for the FullShareValue accessor methods, this is where the FullShareValue business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class FullShareValue_Persist_JUnitTest {

    /**
     * Save, creation
     *
     * @throws FormatedJetException should be thrown as saving invalid fullShareValue
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(fullShareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(fullShareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO set up invalid fullShareValue

        // act : run the test
        fullShareValue.save();

        // assert : verify that the test run correctly
        fail("Expected an exception");
    }

    /**
     * Save, creation
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveCreateValid() throws Exception {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(fullShareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(fullShareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO set up valid fullShareValue

        // act : run the test
        try {
            fullShareValue.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).createDataModel(fullShareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(FullShareValueResource.RESOURCE_NAME), any(FullShareValueResource.class));
    }

    /**
     * Save, update
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveUpdate() throws Exception {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(fullShareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(fullShareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO set up valid fullShareValue
        // TODO init fullShareValue pk
        // eg : fullShareValue.get_IdFullShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        try {
            fullShareValue.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).updateDataModel(fullShareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(FullShareValueResource.RESOURCE_NAME), any(FullShareValueResource.class));
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(fullShareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(fullShareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // act : run the test
        try {
            fullShareValue.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, never()).removeDataModel(fullShareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC, never()).notifyListeners(eq(FullShareValueResource.RESOURCE_NAME), any(FullShareValueResource.class));
    }

    /**
     * Delete old record
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testDeleteOld() throws Exception {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(fullShareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(fullShareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO init fullShareValue pk
        // eg : fullShareValue.get_IdFullShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        try {
            fullShareValue.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).removeDataModel(fullShareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(FullShareValueResource.RESOURCE_NAME), any(FullShareValueResource.class));
    }

    @SuppressWarnings("boxing")
    private void setupTransaction() throws Exception {
        final javax.naming.Context context = jet.framework.util.junit.InitialContext2_JUnitTest.initInitialContext();
        final jet.container.managers.jta.interfaces.JTAManagerContext jtaContext = mock(jet.container.managers.jta.interfaces.JTAManagerContext.class);
        final javax.transaction.TransactionManager transactionManager = mock(javax.transaction.TransactionManager.class);
        when(context.lookup(jet.framework.util.JetConstants.MANAGERS_CONTEXT + jet.container.managers.jta.interfaces.JTAManagerContext.NAME)).thenReturn(jtaContext);
        when(jtaContext.getTransactionManager()).thenReturn(transactionManager);
        when(transactionManager.getStatus()).thenReturn(javax.transaction.Status.STATUS_NO_TRANSACTION);
        transactionManager.begin();
        transactionManager.commit();
    }
}
