package jet.shareplot.ac.bo.sharevalue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.util.throwable.JETException;

/**
 * JUnit skeleton for the ShareValue object
 *
 * @author JetToolsFramework
 */
public class ShareValue_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testShareValue() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        // act : run the test
        final ShareValue shareValue = new ShareValue(shareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);

        // values should be null
        // TODO adapt these conditions, default values may be set, making them not null
        assertNull(shareValue.getIdShareValue());
        assertNull(shareValue.getIdShare());
        assertNull(shareValue.getValue());
        assertNull(shareValue.getValueDate());

        assertTrue(shareValue.isNotNullableNull());

        // starts up as new
        assertTrue(shareValue.isNew());

        // data nodes should be non null
        assertNotNull(shareValue.get_IdShareValue_Model());
        assertNotNull(shareValue.get_IdShare_Model());
        assertNotNull(shareValue.get_Value_Model());
        assertNotNull(shareValue.get_ValueDate_Model());

        assertNotNull(shareValue.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareValueModel() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValueItem item = new ShareValueItem();

        // act : run the test
        final ShareValue shareValue = new ShareValue(item.get_Model(), shareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareValueModelData() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValueItem item = new ShareValueItem();
        // TODO insert data in ShareValueItem

        // act : run the test
        final ShareValue shareValue = new ShareValue(item.get_Model(), shareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);
        // TODO check that data is in the shareValue
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testShareValueModelNull() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        // act : run the test
        new ShareValue(null, shareValueAC);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareValueShareValue() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue item = new ShareValue(shareValueAC);

        // act : run the test
        final ShareValue shareValue = new ShareValue(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareValueShareValueData() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue item = new ShareValue(shareValueAC);
        // TODO insert data in ShareValue

        // act : run the test
        final ShareValue shareValue = new ShareValue(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);
        // TODO check that data is in the shareValue
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testShareValueShareValueNull() {
        // arrange : set up the test
        final ShareValue item = null;

        // act : run the test
        new ShareValue(item);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * isNotNullableNull
     */
    @org.junit.Test
    public void testIsNotNullableNullTrue() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final boolean result = shareValue.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue shareValue = new ShareValue(shareValueAC);
        shareValue.setIdShare(Long.valueOf(1));
        shareValue.setValue(java.math.BigDecimal.valueOf(1));
        shareValue.setValueDate(new java.util.Date());

        // act : run the test
        final boolean result = shareValue.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue otherShareValue = mock(ShareValue.class);
        // TODO init mock pk
        // eg : when(otherShareValue.getIdShareValue()).thenReturn(Long.valueOf(1));

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO init shareValue pk
        // eg : shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = shareValue.isPkEquals(otherShareValue);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue otherShareValue = mock(ShareValue.class);
        // TODO init mock pk
        // eg : when(otherShareValue.getIdShareValue()).thenReturn(Long.valueOf(1));

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO init shareValue pk
        // eg : shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = shareValue.isPkEquals(otherShareValue);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final ShareValue otherShareValue = mock(ShareValue.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final boolean result = shareValue.isPkEquals(otherShareValue);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO init shareValue pk
        // eg : shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = shareValue.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final JFErrorHandler result = shareValue.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        shareValue.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = shareValue.getJFErrorHandler();
        assertNotNull(result);
    }

    /**
     * isValid with valid object
     */
    @org.junit.Test
    public void testIsValidTrue() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO set up valid shareValue

        // act : run the test
        final boolean result = shareValue.isValid();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isValid with NON valid object
     */
    @org.junit.Test
    public void testIsValidFalse() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO set up NON valid shareValue

        // act : run the test
        final boolean result = shareValue.isValid();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isNew with a new shareValue
     */
    @org.junit.Test
    public void testIsNewTrue() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final boolean result = shareValue.isNew();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNew with an old shareValue
     */
    @org.junit.Test
    public void testIsNewFalse() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO set up NON new shareValue

        // act : run the test
        final boolean result = shareValue.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * Save, creation
     *
     * @throws FormatedJetException should be thrown as saving invalid shareValue
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
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
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
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
            verify(storeNut, only()).createDataModel(shareValue.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(ShareValueResource.RESOURCE_NAME), any(ShareValueResource.class));
    }

    /**
     * Save, update
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveUpdate() throws Exception {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO set up valid shareValue
        // TODO init shareValue pk
        // eg : shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));

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
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
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
    }

    /**
     * Delete old record
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testDeleteOld() throws Exception {
        // arrange : set up the test
        final ShareValueApplicationComponent shareValueAC = mock(ShareValueApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(shareValueAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareValueAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareValue shareValue = new ShareValue(shareValueAC);
        // TODO init shareValue pk
        // eg : shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));

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
    }

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
