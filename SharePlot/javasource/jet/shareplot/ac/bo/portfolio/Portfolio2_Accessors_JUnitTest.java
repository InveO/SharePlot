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
public class Portfolio2_Accessors_JUnitTest {

    /**
     * getIsFake with an new portfolio
     */
    @org.junit.Test
    public void testGetIsFake() {
        // arrange : set up the test
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

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
        final PortfolioApplicationComponent portfolioAC = mock(PortfolioApplicationComponent.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        portfolio.setIsFake("");
        final String result = portfolio.getIsFake();

        // assert : verify that the test run correctly
        assertEquals("", result);
    }

}
