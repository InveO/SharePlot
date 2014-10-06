package jet.shareplot.ac.bo.sharevalue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static jet.framework.util.JUnitAsserter.mock;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.ShareValueItem;
import jet.util.models.interfaces.Model;

import org.junit.runner.RunWith;

import com.objectpartners.buesing.premock.PreMock;
import com.objectpartners.buesing.premock.PreMockJUnit4ClassRunner;

/**
 * JUnit skeleton for the ShareValue object
 *
 * @author JetToolsFramework
 */
@PreMock({ ShareValue.class, ShareValueItem.class })
@RunWith(PreMockJUnit4ClassRunner.class)
public class ShareValue_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testShareValue() {
        // arrange : set up the test
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final ShareValueItem item = new ShareValueItem();
        // TODO insert data in ShareValueItem
        item.setIdShare(Long.valueOf(1));
        item.setValue(java.math.BigDecimal.valueOf(1));
        item.setValueDate(new java.util.Date());

        // act : run the test
        final ShareValue shareValue = new ShareValue(item.get_Model(), shareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);
        // TODO check that data is in the shareValue
        assertEquals(shareValue.getIdShare(), Long.valueOf(1));
        assertEquals(shareValue.getValue(), java.math.BigDecimal.valueOf(1));
        assertNotNull(shareValue.getValueDate());
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareValueShareValue() {
        // arrange : set up the test
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
        final ShareValue item = new ShareValue(shareValueAC);
        // TODO insert data in ShareValue
        item.setIdShare(Long.valueOf(1));
        item.setValue(java.math.BigDecimal.valueOf(1));
        item.setValueDate(new java.util.Date());

        // act : run the test
        final ShareValue shareValue = new ShareValue(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(shareValue);
        // TODO check that data is in the shareValue
        assertEquals(shareValue.getIdShare(), Long.valueOf(1));
        assertEquals(shareValue.getValue(), java.math.BigDecimal.valueOf(1));
        assertNotNull(shareValue.getValueDate());
    }

    /**
     * isNotNullableNull
     */
    @org.junit.Test
    public void testIsNotNullableNullTrue() {
        // arrange : set up the test
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;
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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

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
        final ShareValueBOApplicationComponent shareValueAC = mock(ShareValueBOApplicationComponent.class);
        assert shareValueAC != null;

        final ShareValue shareValue = new ShareValue(shareValueAC);
        shareValue.get_IdShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = shareValue.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }
}
