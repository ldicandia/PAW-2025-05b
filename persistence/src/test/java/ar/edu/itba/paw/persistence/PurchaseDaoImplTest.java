package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.models.Purchase;
import ar.edu.itba.paw.persistence.config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class PurchaseDaoImplTest {

    private static final long BUYER_ID = 1L;
    private static final long VINYL_ID = 1L;
    private static final String STATUS = "created";
    private static final int PRICE = 100;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PurchaseDao purchaseDao;

    @Autowired
    private DataSource ds;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(ds);
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "purchase");
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "buyer");
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "vinyl");

        //TODO Set up buyer and vinyl entries if foreign keys are enforced
    }

    @Test
    public void testCreate() {
        // 1. Precondiciones

        // 2. Ejercitar
        Purchase purchase = purchaseDao.create(BUYER_ID, VINYL_ID, STATUS, PRICE);

        // 3. Postcondiciones
        assertNotNull(purchase);
        assertEquals(BUYER_ID, purchase.getBuyerId());
        assertEquals(VINYL_ID, purchase.getVinylId());
        assertEquals(STATUS, purchase.getStatus());
        assertEquals(PRICE, purchase.getPrice());
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "purchase"));
    }

    @Test
    public void testFindById() {
        // 1. Precondiciones
        Purchase purchase = purchaseDao.create(BUYER_ID, VINYL_ID, STATUS, PRICE);

        // 2. Ejercitar
        Optional<Purchase> retrievedPurchase = purchaseDao.findById(purchase.getId());

        // 3. Postcondiciones
        assertNotNull(retrievedPurchase.orElse(null));
        assertEquals(purchase.getId(), retrievedPurchase.get().getId());
        assertEquals(BUYER_ID, retrievedPurchase.get().getBuyerId());
        assertEquals(VINYL_ID, retrievedPurchase.get().getVinylId());
        assertEquals(STATUS, retrievedPurchase.get().getStatus());
        assertEquals(PRICE, retrievedPurchase.get().getPrice());
    }
}