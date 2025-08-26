package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.config.TestConfig;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;

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
    public void testCreate() {
        // 1. Precondiciones

        // 2. Ejercitar
        Buyer buyer = buyerDao.create(BUYER, EMAIL, DNI);
        // 3. Postcondiciones
        assertNotNull(buyer);
        assertNotNull(BUYER, buyer.getName());
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "buyer"));
    }
    public void testFindById() {
    }
    public void testFindByEmail() {
    }
    public void testFindByDni() {
    }
}