package jet.shareplot.ac.bo.sharevalue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * JUnit tests for the ShareValue accessor methods, this is where the ShareValue business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class ShareValue_Accessors_JUnitTest {

    /**
     * getIdShareValue with an new shareValue
     */
    @org.junit.Test
    public void testGetIdShareValue() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final Long result = shareValue.getIdShareValue();

        // assert : verify that the test run correctly
        assertNull(result);
    }


    /**
     * getIdShare with an new shareValue
     */
    @org.junit.Test
    public void testGetIdShare() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final Long result = shareValue.getIdShare();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIdShare with an new shareValue
     */
    @org.junit.Test
    public void testSetIdShare() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        // TODO set proper expected value
        final Long expectedValue = null;
        shareValue.setIdShare(expectedValue);
        final Long result = shareValue.getIdShare();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getValue with an new shareValue
     */
    @org.junit.Test
    public void testGetValue() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final java.math.BigDecimal result = shareValue.getValue();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setValue with an new shareValue
     */
    @org.junit.Test
    public void testSetValue() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        // TODO set proper expected value
        final java.math.BigDecimal expectedValue = null;
        shareValue.setValue(expectedValue);
        final java.math.BigDecimal result = shareValue.getValue();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getValueDate with an new shareValue
     */
    @org.junit.Test
    public void testGetValueDate() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        final java.util.Date result = shareValue.getValueDate();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setValueDate with an new shareValue
     */
    @org.junit.Test
    public void testSetValueDate() {
        // arrange : set up the test
        final AbstractShareValueBOApplicationComponent shareValueAC = mock(AbstractShareValueBOApplicationComponent.class);

        final ShareValue shareValue = new ShareValue(shareValueAC);

        // act : run the test
        // TODO set proper expected value
        final java.util.Date expectedValue = null;
        shareValue.setValueDate(expectedValue);
        final java.util.Date result = shareValue.getValueDate();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

}
