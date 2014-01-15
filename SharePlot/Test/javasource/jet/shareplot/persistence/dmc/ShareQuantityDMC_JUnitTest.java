package jet.shareplot.persistence.dmc;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.shareplot.persistence.ejb.sharequantity.ShareQuantityRemote;
import jet.shareplot.persistence.pojo.ShareQuantityItem;
import jet.util.models.interfaces.Model;

/**
 * ShareQuantity DataModelConverter2 JUnit test class
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareQuantityDMC_JUnitTest {

    @org.junit.Test
    public void testReadDataModelFromObject() throws Exception {
        // arrange : set up the test
        final ShareQuantityDMC dmc = new ShareQuantityDMC();
        final ShareQuantityRemote shareQuantityRemote = mock(ShareQuantityRemote.class);

        // if AI, ensure mock provides non null value
        when(shareQuantityRemote.getIdShareQuantity()).thenReturn(Long.valueOf(1));

        // act : run the test
        final Model shareQuantityModel = dmc.readDataModelFromObject(shareQuantityRemote);
        final ShareQuantityItem shareQuantityItem = new ShareQuantityItem(shareQuantityModel);

        // assert : verify that the test run correctly
        assertFalse(shareQuantityItem.isNew());
        assertFalse(shareQuantityItem.isDirty());

        // test that all data read from remote
        verify(shareQuantityRemote, times(1)).getIdShareQuantity();
        verify(shareQuantityRemote, times(1)).getChangeFee();
        verify(shareQuantityRemote, times(1)).getChangeQuantity();
        verify(shareQuantityRemote, times(1)).getChangeType();
        verify(shareQuantityRemote, times(1)).getChangeValue();
        verify(shareQuantityRemote, times(1)).getDescription();
        verify(shareQuantityRemote, times(1)).getIdShare();
        verify(shareQuantityRemote, times(1)).getValueDate();
    }

    @org.junit.Test
    public void testWriteDataModelToObject() throws Exception {
        // arrange : set up the test
        final ShareQuantityDMC dmc = new ShareQuantityDMC();
        final ShareQuantityRemote shareQuantityRemote = mock(ShareQuantityRemote.class);
        final ShareQuantityItem shareQuantityItem = new ShareQuantityItem();

        // act : run the test
        dmc.writeDataModelToObject(shareQuantityItem.get_Model(), shareQuantityRemote);

        // assert : verify that the test run correctly
        // check data written to all non pk fields
        verify(shareQuantityRemote, times(1)).setChangeFee(any(java.math.BigDecimal.class));
        verify(shareQuantityRemote, times(1)).setChangeQuantity(any(java.math.BigDecimal.class));
        verify(shareQuantityRemote, times(1)).setChangeType(any(String.class));
        verify(shareQuantityRemote, times(1)).setChangeValue(any(java.math.BigDecimal.class));
        verify(shareQuantityRemote, times(1)).setDescription(any(String.class));
        verify(shareQuantityRemote, times(1)).setIdShare(any(Long.class));
        verify(shareQuantityRemote, times(1)).setValueDate(any(java.util.Date.class));
    }

}
