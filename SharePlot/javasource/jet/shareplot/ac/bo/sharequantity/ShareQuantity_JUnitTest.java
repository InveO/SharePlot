package jet.shareplot.ac.bo.sharequantity;

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

import java.math.BigDecimal;
import java.util.Date;

import jet.container.managers.session.interfaces.Session;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.exception.FormatedJetException;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.ShareQuantityItem;
import jet.util.throwable.JETException;

/**
 * JUnit skeleton for the ShareQuantity object
 * 
 * @author JetToolsFramework
 */
public class ShareQuantity_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testShareQuantity() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(shareQuantity);

        // values should be null
        // TODO adapt these conditions, default values may be set, making them not null
        assertNull(shareQuantity.getIdShareQuantity());
        assertNull(shareQuantity.getChangeFee());
        assertNull(shareQuantity.getChangeQuantity());
        assertNull(shareQuantity.getChangeType());
        assertNull(shareQuantity.getChangeValue());
        assertNull(shareQuantity.getDescription());
        assertNull(shareQuantity.getIdShare());
        assertNull(shareQuantity.getValueDate());

        assertTrue(shareQuantity.isNotNullableNull());

        // starts up as new
        assertTrue(shareQuantity.isNew());

        // data nodes should be non null
        assertNotNull(shareQuantity.get_IdShareQuantity_Model());
        assertNotNull(shareQuantity.get_ChangeFee_Model());
        assertNotNull(shareQuantity.get_ChangeQuantity_Model());
        assertNotNull(shareQuantity.get_ChangeType_Model());
        assertNotNull(shareQuantity.get_ChangeValue_Model());
        assertNotNull(shareQuantity.get_Description_Model());
        assertNotNull(shareQuantity.get_IdShare_Model());
        assertNotNull(shareQuantity.get_ValueDate_Model());

        assertNotNull(shareQuantity.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareQuantityModel() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantityItem item = new ShareQuantityItem();

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item.get_Model(), shareQuantityAC);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(shareQuantity);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareQuantityModelData() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantityItem item = new ShareQuantityItem();
        // TODO insert data in ShareQuantityItem

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item.get_Model(), shareQuantityAC);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(shareQuantity);
        // TODO check that data is in the shareQuantity
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testShareQuantityModelNull() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        // act : run the test
        new ShareQuantity(null, shareQuantityAC);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareQuantityShareQuantity() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity item = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(shareQuantity);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareQuantityShareQuantityData() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity item = new ShareQuantity(shareQuantityAC);
        // TODO insert data in ShareQuantity

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item);

        // assert : verify that the test run correctly
        // object should be instanciated
        assertNotNull(shareQuantity);
        // TODO check that data is in the shareQuantity
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testShareQuantityShareQuantityNull() {
        // arrange : set up the test
        final ShareQuantity item = null;

        // act : run the test
        new ShareQuantity(item);

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
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final boolean result = shareQuantity.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        shareQuantity.setChangeFee(BigDecimal.valueOf(1));
        shareQuantity.setChangeQuantity(BigDecimal.valueOf(1));
        shareQuantity.setChangeType("");
        shareQuantity.setChangeValue(BigDecimal.valueOf(1));
        shareQuantity.setIdShare(Long.valueOf(1));
        shareQuantity.setValueDate(new Date());

        // act : run the test
        final boolean result = shareQuantity.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity otherShareQuantity = mock(ShareQuantity.class);
        // TODO init mock pk
        // eg : when(otherShareQuantity.getIdShareQuantity()).thenReturn(Long.valueOf(1));

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO init shareQuantity pk
        // eg : shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = shareQuantity.isPkEquals(otherShareQuantity);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity otherShareQuantity = mock(ShareQuantity.class);
        // TODO init mock pk
        // eg : when(otherShareQuantity.getIdShareQuantity()).thenReturn(Long.valueOf(1));

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO init shareQuantity pk
        // eg : shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = shareQuantity.isPkEquals(otherShareQuantity);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final ShareQuantity otherShareQuantity = mock(ShareQuantity.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final boolean result = shareQuantity.isPkEquals(otherShareQuantity);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO init shareQuantity pk
        // eg : shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = shareQuantity.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final JFErrorHandler result = shareQuantity.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        shareQuantity.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = shareQuantity.getJFErrorHandler();
        assertNotNull(result);
    }

    /**
     * isValid with valid object
     */
    @org.junit.Test
    public void testIsValidTrue() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO set up valid shareQuantity

        // act : run the test
        final boolean result = shareQuantity.isValid();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isValid with NON valid object
     */
    @org.junit.Test
    public void testIsValidFalse() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO set up NON valid shareQuantity

        // act : run the test
        final boolean result = shareQuantity.isValid();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isNew with a new shareQuantity
     */
    @org.junit.Test
    public void testIsNewTrue() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final boolean result = shareQuantity.isNew();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNew with an old shareQuantity
     */
    @org.junit.Test
    public void testIsNewFalse() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO set up NON new shareQuantity

        // act : run the test
        final boolean result = shareQuantity.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * Save, creation
     * 
     * @throws FormatedJetException should be thrown as saving invalid shareQuantity
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
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
     */
    @org.junit.Test
    public void testSaveCreateValid() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

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
    }

    /**
     * Save, update
     */
    @org.junit.Test
    public void testSaveUpdate() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO set up valid shareQuantity
        // TODO init shareQuantity pk
        // eg : shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));

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
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
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
    }

    /**
     * Delete old record
     */
    @org.junit.Test
    public void testDeleteOld() {
        // arrange : set up the test
        final ShareQuantityApplicationComponent shareQuantityAC = mock(ShareQuantityApplicationComponent.class);
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(shareQuantityAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(shareQuantityAC.getStoreNut(anyString())).thenReturn(storeNut);

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        // TODO init shareQuantity pk
        // eg : shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));

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
    }

}
