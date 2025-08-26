package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.persistence.BuyerDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BuyerServiceImplTest {

    private static final long VALID_ID = 1;
    private static final long NON_EXISTENT_ID = 999;
    private static final long INVALID_ID = -1;
    private static final String TEST_NAME = "Test Buyer";

    private  static final String DNI = "12345678";

    private static final String EMAIL = "mail@test.com";

    @InjectMocks
    private BuyerServiceImpl buyerService;

    @Mock
    private BuyerDao buyerDaoMock;

    @Test
    public void testFindByIdSuccess() {
        // Precondiciones
        Mockito.when(buyerDaoMock.findById(Mockito.eq(VALID_ID)))
                .thenReturn(Optional.of(new Buyer(VALID_ID, TEST_NAME, DNI, EMAIL)));

        // Ejercitar
        Optional<Buyer> buyer = buyerService.findById(VALID_ID);

        // Postcondiciones
        assertNotNull(buyer);
        assertTrue(buyer.isPresent());
        assertEquals(VALID_ID, buyer.get().getId());
        assertEquals(TEST_NAME, buyer.get().getName());
        assertEquals(DNI, buyer.get().getDni());
        assertEquals(EMAIL, buyer.get().getEmail());
    }

    @Test
    public void testFindByIdNotFound() {
        // Precondiciones
        Mockito.when(buyerDaoMock.findById(Mockito.eq(NON_EXISTENT_ID)))
                .thenReturn(Optional.empty());

        // Ejercitar
        Optional<Buyer> buyer = buyerService.findById(NON_EXISTENT_ID);

        // Postcondiciones
        assertNotNull(buyer);
        assertTrue(buyer.isEmpty());
    }

    @Test
    public void testFindByIdInvalidId() {
        // Ejercitar
        Optional<Buyer> buyer = buyerService.findById(INVALID_ID);

        // Postcondiciones
        assertNotNull(buyer);
        assertTrue(buyer.isEmpty());
    }

    @Test
    public void testCreateSuccess() {
        // Precondiciones
        Buyer newBuyer = new Buyer(VALID_ID, TEST_NAME, DNI, EMAIL);
        Mockito.when(buyerDaoMock.create(Mockito.eq(TEST_NAME), Mockito.eq(EMAIL), Mockito.eq(DNI)))
                .thenReturn(newBuyer);

        // Ejercitar
        Buyer createdBuyer = buyerService.create(TEST_NAME, EMAIL, DNI);

        // Postcondiciones
        assertNotNull(createdBuyer);
        assertEquals(TEST_NAME, createdBuyer.getName());
        assertEquals(VALID_ID, createdBuyer.getId());
    }
}