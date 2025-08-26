package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Vinyl;
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
public class VinylDaoImplTest {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private VinylDao vinylDao;

    @Autowired
    private DataSource ds;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(ds);
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "vinyl");
    }

    @Test
    public void testCreateVinilo() {
        // 1. Precondiciones
        java.sql.Date releaseDate = new java.sql.Date(new Date().getTime());
        java.sql.Date addedDate = new java.sql.Date(new Date().getTime());

        Vinyl vinyl = vinylDao.create("Test Album", releaseDate, "Rock", 19.99f, "MINT", "active", 10, addedDate);

        // 2. Ejercitar
        assertNotNull(vinyl);
        assertEquals("Test Album", vinyl.getTitle());
        assertEquals("Rock", vinyl.getGenre());
        assertEquals(19.99f, vinyl.getPrice(), 0.01);
        assertEquals("MINT", vinyl.getCondition());
        assertEquals(Integer.valueOf(10), vinyl.getStock());

        // 3. Postcondiciones
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "vinyl"));
    }

    @Test
    public void testFindById() {
        // 1. Precondiciones
        java.sql.Date releaseDate = new java.sql.Date(new Date().getTime());
        java.sql.Date addedDate = new java.sql.Date(new Date().getTime());

        Vinyl vinyl = vinylDao.create("Test Album", releaseDate, "Rock", 19.99f, "MINT", "active", 10, addedDate);

        // 2. Ejercitar
        Optional<Vinyl> retrievedVinyl = vinylDao.findById(vinyl.getId());

        // 3. Postcondiciones
        assertNotNull(retrievedVinyl.orElse(null));
        assertEquals(vinyl.getId(), retrievedVinyl.get().getId());
        assertEquals(vinyl.getTitle(), retrievedVinyl.get().getTitle());
        assertEquals(vinyl.getGenre(), retrievedVinyl.get().getGenre());
        assertEquals(vinyl.getPrice(), retrievedVinyl.get().getPrice(), 0.01);
        assertEquals(vinyl.getCondition(), retrievedVinyl.get().getCondition());
        assertEquals(vinyl.getStock(), retrievedVinyl.get().getStock());
    }
}
