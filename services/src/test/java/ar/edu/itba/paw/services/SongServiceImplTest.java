package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.persistence.SongDao;
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
public class SongServiceImplTest {

    private static final long VALID_ID = 1;
    private static final long NON_EXISTENT_ID = 999;
    private static final long INVALID_ID = -1;
    private static final String TITLE = "Test Song";
    private static final String ARTIST = "Test Artist";
    private static final int DURATION = 300;
    private static final int POSITION = 1;
    private static final long VINIL_ID = 10;


    @InjectMocks
    private SongServiceImpl songService;

    @Mock
    private SongDao songDaoMock;

    @Test
    public void testFindByIdSuccess() {
        // Arrange
        Mockito.when(songDaoMock.findById(Mockito.eq(VALID_ID)))
                .thenReturn(Optional.of(new Song(VALID_ID, TITLE, ARTIST, DURATION, POSITION, VINIL_ID)));

        // Act
        Optional<Song> song = songService.findById(VALID_ID);

        // Assert
        assertNotNull(song);
        assertTrue(song.isPresent());
        assertEquals(VALID_ID, song.get().getId());
        assertEquals(TITLE, song.get().getTitle());
        assertEquals(ARTIST, song.get().getArtist());
    }

    @Test
    public void testFindByIdNotFound() {
        // Arrange
        Mockito.when(songDaoMock.findById(Mockito.eq(NON_EXISTENT_ID)))
                .thenReturn(Optional.empty());

        // Act
        Optional<Song> song = songService.findById(NON_EXISTENT_ID);

        // Assert
        assertNotNull(song);
        assertTrue(song.isEmpty());
    }

    @Test
    public void testFindByIdInvalidId() {
        // Act
        Optional<Song> song = songService.findById(INVALID_ID);

        // Assert
        assertNotNull(song);
        assertTrue(song.isEmpty());
    }

    @Test
    public void testCreateSuccess() {
        // Arrange
        Song newSong = new Song(VALID_ID, TITLE, ARTIST, DURATION, POSITION, VINIL_ID);
        Mockito.when(songDaoMock.create(Mockito.eq(TITLE), Mockito.eq(ARTIST), Mockito.eq(DURATION), Mockito.eq(POSITION), Mockito.eq(VINIL_ID)))
                .thenReturn(newSong);

        // Act
        Song createdSong = songService.create(TITLE, ARTIST, DURATION, POSITION, VINIL_ID);

        // Assert
        assertNotNull(createdSong);
        assertEquals(VALID_ID, createdSong.getId());
        assertEquals(TITLE, createdSong.getTitle());
        assertEquals(ARTIST, createdSong.getArtist());
    }
}