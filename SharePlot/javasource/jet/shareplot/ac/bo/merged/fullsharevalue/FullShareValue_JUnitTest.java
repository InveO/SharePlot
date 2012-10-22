package jet.shareplot.ac.bo.merged.fullsharevalue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.merged.FullShareValueItem;

import org.junit.runner.RunWith;

import com.objectpartners.buesing.premock.PreMock;
import com.objectpartners.buesing.premock.PreMockJUnit4ClassRunner;

/**
 * JUnit skeleton for the FullShareValue object
 *
 * @author JetToolsFramework
 */
@PreMock({ FullShareValue.class, FullShareValueItem.class })
@RunWith(PreMockJUnit4ClassRunner.class)
public class FullShareValue_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testFullShareValue() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        // act : run the test
        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(fullShareValue);

        // values should be null
        // TODO adapt these conditions, default values may be set, making them not null
        assertNull(fullShareValue.getIdShareValue());
        assertNull(fullShareValue.getCodeISIN());
        assertNull(fullShareValue.getCodeYahoo());
        assertNull(fullShareValue.getDescription());
        assertNull(fullShareValue.getIdPortfolio());
        assertNull(fullShareValue.getIdShare());
        assertNull(fullShareValue.getName());
        assertNull(fullShareValue.getValue());
        assertNull(fullShareValue.getValueDate());

        assertTrue(fullShareValue.isNotNullableNull());

        // starts up as new
        assertTrue(fullShareValue.isNew());

        // data nodes should be non null
        assertNotNull(fullShareValue.get_IdShareValue_Model());
        assertNotNull(fullShareValue.get_CodeISIN_Model());
        assertNotNull(fullShareValue.get_CodeYahoo_Model());
        assertNotNull(fullShareValue.get_Description_Model());
        assertNotNull(fullShareValue.get_IdPortfolio_Model());
        assertNotNull(fullShareValue.get_IdShare_Model());
        assertNotNull(fullShareValue.get_Name_Model());
        assertNotNull(fullShareValue.get_Value_Model());
        assertNotNull(fullShareValue.get_ValueDate_Model());

        assertNotNull(fullShareValue.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testFullShareValueModel() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValueItem item = new FullShareValueItem();

        // act : run the test
        final FullShareValue fullShareValue = new FullShareValue(item.get_Model(), fullShareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(fullShareValue);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testFullShareValueModelData() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValueItem item = new FullShareValueItem();
        // TODO insert data in FullShareValueItem

        // act : run the test
        final FullShareValue fullShareValue = new FullShareValue(item.get_Model(), fullShareValueAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(fullShareValue);
        // TODO check that data is in the fullShareValue
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testFullShareValueModelNull() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        // act : run the test
        new FullShareValue(null, fullShareValueAC);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testFullShareValueFullShareValue() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue item = new FullShareValue(fullShareValueAC);

        // act : run the test
        final FullShareValue fullShareValue = new FullShareValue(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(fullShareValue);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testFullShareValueFullShareValueData() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue item = new FullShareValue(fullShareValueAC);
        // TODO insert data in FullShareValue

        // act : run the test
        final FullShareValue fullShareValue = new FullShareValue(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(fullShareValue);
        // TODO check that data is in the fullShareValue
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testFullShareValueFullShareValueNull() {
        // arrange : set up the test
        final FullShareValue item = null;

        // act : run the test
        new FullShareValue(item);

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
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // act : run the test
        final boolean result = fullShareValue.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        fullShareValue.setIdPortfolio(Long.valueOf(1));
        fullShareValue.setIdShare(Long.valueOf(1));
        fullShareValue.setName("");
        fullShareValue.setValue(java.math.BigDecimal.valueOf(1));
        fullShareValue.setValueDate(new java.util.Date());

        // act : run the test
        final boolean result = fullShareValue.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue otherFullShareValue = mock(FullShareValue.class);
        // TODO init mock pk
        // eg : when(otherFullShareValue.getIdFullShareValue()).thenReturn(Long.valueOf(1));

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO init fullShareValue pk
        // eg : fullShareValue.get_IdFullShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = fullShareValue.isPkEquals(otherFullShareValue);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue otherFullShareValue = mock(FullShareValue.class);
        // TODO init mock pk
        // eg : when(otherFullShareValue.getIdFullShareValue()).thenReturn(Long.valueOf(1));

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO init fullShareValue pk
        // eg : fullShareValue.get_IdFullShareValue_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = fullShareValue.isPkEquals(otherFullShareValue);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final FullShareValue otherFullShareValue = mock(FullShareValue.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // act : run the test
        final boolean result = fullShareValue.isPkEquals(otherFullShareValue);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO init fullShareValue pk
        // eg : fullShareValue.get_IdFullShareValue_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = fullShareValue.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // act : run the test
        final JFErrorHandler result = fullShareValue.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // act : run the test
        fullShareValue.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = fullShareValue.getJFErrorHandler();
        assertNotNull(result);
    }

    /**
     * isValid with valid object
     */
    @org.junit.Test
    public void testIsValidTrue() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO set up valid fullShareValue

        // act : run the test
        final boolean result = fullShareValue.isValid();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isValid with NON valid object
     */
    @org.junit.Test
    public void testIsValidFalse() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO set up NON valid fullShareValue

        // act : run the test
        final boolean result = fullShareValue.isValid();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isNew with a new fullShareValue
     */
    @org.junit.Test
    public void testIsNewTrue() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);

        // act : run the test
        final boolean result = fullShareValue.isNew();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNew with an old fullShareValue
     */
    @org.junit.Test
    public void testIsNewFalse() {
        // arrange : set up the test
        final FullShareValueApplicationComponent fullShareValueAC = mock(FullShareValueApplicationComponent.class);

        final FullShareValue fullShareValue = new FullShareValue(fullShareValueAC);
        // TODO set up NON new fullShareValue

        // act : run the test
        final boolean result = fullShareValue.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }
}
