package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Purchase;
import ar.edu.itba.paw.persistence.PurchaseDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseServiceImplTest {

    private static final long VALID_ID = 1;
    private static final long NON_EXISTENT_ID = 999;
    private static final long INVALID_ID = -1;
    private static final long BUYER_ID = 10;
    private static final String STATUS = "PENDING";
    private static final Date PAID_AT = new Date();
    private static final Date PAYMENT_RECEIVED_AT = new Date();
    private static final Date SENT_AT = new Date();
    private static final Date DELIVERED_AT = new Date();
    private static final long VINYL_ID = 5;
    private static final float PRICE = 29.99f;
    private static final Date CREATED_AT = new Date();


    @InjectMocks
    private PurchaseServiceImpl purchaseService;

    @Mock
    private PurchaseDao purchaseDaoMock;

    @Test
    public void testFindByIdSuccess() {
        // Arrange
        Purchase purchase = new Purchase(VALID_ID, BUYER_ID, VINYL_ID, STATUS, PRICE, CREATED_AT,
        PAID_AT, PAYMENT_RECEIVED_AT, SENT_AT, DELIVERED_AT);
        Mockito.when(purchaseDaoMock.findById(Mockito.eq(VALID_ID)))
                .thenReturn(Optional.of(purchase));

        // Act
        Optional<Purchase> result = purchaseService.findById(VALID_ID);

        // Assert
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(VALID_ID, result.get().getId());
        assertEquals(BUYER_ID, result.get().getBuyerId());
    }

    @Test
    public void testFindByIdNotFound() {
        // Arrange
        Mockito.when(purchaseDaoMock.findById(Mockito.eq(NON_EXISTENT_ID)))
                .thenReturn(Optional.empty());

        // Act
        Optional<Purchase> result = purchaseService.findById(NON_EXISTENT_ID);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByIdInvalidId() {
        // Act
        Optional<Purchase> result = purchaseService.findById(INVALID_ID);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreatePurchaseSuccess() {
        // Arrange
        Purchase newPurchase = new Purchase(VALID_ID, BUYER_ID, VINYL_ID, STATUS, PRICE, CREATED_AT,
                PAID_AT, PAYMENT_RECEIVED_AT, SENT_AT, DELIVERED_AT);
        Mockito.when(purchaseDaoMock.create(Mockito.eq(BUYER_ID), Mockito.eq(VINYL_ID), Mockito.eq(STATUS), Mockito.eq(PRICE)))
                .thenReturn(newPurchase);

        // Act
        Purchase createdPurchase = purchaseService.create(BUYER_ID, VINYL_ID, STATUS, PRICE);

        // Assert
        assertNotNull(createdPurchase);
        assertEquals(VALID_ID, createdPurchase.getId());
        assertEquals(BUYER_ID, createdPurchase.getBuyerId());
    }
}