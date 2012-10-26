package jet.shareplot.ac.bo.share;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * JUnit tests for the Share accessor methods, this is where the Share business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class Share_Accessors_JUnitTest {

    /**
     * getIdShare with an new share
     */
    @org.junit.Test
    public void testGetIdShare() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final Long result = share.getIdShare();

        // assert : verify that the test run correctly
        assertNull(result);
    }


    /**
     * getCodeISIN with an new share
     */
    @org.junit.Test
    public void testGetCodeISIN() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final String result = share.getCodeISIN();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setCodeISIN with an new share
     */
    @org.junit.Test
    public void testSetCodeISIN() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        share.setCodeISIN(expectedValue);
        final String result = share.getCodeISIN();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getCodeYahoo with an new share
     */
    @org.junit.Test
    public void testGetCodeYahoo() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final String result = share.getCodeYahoo();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setCodeYahoo with an new share
     */
    @org.junit.Test
    public void testSetCodeYahoo() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        share.setCodeYahoo(expectedValue);
        final String result = share.getCodeYahoo();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getDescription with an new share
     */
    @org.junit.Test
    public void testGetDescription() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final String result = share.getDescription();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setDescription with an new share
     */
    @org.junit.Test
    public void testSetDescription() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        share.setDescription(expectedValue);
        final String result = share.getDescription();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getIdPortfolio with an new share
     */
    @org.junit.Test
    public void testGetIdPortfolio() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final Long result = share.getIdPortfolio();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIdPortfolio with an new share
     */
    @org.junit.Test
    public void testSetIdPortfolio() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        // TODO set proper expected value
        final Long expectedValue = null;
        share.setIdPortfolio(expectedValue);
        final Long result = share.getIdPortfolio();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getName with an new share
     */
    @org.junit.Test
    public void testGetName() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final String result = share.getName();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setName with an new share
     */
    @org.junit.Test
    public void testSetName() {
        // arrange : set up the test
        final AbstractShareBOApplicationComponent shareAC = mock(AbstractShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        share.setName(expectedValue);
        final String result = share.getName();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

}
