package jet.shareplot.ac.bo.portfolio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * JUnit tests for the Portfolio accessor methods, this is where the Portfolio business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class Portfolio_Accessors_JUnitTest {

    /**
     * getIdPortfolio with an new portfolio
     */
    @org.junit.Test
    public void testGetIdPortfolio() {
        // arrange : set up the test
        final AbstractPortfolioBOApplicationComponent portfolioAC = mock(AbstractPortfolioBOApplicationComponent.class);        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final Long result = portfolio.getIdPortfolio();

        // assert : verify that the test run correctly
        assertNull(result);
    }


    /**
     * getIsFake with an new portfolio
     */
    @org.junit.Test
    public void testGetIsFake() {
        // arrange : set up the test
        final AbstractPortfolioBOApplicationComponent portfolioAC = mock(AbstractPortfolioBOApplicationComponent.class);        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final String result = portfolio.getIsFake();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setIsFake with an new portfolio
     */
    @org.junit.Test
    public void testSetIsFake() {
        // arrange : set up the test
        final AbstractPortfolioBOApplicationComponent portfolioAC = mock(AbstractPortfolioBOApplicationComponent.class);        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        portfolio.setIsFake(expectedValue);
        final String result = portfolio.getIsFake();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

    /**
     * getName with an new portfolio
     */
    @org.junit.Test
    public void testGetName() {
        // arrange : set up the test
        final AbstractPortfolioBOApplicationComponent portfolioAC = mock(AbstractPortfolioBOApplicationComponent.class);        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final String result = portfolio.getName();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setName with an new portfolio
     */
    @org.junit.Test
    public void testSetName() {
        // arrange : set up the test
        final AbstractPortfolioBOApplicationComponent portfolioAC = mock(AbstractPortfolioBOApplicationComponent.class);        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        // TODO set proper expected value
        final String expectedValue = null;
        portfolio.setName(expectedValue);
        final String result = portfolio.getName();

        // assert : verify that the test run correctly
        assertEquals(expectedValue, result);
        // TODO add extra validations
    }

}
