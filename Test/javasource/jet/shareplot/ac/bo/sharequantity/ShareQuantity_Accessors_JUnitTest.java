package jet.shareplot.ac.bo.sharequantity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
// NOPMD import may not be used in generated code
// NOPMD import may not be used in generated code
// NOPMD import may not be used in generated code

/**
 * JUnit tests for the ShareQuantity accessor methods, this is where the ShareQuantity business
 * code will be tested.
 * 
 * @author JetToolsFramework
 */
public class ShareQuantity_Accessors_JUnitTest {

    /**
     * getIdShareQuantity with an new shareQuantity
     */
    @org.junit.Test
    public void testGetIdShareQuantity() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final Long result = shareQuantity.getIdShareQuantity();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * getChangeFee with an new shareQuantity
     */
    @org.junit.Test
    public void testGetChangeFee() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final java.math.BigDecimal result = shareQuantity.getChangeFee();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setChangeFee with an new shareQuantity
     */
    @org.junit.Test
    public void testSetChangeFee() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final java.math.BigDecimal expectedValue = null;
        shareQuantity.setChangeFee(expectedValue);
        final java.math.BigDecimal result = shareQuantity.getChangeFee();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getChangeQuantity with an new shareQuantity
     */
    @org.junit.Test
    public void testGetChangeQuantity() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final java.math.BigDecimal result = shareQuantity.getChangeQuantity();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setChangeQuantity with an new shareQuantity
     */
    @org.junit.Test
    public void testSetChangeQuantity() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final java.math.BigDecimal expectedValue = null;
        shareQuantity.setChangeQuantity(expectedValue);
        final java.math.BigDecimal result = shareQuantity.getChangeQuantity();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getChangeType with an new shareQuantity
     */
    @org.junit.Test
    public void testGetChangeType() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final String result = shareQuantity.getChangeType();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setChangeType with an new shareQuantity
     */
    @org.junit.Test
    public void testSetChangeType() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        shareQuantity.setChangeType(expectedValue);
        final String result = shareQuantity.getChangeType();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getChangeValue with an new shareQuantity
     */
    @org.junit.Test
    public void testGetChangeValue() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final java.math.BigDecimal result = shareQuantity.getChangeValue();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setChangeValue with an new shareQuantity
     */
    @org.junit.Test
    public void testSetChangeValue() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final java.math.BigDecimal expectedValue = null;
        shareQuantity.setChangeValue(expectedValue);
        final java.math.BigDecimal result = shareQuantity.getChangeValue();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getDescription with an new shareQuantity
     */
    @org.junit.Test
    public void testGetDescription() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final String result = shareQuantity.getDescription();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setDescription with an new shareQuantity
     */
    @org.junit.Test
    public void testSetDescription() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        shareQuantity.setDescription(expectedValue);
        final String result = shareQuantity.getDescription();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getIdPortfolio with an new shareQuantity
     */
    @org.junit.Test
    public void testGetIdPortfolio() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final Long result = shareQuantity.getIdPortfolio();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIdPortfolio with an new shareQuantity
     */
    @org.junit.Test
    public void testSetIdPortfolio() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final Long expectedValue = null;
        shareQuantity.setIdPortfolio(expectedValue);
        final Long result = shareQuantity.getIdPortfolio();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getIdShare with an new shareQuantity
     */
    @org.junit.Test
    public void testGetIdShare() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final Long result = shareQuantity.getIdShare();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIdShare with an new shareQuantity
     */
    @org.junit.Test
    public void testSetIdShare() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final Long expectedValue = null;
        shareQuantity.setIdShare(expectedValue);
        final Long result = shareQuantity.getIdShare();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getValueDate with an new shareQuantity
     */
    @org.junit.Test
    public void testGetValueDate() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        final java.util.Date result = shareQuantity.getValueDate();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setValueDate with an new shareQuantity
     */
    @org.junit.Test
    public void testSetValueDate() {
        // arrange : set up the test
        final ShareQuantityBOApplicationComponent shareQuantityAC = mock(ShareQuantityBOApplicationComponent.class);
        assert shareQuantityAC != null;

        final ShareQuantity shareQuantity = new ShareQuantity(shareQuantityAC);

        // act : run the test
        // TODO set proper expected value
        final java.util.Date expectedValue = null;
        shareQuantity.setValueDate(expectedValue);
        final java.util.Date result = shareQuantity.getValueDate();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

}
