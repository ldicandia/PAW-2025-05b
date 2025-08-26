package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Song;
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
public class SongDaoImplTest {

    private static final String TITLE = "Test Song";
    private static final String ARTIST = "Test Artist";
    private static final int DURATION_SEC = 180;
    private static final int POSITION = 1;
    private static final long VINYL_ID = 1L;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SongDao songDao;

    @Autowired
    private DataSource ds;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(ds);
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "song");

        //TODO Set up vinyl entry if foreign keys are enforced
    }

    @Test
    public void testCreate() {
        // 1. Precondiciones

        // 2. Ejercitar
        Song song = songDao.create(TITLE, ARTIST, DURATION_SEC, POSITION, VINYL_ID);

        // 3. Postcondiciones
        assertNotNull(song);
        assertEquals(TITLE, song.getTitle());
        assertEquals(ARTIST, song.getArtist());
        assertEquals(DURATION_SEC, song.getDurationSec());
        assertEquals(POSITION, song.getPosition());
        assertEquals(VINYL_ID, song.getVinylId());
        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "song"));
    }

    @Test
    public void testFindById() {
        // 1. Precondiciones
        Song song = songDao.create(TITLE, ARTIST, DURATION_SEC, POSITION, VINYL_ID);

        // 2. Ejercitar
        Optional<Song> retrievedSong = songDao.findById(song.getId());

        // 3. Postcondiciones
        assertNotNull(retrievedSong.orElse(null));
        assertEquals(song.getId(), retrievedSong.get().getId());
        assertEquals(TITLE, retrievedSong.get().getTitle());
        assertEquals(ARTIST, retrievedSong.get().getArtist());
        assertEquals(DURATION_SEC, retrievedSong.get().getDurationSec());
        assertEquals(POSITION, retrievedSong.get().getPosition());
        assertEquals(VINYL_ID, retrievedSong.get().getVinylId());
    }

    @Test
    public void testFindByTitle() {
        // 1. Precondiciones
        Song song = songDao.create(TITLE, ARTIST, DURATION_SEC, POSITION, VINYL_ID);

        // 2. Ejercitar
        Optional<Song> retrievedSong = songDao.findByTitle(TITLE);

        // 3. Postcondiciones
        assertNotNull(retrievedSong.orElse(null));
        assertEquals(song.getId(), retrievedSong.get().getId());
        assertEquals(TITLE, retrievedSong.get().getTitle());
        assertEquals(ARTIST, retrievedSong.get().getArtist());
        assertEquals(DURATION_SEC, retrievedSong.get().getDurationSec());
        assertEquals(POSITION, retrievedSong.get().getPosition());
        assertEquals(VINYL_ID, retrievedSong.get().getVinylId());
    }
}