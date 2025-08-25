package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Vinilo;
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

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ViniloDaoImplTest {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ViniloDao viniloDao;

    @Autowired
    private DataSource ds;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(ds);
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "vinilo");
    }

    @Test
    public void testCreateVinilo() {
        // 1. Precondiciones
        Vinilo vinilo = viniloDao.create("Test Album", "2023-10-01", "Rock", null, 19.99f, "Nuevo", 10);

        // 2. Ejercitar
        assertNotNull(vinilo);
        assertEquals("Test Album", vinilo.getNombre());
        assertEquals("Rock", vinilo.getGenero());
        assertEquals(19.99f, vinilo.getPrecio(), 0.01);
        assertEquals("Nuevo", vinilo.getCondicion());
        assertEquals(Integer.valueOf(10), vinilo.getStock());

        // 3. Postcondiciones
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "vinilo"));
    }

    @Test
    public void testFindById() {
        // 1. Precondiciones
        Vinilo vinilo = viniloDao.create("Test Album", "2023-10-01", "Rock", null, 19.99f, "VG", 10);

        // 2. Ejercitar
        Optional<Vinilo> retrievedVinilo = viniloDao.findById(vinilo.getId());

        // 3. Postcondiciones
        assertNotNull(retrievedVinilo.orElse(null));
        assertEquals(vinilo.getId(), retrievedVinilo.get().getId());
        assertEquals(vinilo.getNombre(), retrievedVinilo.get().getNombre());
        assertEquals(vinilo.getGenero(), retrievedVinilo.get().getGenero());
        assertEquals(vinilo.getPrecio(), retrievedVinilo.get().getPrecio(), 0.01);
        assertEquals(vinilo.getCondicion(), retrievedVinilo.get().getCondicion());
        assertEquals(vinilo.getStock(), retrievedVinilo.get().getStock());
    }
}