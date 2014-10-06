package jet.shareplot.ac.bo.portfolio;

import static jet.framework.util.JUnitAsserter.any;
import static jet.framework.util.JUnitAsserter.mock;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jet.container.managers.session.interfaces.Session;
import jet.framework.component.resource.ResourceNotificationApplicationComponent;
import jet.framework.nuts.store.StoreNut;
import jet.framework.util.JUnitAsserter;
import jet.framework.util.exception.FormatedJetException;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * JUnit tests for the Portfolio accessor methods, this is where the Portfolio business
 * code will be tested.
 *
 * @author JetToolsFramework
 */
public class Portfolio_Persist_JUnitTest {

    /**
     * Save, creation
     *
     * @throws FormatedJetException should be thrown as saving invalid portfolio
     */
    @org.junit.Test(expected = FormatedJetException.class)
    public void testSaveCreateInvalid() throws FormatedJetException {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up invalid portfolio

        // act : run the test
        portfolio.save();

        // assert : verify that the test run correctly
        fail("Expected an exception");
    }

    /**
     * Save, creation
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveCreateValid() throws Exception {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        // TODO set up valid portfolio

        // simulate the AI PK generation
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(final InvocationOnMock invocation) {
                portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));
                return null;
            }
        }).when(storeNut).createDataModel(JUnitAsserter.nonNull(any(Model.class)));

        // act : run the test
        try {
            portfolio.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).createDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
        assertFalse(portfolio.isNew());
    }

    /**
     * Save, update
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testSaveUpdate() throws Exception {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));
        // TODO set up valid portfolio

        // act : run the test
        try {
            portfolio.save();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).updateDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
        assertFalse(portfolio.isNew());
    }

    /**
     * Delete new record
     */
    @org.junit.Test
    public void testDeleteNew() {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);

        // act : run the test
        try {
            portfolio.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, never()).removeDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC, never()).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
        assertTrue(portfolio.isNew());
    }

    /**
     * Delete old record
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testDeleteOld() throws Exception {
        // arrange : set up the test
        final PortfolioBOApplicationComponent portfolioAC = mock(PortfolioBOApplicationComponent.class);
        assert portfolioAC != null;
        final Session session = mock(Session.class);
        final ResourceNotificationApplicationComponent resourceAC = mock(ResourceNotificationApplicationComponent.class);
        final StoreNut storeNut = mock(StoreNut.class);

        setupTransaction();

        when(portfolioAC.getSession()).thenReturn(session);
        when(session.getProperty(any())).thenReturn(resourceAC);
        when(portfolioAC.getStoreNut(anyString())).thenReturn(storeNut);

        final Portfolio portfolio = new Portfolio(portfolioAC);
        portfolio.get_IdPortfolio_Model().setNodeValue(Long.valueOf(1));

        // simulate the AI PK clear
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(final InvocationOnMock invocation) {
                portfolio.get_IdPortfolio_Model().setNodeValue(null);
                return null;
            }
        }).when(storeNut).removeDataModel(JUnitAsserter.nonNull(any(Model.class)));

        // act : run the test
        try {
            portfolio.delete();
        } catch (final FormatedJetException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }

        // assert : verify that the test run correctly
        try {
            verify(storeNut, only()).removeDataModel(portfolio.get_Model());
        } catch (final JETException e) {
            e.printStackTrace();
            fail("Unexpected exception");
        }
        verify(resourceAC).notifyListeners(eq(PortfolioResource.RESOURCE_NAME), any(PortfolioResource.class));
        assertTrue(portfolio.isNew());
    }

    @SuppressWarnings("boxing")
    private void setupTransaction() throws Exception {
        final javax.naming.Context context = jet.framework.util.junit.InitialContext2_JUnitTest.initInitialContext();
        final jet.container.managers.jta.interfaces.JTAManagerContext jtaContext = mock(jet.container.managers.jta.interfaces.JTAManagerContext.class);
        final javax.transaction.TransactionManager transactionManager = mock(javax.transaction.TransactionManager.class);
        when(context.lookup(jet.framework.util.JetConstants.MANAGERS_CONTEXT + jet.container.managers.jta.interfaces.JTAManagerContext.NAME)).thenReturn(jtaContext);
        when(jtaContext.getTransactionManager()).thenReturn(transactionManager);
        when(transactionManager.getStatus()).thenReturn(javax.transaction.Status.STATUS_NO_TRANSACTION);
        transactionManager.begin();
        transactionManager.commit();
    }
}
