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
        Vinilo vinilo = viniloDao.create("Test Album", "2023-10-01", "Rock", null, 19.99f, "VG", 10);
        assertNotNull(vinilo);
        assertEquals("Test Album", vinilo.getNombre());
        assertEquals("Rock", vinilo.getGenero());
        assertEquals(19.99f, vinilo.getPrecio(), 0.01);
        assertEquals("Nuevo", vinilo.getCondicion());
        assertEquals(Integer.valueOf(10), vinilo.getStock());

        Optional<Vinilo> retrievedVinilo = viniloDao.findById(vinilo.getId()).stream().findFirst();
        assertNotNull(retrievedVinilo.orElse(null));
        assertEquals(vinilo.getId(), retrievedVinilo.get().getId());
    }
}