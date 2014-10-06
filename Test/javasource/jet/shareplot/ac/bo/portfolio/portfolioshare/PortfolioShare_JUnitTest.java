package jet.shareplot.ac.bo.portfolio.portfolioshare;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static jet.framework.util.JUnitAsserter.mock;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.portfolio.PortfolioShareItem;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;

import org.junit.runner.RunWith;

import com.objectpartners.buesing.premock.PreMock;
import com.objectpartners.buesing.premock.PreMockJUnit4ClassRunner;

/**
 * JUnit skeleton for the PortfolioShare object
 *
 * @author JetToolsFramework
 */
@PreMock({ PortfolioShare.class, PortfolioShareItem.class })
@RunWith(PreMockJUnit4ClassRunner.class)
public class PortfolioShare_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testPortfolioShare() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        // act : run the test
        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolioShare);

        // values should be null
        // TODO adapt these conditions, default values may be set, making them not null
        assertNull(portfolioShare.getIdPortfolio());
        assertNull(portfolioShare.getIdShare());
        assertNull(portfolioShare.getChangeQuantity());
        assertNull(portfolioShare.getPortfolioName());
        assertNull(portfolioShare.getShareName());
        assertNull(portfolioShare.getValue());
        assertNull(portfolioShare.getValueDate());

        assertTrue(portfolioShare.isNotNullableNull());

        // data nodes should be non null
        assertNotNull(portfolioShare.get_IdPortfolio_Model());
        assertNotNull(portfolioShare.get_IdShare_Model());
        assertNotNull(portfolioShare.get_ChangeQuantity_Model());
        assertNotNull(portfolioShare.get_PortfolioName_Model());
        assertNotNull(portfolioShare.get_ShareName_Model());
        assertNotNull(portfolioShare.get_Value_Model());
        assertNotNull(portfolioShare.get_ValueDate_Model());

        assertNotNull(portfolioShare.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testPortfolioShareModel() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShareItem item = new PortfolioShareItem();

        // act : run the test
        final PortfolioShare portfolioShare = new PortfolioShare(item.get_Model(), portfolioShareAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolioShare);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testPortfolioShareModelData() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShareItem item = new PortfolioShareItem();
        // TODO insert data in PortfolioShareItem
        item.setIdPortfolio(Long.valueOf(1));
        item.setIdShare(Long.valueOf(1));
        item.setChangeQuantity(java.math.BigDecimal.valueOf(1));
        item.setPortfolioName("portfolioName");
        item.setShareName("shareName");
        item.setValue(java.math.BigDecimal.valueOf(1));
        item.setValueDate(new java.util.Date());

        // act : run the test
        final PortfolioShare portfolioShare = new PortfolioShare(item.get_Model(), portfolioShareAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolioShare);
        // TODO check that data is in the portfolioShare
        assertEquals(portfolioShare.getIdPortfolio(), Long.valueOf(1));
        assertEquals(portfolioShare.getIdShare(), Long.valueOf(1));
        assertEquals(portfolioShare.getChangeQuantity(), java.math.BigDecimal.valueOf(1));
        assertEquals(portfolioShare.getPortfolioName(), "portfolioName");
        assertEquals(portfolioShare.getShareName(), "shareName");
        assertEquals(portfolioShare.getValue(), java.math.BigDecimal.valueOf(1));
        assertNotNull(portfolioShare.getValueDate());
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testPortfolioSharePortfolioShare() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare item = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final PortfolioShare portfolioShare = new PortfolioShare(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolioShare);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testPortfolioSharePortfolioShareData() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare item = new PortfolioShare(portfolioShareAC);
        // TODO insert data in PortfolioShare
        item.setIdPortfolio(Long.valueOf(1));
        item.setIdShare(Long.valueOf(1));
        item.setChangeQuantity(java.math.BigDecimal.valueOf(1));
        item.setPortfolioName("portfolioName");
        item.setShareName("shareName");
        item.setValue(java.math.BigDecimal.valueOf(1));
        item.setValueDate(new java.util.Date());

        // act : run the test
        final PortfolioShare portfolioShare = new PortfolioShare(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(portfolioShare);
        // TODO check that data is in the portfolioShare
        assertEquals(portfolioShare.getIdPortfolio(), Long.valueOf(1));
        assertEquals(portfolioShare.getIdShare(), Long.valueOf(1));
        assertEquals(portfolioShare.getChangeQuantity(), java.math.BigDecimal.valueOf(1));
        assertEquals(portfolioShare.getPortfolioName(), "portfolioName");
        assertEquals(portfolioShare.getShareName(), "shareName");
        assertEquals(portfolioShare.getValue(), java.math.BigDecimal.valueOf(1));
        assertNotNull(portfolioShare.getValueDate());
    }

    /**
     * isNotNullableNull
     */
    @org.junit.Test
    public void testIsNotNullableNullTrue() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final boolean result = portfolioShare.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);
        portfolioShare.setIdPortfolio(Long.valueOf(1));
        portfolioShare.setIdShare(Long.valueOf(1));
        portfolioShare.setChangeQuantity(java.math.BigDecimal.valueOf(1));
        portfolioShare.setPortfolioName("portfolioName");
        portfolioShare.setShareName("shareName");
        portfolioShare.setValue(java.math.BigDecimal.valueOf(1));
        portfolioShare.setValueDate(new java.util.Date());

        // act : run the test
        final boolean result = portfolioShare.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare otherPortfolioShare = mock(PortfolioShare.class);
        // TODO init mock pk
        // eg : when(otherPortfolioShare.getIdPortfolioShare()).thenReturn(Long.valueOf(1));

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);
        // TODO init portfolioShare pk
        // eg : portfolioShare.get_IdPortfolioShare_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolioShare.isPkEquals(otherPortfolioShare);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare otherPortfolioShare = mock(PortfolioShare.class);
        // TODO init mock pk
        // eg : when(otherPortfolioShare.getIdPortfolioShare()).thenReturn(Long.valueOf(1));

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);
        // TODO init portfolioShare pk
        // eg : portfolioShare.get_IdPortfolioShare_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = portfolioShare.isPkEquals(otherPortfolioShare);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final PortfolioShare otherPortfolioShare = mock(PortfolioShare.class);

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final boolean result = portfolioShare.isPkEquals(otherPortfolioShare);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);
        // TODO init portfolioShare pk
        // eg : portfolioShare.get_IdPortfolioShare_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = portfolioShare.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        final JFErrorHandler result = portfolioShare.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final PortfolioShareBOApplicationComponent portfolioShareAC = mock(PortfolioShareBOApplicationComponent.class);
        assert portfolioShareAC != null;
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final PortfolioShare portfolioShare = new PortfolioShare(portfolioShareAC);

        // act : run the test
        portfolioShare.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = portfolioShare.getJFErrorHandler();
        assertNotNull(result);
    }

}
