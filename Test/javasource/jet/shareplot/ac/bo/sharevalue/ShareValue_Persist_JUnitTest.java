package jet.shareplot.ac.bo.sharevalue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.JUnitAsserter;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * JUnit tests for the ShareValue accessor methods, this is where the ShareValue business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class ShareValue_Persist_JUnitTest {

    /**
     * Save, creation
     *
     * @throws FormatedJetException should be thrown as saving invalid shareValue
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO set up invalid shareValue

        // act : run the test
        shareValue.save();

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
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO set up valid shareValue

        // simulate the AI PK generation
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(final InvocationOnMock invocation) {
                shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));
                return null;
            }
        }).when(storeNut).createDataModel(JUnitAsserter.nonNull(any(Model.class)));

        // act : run the test
        try {
            shareValue.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).createDataModel(shareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareValueResource.RESOURCE_NAME), any(ShareValueResource.class));
        assertFalse(shareValue.isNew());
    }

    /**
     * Save, update
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveUpdate() throws Exception {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));
        // TODO set up valid shareValue

        // act : run the test
        try {
            shareValue.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).updateDataModel(shareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareValueResource.RESOURCE_NAME), any(ShareValueResource.class));
        assertFalse(shareValue.isNew());
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        try {
            shareValue.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, never()).removeDataModel(shareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC, never()).notifyListeners(eq(ShareValueResource.RESOURCE_NAME), any(ShareValueResource.class));
        assertTrue(shareValue.isNew());
    }

    /**
     * Delete old record
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testDeleteOld() throws Exception {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));

        // simulate the AI PK clear
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(final InvocationOnMock invocation) {
                shareValue.get_IdShareValue_Model().setNodeValue(null);
                return null;
            }
        }).when(storeNut).removeDataModel(JUnitAsserter.nonNull(any(Model.class)));

        // act : run the test
        try {
            shareValue.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).removeDataModel(shareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareValueResource.RESOURCE_NAME), any(ShareValueResource.class));
        assertTrue(shareValue.isNew());
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
