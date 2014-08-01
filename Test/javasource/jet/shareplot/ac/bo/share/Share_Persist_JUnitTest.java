package jet.shareplot.ac.bo.share;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static jet.framework.util.JUnitAsserter.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static jet.framework.util.JUnitAsserter.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.JUnitAsserter;
import jet.framework.util.exception.FormatedJetException;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * JUnit tests for the Share accessor methods, this is where the Share business
 * code will be tested.
 * 
 * @author JetToolsFramework
 */
public class Share_Persist_JUnitTest {

    /**
     * Save, creation
     * 
     * @throws FormatedJetException should be thrown as saving invalid share
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        assert shareAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Share share = new Share(shareAC);
        // TODO set up invalid share

        // act : run the test
        share.save();

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
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        assert shareAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Share share = new Share(shareAC);
        // TODO set up valid share

        // simulate the AI PK generation
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(final InvocationOnMock invocation) {
                share.get_IdShare_Model().setNodeValue(Long.valueOf(1));
                return null;
            }
        }).when(storeNut).createDataModel(JUnitAsserter.nonNull(any(Model.class)));

        // act : run the test
        try {
            share.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).createDataModel(share.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareResource.RESOURCE_NAME), any(ShareResource.class));
        assertFalse(share.isNew());
    }

    /**
     * Save, update
     * 
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveUpdate() throws Exception {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        assert shareAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Share share = new Share(shareAC);
        share.get_IdShare_Model().setNodeValue(Long.valueOf(1));
        // TODO set up valid share

        // act : run the test
        try {
            share.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).updateDataModel(share.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareResource.RESOURCE_NAME), any(ShareResource.class));
        assertFalse(share.isNew());
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        assert shareAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Share share = new Share(shareAC);

        // act : run the test
        try {
            share.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, never()).removeDataModel(share.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC, never()).notifyListeners(eq(ShareResource.RESOURCE_NAME), any(ShareResource.class));
        assertTrue(share.isNew());
    }

    /**
     * Delete old record
     * 
     * @throws Exception
     */
    @org.junit.Test
    public void testDeleteOld() throws Exception {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        assert shareAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Share share = new Share(shareAC);
        share.get_IdShare_Model().setNodeValue(Long.valueOf(1));

        // simulate the AI PK clear
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(final InvocationOnMock invocation) {
                share.get_IdShare_Model().setNodeValue(null);
                return null;
            }
        }).when(storeNut).removeDataModel(JUnitAsserter.nonNull(any(Model.class)));

        // act : run the test
        try {
            share.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).removeDataModel(share.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareResource.RESOURCE_NAME), any(ShareResource.class));
        assertTrue(share.isNew());
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
