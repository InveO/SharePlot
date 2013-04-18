package jet.shareplot.ac.bo.sharequantity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.ShareQuantityItem;

import org.junit.runner.RunWith;

import com.objectpartners.buesing.premock.PreMock;
import com.objectpartners.buesing.premock.PreMockJUnit4ClassRunner;

/**
 * JUnit skeleton for the ShareQuantity object
 * 
 * @author JetToolsFramework
 */
@PreMock({ ShareQuantity.class, ShareQuantityItem.class })
@RunWith(PreMockJUnit4ClassRunner.class)
public class ShareQuantity_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testShareQuantity() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // assert : verify that the test run correctly
        // object should be instantiated
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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
        final ShareQuantityItem item = new ShareQuantityItem();

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item.get_Model(), shareQuantityAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareQuantity);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareQuantityModelData() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
        final ShareQuantityItem item = new ShareQuantityItem();
        // TODO insert data in ShareQuantityItem
        item.setChangeFee(java.math.BigDecimal.valueOf(1));
        item.setChangeQuantity(java.math.BigDecimal.valueOf(1));
        item.setChangeType("");
        item.setChangeValue(java.math.BigDecimal.valueOf(1));
        item.setDescription("");
        item.setIdShare(Long.valueOf(1));
        item.setValueDate(new java.util.Date());

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item.get_Model(), shareQuantityAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareQuantity);
        // TODO check that data is in the shareQuantity
        assertEquals(shareQuantity.getChangeFee(), java.math.BigDecimal.valueOf(1));
        assertEquals(shareQuantity.getChangeQuantity(), java.math.BigDecimal.valueOf(1));
        assertEquals(shareQuantity.getChangeType(), "");
        assertEquals(shareQuantity.getChangeValue(), java.math.BigDecimal.valueOf(1));
        assertEquals(shareQuantity.getDescription(), "");
        assertEquals(shareQuantity.getIdShare(), Long.valueOf(1));
        assertNotNull(shareQuantity.getValueDate());
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareQuantityShareQuantity() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
        final ShareQuantity item = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareQuantity);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareQuantityShareQuantityData() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
        final ShareQuantity item = new ShareQuantity(shareQuantityAC);
        // TODO insert data in ShareQuantity
        item.setChangeFee(java.math.BigDecimal.valueOf(1));
        item.setChangeQuantity(java.math.BigDecimal.valueOf(1));
        item.setChangeType("");
        item.setChangeValue(java.math.BigDecimal.valueOf(1));
        item.setDescription("");
        item.setIdShare(Long.valueOf(1));
        item.setValueDate(new java.util.Date());

        // act : run the test
        final ShareQuantity shareQuantity = new ShareQuantity(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareQuantity);
        // TODO check that data is in the shareQuantity
        assertEquals(shareQuantity.getChangeFee(), java.math.BigDecimal.valueOf(1));
        assertEquals(shareQuantity.getChangeQuantity(), java.math.BigDecimal.valueOf(1));
        assertEquals(shareQuantity.getChangeType(), "");
        assertEquals(shareQuantity.getChangeValue(), java.math.BigDecimal.valueOf(1));
        assertEquals(shareQuantity.getDescription(), "");
        assertEquals(shareQuantity.getIdShare(), Long.valueOf(1));
        assertNotNull(shareQuantity.getValueDate());
    }

    /**
     * isNotNullableNull
     */
    @org.junit.Test
    public void testIsNotNullableNullTrue() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        shareQuantity.setChangeFee(java.math.BigDecimal.valueOf(1));
        shareQuantity.setChangeQuantity(java.math.BigDecimal.valueOf(1));
        shareQuantity.setChangeType("");
        shareQuantity.setChangeValue(java.math.BigDecimal.valueOf(1));
        shareQuantity.setIdShare(Long.valueOf(1));
        shareQuantity.setValueDate(new java.util.Date());

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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;
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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

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
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);
        shareQuantity.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = shareQuantity.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }
}
