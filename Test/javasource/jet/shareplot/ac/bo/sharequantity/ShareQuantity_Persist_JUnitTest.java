package jet.shareplot.ac.bo.sharequantity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
 * JUnit tests for the ShareQuantity accessor methods, this is where the ShareQuantity business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class ShareQuantity_Persist_JUnitTest {

    /**
     * Save, creation
     *
     * @throws FormatedJetException should be thrown as saving invalid shareQuantity
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final AbstractShareQuantityBOApplicationComponent shareQuantityAC = mock(AbstractShareQuantityBOApplicationComponent.class);        assert shareQuantityAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO set up invalid shareQuantity

        // act : run the test
        shareQuantity.save();

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
        final AbstractShareQuantityBOApplicationComponent shareQuantityAC = mock(AbstractShareQuantityBOApplicationComponent.class);        assert shareQuantityAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO set up valid shareQuantity

        // act : run the test
        try {
            shareQuantity.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).createDataModel(shareQuantity.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareQuantityResource.RESOURCE_NAME), any(ShareQuantityResource.class));
        assertFalse(shareQuantity.isNew());
    }

    /**
     * Save, update
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveUpdate() throws Exception {
        // arrange : set up the test
        final AbstractShareQuantityBOApplicationComponent shareQuantityAC = mock(AbstractShareQuantityBOApplicationComponent.class);        assert shareQuantityAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));
        // TODO set up valid shareQuantity

        // act : run the test
        try {
            shareQuantity.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).updateDataModel(shareQuantity.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareQuantityResource.RESOURCE_NAME), any(ShareQuantityResource.class));
        assertFalse(shareQuantity.isNew());
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final AbstractShareQuantityBOApplicationComponent shareQuantityAC = mock(AbstractShareQuantityBOApplicationComponent.class);        assert shareQuantityAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        try {
            shareQuantity.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, never()).removeDataModel(shareQuantity.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC, never()).notifyListeners(eq(ShareQuantityResource.RESOURCE_NAME), any(ShareQuantityResource.class));
        assertTrue(shareQuantity.isNew());
    }

    /**
     * Delete old record
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testDeleteOld() throws Exception {
        // arrange : set up the test
        final AbstractShareQuantityBOApplicationComponent shareQuantityAC = mock(AbstractShareQuantityBOApplicationComponent.class);        assert shareQuantityAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        try {
            shareQuantity.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).removeDataModel(shareQuantity.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareQuantityResource.RESOURCE_NAME), any(ShareQuantityResource.class));
        assertTrue(shareQuantity.isNew());
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
