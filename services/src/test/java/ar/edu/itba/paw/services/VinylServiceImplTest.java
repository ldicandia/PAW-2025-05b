package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Vinyl;
import ar.edu.itba.paw.persistence.VinylDao;
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
public class VinylServiceImplTest {

    private static final long VALID_ID = 1;
    private static final long NON_EXISTENT_ID = 999;
    private static final long INVALID_ID = -1;
    private static final String TITLE = "Test Vinyl";
    private static final Date RELEASE_DATE = new Date();
    private static final String GENRE = "Rock";
    private static final Float PRICE = 29.99f;
    private static final String CONDITION = "MINT";
    private static final String PUBLICATION_STATUS = "active";
    private static final Integer STOCK = 100;
    private static final Date CREATED_ON = new Date();

    @InjectMocks
    private VinylServiceImpl vinylService;

    @Mock
    private VinylDao vinylDaoMock;

    @Test
    public void testFindByIdSuccess() {
        // Arrange
        Mockito.when(vinylDaoMock.findById(Mockito.eq(VALID_ID)))
                .thenReturn(Optional.of(new Vinyl(VALID_ID, TITLE, RELEASE_DATE, GENRE, PRICE, CONDITION, PUBLICATION_STATUS, STOCK, CREATED_ON)));

        // Act
        Optional<Vinyl> vinyl = vinylService.findById(VALID_ID);

        // Assert
        assertNotNull(vinyl);
        assertTrue(vinyl.isPresent());
        assertEquals(VALID_ID, vinyl.get().getId());
        assertEquals(TITLE, vinyl.get().getTitle());
    }

    @Test
    public void testFindByIdNotFound() {
        // Arrange
        Mockito.when(vinylDaoMock.findById(Mockito.eq(NON_EXISTENT_ID)))
                .thenReturn(Optional.empty());

        // Act
        Optional<Vinyl> vinyl = vinylService.findById(NON_EXISTENT_ID);

        // Assert
        assertNotNull(vinyl);
        assertTrue(vinyl.isEmpty());
    }

    @Test
    public void testFindByIdInvalidId() {
        // Act
        Optional<Vinyl> vinyl = vinylService.findById(INVALID_ID);

        // Assert
        assertNotNull(vinyl);
        assertTrue(vinyl.isEmpty());
    }

    @Test
    public void testCreateSuccess() {
        // Arrange
        Vinyl newVinyl = new Vinyl(VALID_ID, TITLE, RELEASE_DATE, GENRE, PRICE, CONDITION, PUBLICATION_STATUS, STOCK, CREATED_ON);
        Mockito.when(vinylDaoMock.create(Mockito.eq(TITLE), Mockito.eq(RELEASE_DATE), Mockito.eq(GENRE),
                        Mockito.eq(PRICE), Mockito.eq(CONDITION), Mockito.eq(PUBLICATION_STATUS), Mockito.eq(STOCK), Mockito.eq(CREATED_ON)))
                .thenReturn(newVinyl);

        // Act
        Vinyl createdVinyl = vinylService.create(TITLE, RELEASE_DATE, GENRE, PRICE, CONDITION, PUBLICATION_STATUS, STOCK, CREATED_ON);

        // Assert
        assertNotNull(createdVinyl);
        assertEquals(VALID_ID, createdVinyl.getId());
        assertEquals(TITLE, createdVinyl.getTitle());
    }
}