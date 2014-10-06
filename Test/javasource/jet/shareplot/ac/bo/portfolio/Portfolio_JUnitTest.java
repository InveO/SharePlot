package jet.shareplot.ac.bo.portfolio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static jet.framework.util.JUnitAsserter.mock;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.util.models.interfaces.Model;

import org.junit.runner.RunWith;

import com.objectpartners.buesing.premock.PreMock;
import com.objectpartners.buesing.premock.PreMockJUnit4ClassRunner;

/**
 * JUnit skeleton for the Portfolio object
 * 
 * @author JetToolsFramework
 */
@PreMock({ Portfolio.class, PortfolioItem.class })
@RunWith(PreMockJUnit4ClassRunner.class)
public class Portfolio_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testPortfolio() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        // act : run the test
        final Portfolio portfolio = new Portfolio(portfolioAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolio);

        // values should be null
        // TODO adapt these conditions, default values may be set, making them not null
        assertNull(portfolio.getIdPortfolio());
        assertNotNull(portfolio.getIsFake());
        assertNull(portfolio.getName());

        assertTrue(portfolio.isNotNullableNull());

        // starts up as new
        assertTrue(portfolio.isNew());

        // data nodes should be non null
        assertNotNull(portfolio.get_IdPortfolio_Model());
        assertNotNull(portfolio.get_IsFake_Model());
        assertNotNull(portfolio.get_Name_Model());

        assertNotNull(portfolio.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testPortfolioModel() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final PortfolioItem item = new PortfolioItem();

        // act : run the test
        final Portfolio portfolio = new Portfolio(item.get_Model(), portfolioAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolio);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testPortfolioModelData() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final PortfolioItem item = new PortfolioItem();
        // TODO insert data in PortfolioItem
        item.setIsFake("isFake");
        item.setName("name");

        // act : run the test
        final Portfolio portfolio = new Portfolio(item.get_Model(), portfolioAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolio);
        // TODO check that data is in the portfolio
        assertEquals(portfolio.getIsFake(), "isFake");
        assertEquals(portfolio.getName(), "name");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testPortfolioPortfolio() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio item = new Portfolio(portfolioAC);

        // act : run the test
        final Portfolio portfolio = new Portfolio(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolio);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testPortfolioPortfolioData() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio item = new Portfolio(portfolioAC);
        // TODO insert data in Portfolio
        item.setIsFake("isFake");
        item.setName("name");

        // act : run the test
        final Portfolio portfolio = new Portfolio(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolio);
        // TODO check that data is in the portfolio
        assertEquals(portfolio.getIsFake(), "isFake");
        assertEquals(portfolio.getName(), "name");
    }

    /**
     * isNotNullableNull
     */
    @org.junit.Test
    public void testIsNotNullableNullTrue() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final boolean result = portfolio.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio portfolio = new Portfolio(portfolioAC);
        portfolio.setIsFake("isFake");
        portfolio.setName("name");

        // act : run the test
        final boolean result = portfolio.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio otherPortfolio = mock(Portfolio.class);
        // TODO init mock pk
        // eg : when(otherPortfolio.getIdPortfolio()).thenReturn(Long.valueOf(1));

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolio.isPkEquals(otherPortfolio);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio otherPortfolio = mock(Portfolio.class);
        // TODO init mock pk
        // eg : when(otherPortfolio.getIdPortfolio()).thenReturn(Long.valueOf(1));

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = portfolio.isPkEquals(otherPortfolio);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Portfolio otherPortfolio = mock(Portfolio.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final boolean result = portfolio.isPkEquals(otherPortfolio);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO init portfolio pk
        // eg : portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolio.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final JFErrorHandler result = portfolio.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        portfolio.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = portfolio.getJFErrorHandler();
        assertNotNull(result);
    }

    /**
     * isValid with valid object
     */
    @org.junit.Test
    public void testIsValidTrue() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up valid portfolio

        // act : run the test
        final boolean result = portfolio.isValid();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isValid with NON valid object
     */
    @org.junit.Test
    public void testIsValidFalse() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up NON valid portfolio

        // act : run the test
        final boolean result = portfolio.isValid();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isNew with a new portfolio
     */
    @org.junit.Test
    public void testIsNewTrue() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        final boolean result = portfolio.isNew();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNew with an old portfolio
     */
    @org.junit.Test
    public void testIsNewFalse() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;

        final Portfolio portfolio = new Portfolio(portfolioAC);
        portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolio.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }
}
