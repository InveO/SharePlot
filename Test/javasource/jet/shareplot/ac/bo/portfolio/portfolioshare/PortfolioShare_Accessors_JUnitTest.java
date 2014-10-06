package jet.shareplot.ac.bo.portfolio.portfolioshare;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull; // NOPMD import may not be used in generated code
import static org.junit.Assert.assertNull; // NOPMD import may not be used in generated code
import static org.junit.Assert.assertTrue; // NOPMD import may not be used in generated code
import static jet.framework.util.JUnitAsserter.mock;

/**
 * JUnit tests for the PortfolioShare accessor methods, this is where the PortfolioShare business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class PortfolioShare_Accessors_JUnitTest {

    /**
     * getIdPortfolio with an new portfolioShare
     */
    @org.junit.Test
    public void testGetIdPortfolio() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final Long result = portfolioShare.getIdPortfolio();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIdPortfolio with an new portfolioShare
     */
    @org.junit.Test
    public void testSetIdPortfolio() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final Long expectedValue = null;
        portfolioShare.setIdPortfolio(expectedValue);
        final Long result = portfolioShare.getIdPortfolio();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations

        // pk field changed, object should be new
        assertTrue(portfolioShare.isNew());
    }

    /**
     * getIdShare with an new portfolioShare
     */
    @org.junit.Test
    public void testGetIdShare() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final Long result = portfolioShare.getIdShare();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIdShare with an new portfolioShare
     */
    @org.junit.Test
    public void testSetIdShare() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final Long expectedValue = null;
        portfolioShare.setIdShare(expectedValue);
        final Long result = portfolioShare.getIdShare();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations

        // pk field changed, object should be new
        assertTrue(portfolioShare.isNew());
    }

    /**
     * getChangeQuantity with an new portfolioShare
     */
    @org.junit.Test
    public void testGetChangeQuantity() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final java.math.BigDecimal result = portfolioShare.getChangeQuantity();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setChangeQuantity with an new portfolioShare
     */
    @org.junit.Test
    public void testSetChangeQuantity() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final java.math.BigDecimal expectedValue = null;
        portfolioShare.setChangeQuantity(expectedValue);
        final java.math.BigDecimal result = portfolioShare.getChangeQuantity();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getPortfolioName with an new portfolioShare
     */
    @org.junit.Test
    public void testGetPortfolioName() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final String result = portfolioShare.getPortfolioName();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setPortfolioName with an new portfolioShare
     */
    @org.junit.Test
    public void testSetPortfolioName() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        portfolioShare.setPortfolioName(expectedValue);
        final String result = portfolioShare.getPortfolioName();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getShareName with an new portfolioShare
     */
    @org.junit.Test
    public void testGetShareName() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final String result = portfolioShare.getShareName();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setShareName with an new portfolioShare
     */
    @org.junit.Test
    public void testSetShareName() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        portfolioShare.setShareName(expectedValue);
        final String result = portfolioShare.getShareName();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getValue with an new portfolioShare
     */
    @org.junit.Test
    public void testGetValue() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final java.math.BigDecimal result = portfolioShare.getValue();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setValue with an new portfolioShare
     */
    @org.junit.Test
    public void testSetValue() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final java.math.BigDecimal expectedValue = null;
        portfolioShare.setValue(expectedValue);
        final java.math.BigDecimal result = portfolioShare.getValue();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getValueDate with an new portfolioShare
     */
    @org.junit.Test
    public void testGetValueDate() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final java.util.Date result = portfolioShare.getValueDate();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setValueDate with an new portfolioShare
     */
    @org.junit.Test
    public void testSetValueDate() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        // TODO set proper expected value
        final java.util.Date expectedValue = null;
        portfolioShare.setValueDate(expectedValue);
        final java.util.Date result = portfolioShare.getValueDate();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

}
