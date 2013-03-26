package jet.shareplot.ac.bo.share;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.util.models.interfaces.Model;

import org.junit.runner.RunWith;

import com.objectpartners.buesing.premock.PreMock;
import com.objectpartners.buesing.premock.PreMockJUnit4ClassRunner;

/**
 * JUnit skeleton for the Share object
 *
 * @author JetToolsFramework
 */
@PreMock({ Share.class, ShareItem.class })
@RunWith(PreMockJUnit4ClassRunner.class)
public class Share_JUnitTest {

    /**
     * Test constructor
     */
    @org.junit.Test
    public void testShare() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        // act : run the test
        final Share share = new Share(shareAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(share);

        // values should be null
        // TODO adapt these conditions, default values may be set, making them not null
        assertNull(share.getIdShare());
        assertNull(share.getCodeISIN());
        assertNull(share.getCodeYahoo());
        assertNull(share.getDescription());
        assertNull(share.getIdPortfolio());
        assertNull(share.getName());

        assertTrue(share.isNotNullableNull());

        // starts up as new
        assertTrue(share.isNew());

        // data nodes should be non null
        assertNotNull(share.get_IdShare_Model());
        assertNotNull(share.get_CodeISIN_Model());
        assertNotNull(share.get_CodeYahoo_Model());
        assertNotNull(share.get_Description_Model());
        assertNotNull(share.get_IdPortfolio_Model());
        assertNotNull(share.get_Name_Model());

        assertNotNull(share.get_Model());
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareModel() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final ShareItem item = new ShareItem();

        // act : run the test
        final Share share = new Share(item.get_Model(), shareAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(share);
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test
    public void testShareModelData() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final ShareItem item = new ShareItem();
        // TODO insert data in ShareItem
        item.setCodeISIN("");
        item.setCodeYahoo("");
        item.setDescription("");
        item.setIdPortfolio(Long.valueOf(1));
        item.setName("");

        // act : run the test
        final Share share = new Share(item.get_Model(), shareAC);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(share);
        // TODO check that data is in the share
        assertEquals(share.getCodeISIN(), "");
        assertEquals(share.getCodeYahoo(), "");
        assertEquals(share.getDescription(), "");
        assertEquals(share.getIdPortfolio(), Long.valueOf(1));
        assertEquals(share.getName(), "");
    }

    /**
     * Test model based constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testShareModelNull() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        // act : run the test
        new Share(null, shareAC);

        // assert : verify that the test run correctly
        // should have thrown an exception
        fail("Expected exception was not thrown.");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareShare() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share item = new Share(shareAC);

        // act : run the test
        final Share share = new Share(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(share);
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test
    public void testShareShareData() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share item = new Share(shareAC);
        // TODO insert data in Share
        item.setCodeISIN("");
        item.setCodeYahoo("");
        item.setDescription("");
        item.setIdPortfolio(Long.valueOf(1));
        item.setName("");

        // act : run the test
        final Share share = new Share(item);

        // assert : verify that the test run correctly
        // object should be instantiated
        assertNotNull(share);
        // TODO check that data is in the share
        assertEquals(share.getCodeISIN(), "");
        assertEquals(share.getCodeYahoo(), "");
        assertEquals(share.getDescription(), "");
        assertEquals(share.getIdPortfolio(), Long.valueOf(1));
        assertEquals(share.getName(), "");
    }

    /**
     * Test copy constructor
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testShareShareNull() {
        // arrange : set up the test
        final Share item = null;

        // act : run the test
        new Share(item);

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
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share share = new Share(shareAC);

        // act : run the test
        final boolean result = share.isNotNullableNull();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNotNullableNull with non null values
     */
    @org.junit.Test
    public void testIsNotNullableNullFalse() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share share = new Share(shareAC);
        share.setIdPortfolio(Long.valueOf(1));
        share.setName("");

        // act : run the test
        final boolean result = share.isNotNullableNull();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with equal values
     */
    @org.junit.Test
    public void testIsPkEqualsTrue() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share otherShare = mock(Share.class);
        // TODO init mock pk
        // eg : when(otherShare.getIdShare()).thenReturn(Long.valueOf(1));

        final Share share = new Share(shareAC);
        // TODO init share pk
        // eg : share.get_IdShare_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = share.isPkEquals(otherShare);

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isPkEquals with non equal values
     */
    @org.junit.Test
    public void testIsPkEqualsFalse() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share otherShare = mock(Share.class);
        // TODO init mock pk
        // eg : when(otherShare.getIdShare()).thenReturn(Long.valueOf(1));

        final Share share = new Share(shareAC);
        // TODO init share pk
        // eg : share.get_IdShare_Model().setNodeValue(Long.valueOf(2));

        // act : run the test
        final boolean result = share.isPkEquals(otherShare);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null pk values
     */
    @org.junit.Test
    public void testIsPkEqualsNullFalse() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final Share otherShare = mock(Share.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final boolean result = share.isPkEquals(otherShare);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isPkEquals with null other object
     */
    @org.junit.Test
    public void testIsPkEqualsFalseNull() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);
        // TODO init share pk
        // eg : share.get_IdShare_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = share.isPkEquals(null);

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * getJFErrorHandler
     */
    @org.junit.Test
    public void testGetJFErrorHandler() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final JFErrorHandler result = share.getJFErrorHandler();

        // assert : verify that the test run correctly
        assertNull(result);
    }

    /**
     * setJFErrorHandler
     */
    @org.junit.Test
    public void testSetJFErrorHandler() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);
        final JFErrorHandler errorHandler = mock(JFErrorHandler.class);

        final Share share = new Share(shareAC);

        // act : run the test
        share.setJFErrorHandler(errorHandler);

        // assert : verify that the test run correctly
        final JFErrorHandler result = share.getJFErrorHandler();
        assertNotNull(result);
    }

    /**
     * isValid with valid object
     */
    @org.junit.Test
    public void testIsValidTrue() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);
        // TODO set up valid share

        // act : run the test
        final boolean result = share.isValid();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isValid with NON valid object
     */
    @org.junit.Test
    public void testIsValidFalse() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);
        // TODO set up NON valid share

        // act : run the test
        final boolean result = share.isValid();

        // assert : verify that the test run correctly
        assertFalse(result);
    }

    /**
     * isNew with a new share
     */
    @org.junit.Test
    public void testIsNewTrue() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);

        // act : run the test
        final boolean result = share.isNew();

        // assert : verify that the test run correctly
        assertTrue(result);
    }

    /**
     * isNew with an old share
     */
    @org.junit.Test
    public void testIsNewFalse() {
        // arrange : set up the test
        final ShareBOApplicationComponent shareAC = mock(ShareBOApplicationComponent.class);

        final Share share = new Share(shareAC);
        share.get_IdShare_Model().setNodeValue(Long.valueOf(1));

        // act : run the test
        final boolean result = share.isNew();

        // assert : verify that the test run correctly
        assertFalse(result);
    }
}
