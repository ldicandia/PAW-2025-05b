package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.models.Vinyl;
import ar.edu.itba.paw.persistence.config.TestConfig;
import junit.framework.TestCase;
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
public class BuyerDaoImplTest{
    private static final String BUYER = "test_buyer";
    private  static  final String EMAIL = "email@test.com";
    private static final String DNI = "12345678";
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BuyerDao buyerDao;
    @Autowired
    private DataSource ds;
    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(ds);
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "buyer");
    }
    @Test
    public void testCreate() {
        // 1. Precondiciones

        // 2. Ejercitar
        Buyer buyer = buyerDao.create(BUYER, EMAIL, DNI);

        // 3. Postcondiciones
        assertNotNull(buyer);
        assertNotNull(BUYER, buyer.getName());
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "buyer"));
    }
    @Test
    public void testFindById() {
        // 1. Precondiciones
        java.sql.Date releaseDate = new java.sql.Date(new Date().getTime());
        java.sql.Date addedDate = new java.sql.Date(new Date().getTime());

        Buyer buyer = buyerDao.create(BUYER, EMAIL, DNI);

        // 2. Ejercitar
        Optional<Buyer> retrievedBuyer = buyerDao.findById(buyer.getId());

        // 3. Postcondiciones
        assertNotNull(retrievedBuyer.orElse(null));
        assertEquals(BUYER, retrievedBuyer.get().getName());
        assertEquals(EMAIL, retrievedBuyer.get().getEmail());
        assertEquals(DNI, retrievedBuyer.get().getDni());

    }
    @Test
    public void testFindByEmail() {
        // 1. Precondiciones
        Buyer buyer = buyerDao.create(BUYER, EMAIL, DNI);

        // 2. Ejercitar
        Optional<Buyer> retrievedBuyer = buyerDao.findByEmail(EMAIL);

        // 3. Postcondiciones
        assertNotNull(retrievedBuyer.orElse(null));
        assertEquals(BUYER, retrievedBuyer.get().getName());
        assertEquals(EMAIL, retrievedBuyer.get().getEmail());
        assertEquals(DNI, retrievedBuyer.get().getDni());
    }
    @Test
    public void testFindByDni() {
        // 1. Precondiciones
        Buyer buyer = buyerDao.create(BUYER, EMAIL, DNI);

        // 2. Ejercitar
        Optional<Buyer> retrievedBuyer = buyerDao.findByDni(DNI);

        // 3. Postcondiciones
        assertNotNull(retrievedBuyer.orElse(null));
        assertEquals(BUYER, retrievedBuyer.get().getName());
        assertEquals(EMAIL, retrievedBuyer.get().getEmail());
        assertEquals(DNI, retrievedBuyer.get().getDni());
    }
}