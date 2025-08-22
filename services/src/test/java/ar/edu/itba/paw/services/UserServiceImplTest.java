package ar.edu.itba.paw.services;


import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


//black box testing

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final long VALID_ID = 1;
    private static final long NON_EXISTENT_ID = 34534;
    private static final long INVALID_ID = -5;
    private static final String TEST_USERNAME = "test_user";

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserDao userDaoMock;

//    es lo mismo que usar @InjectMocks y @Mock
//    @Before
//    public void setUp() {
//        userDaoMock = Mockito.mock(UserDao.class);
//        userService = new UserServiceImpl(userDaoMock);
//    }

    @Test
    public void testFindByIdSuccess() {
        // 1. Precondiciones
        Mockito.when(userDaoMock.findById(Mockito.eq(VALID_ID)))
                .thenReturn(Optional.of(new User(VALID_ID, "test user")));

        // 2. Ejercitar
        Optional<User> user = userService.findById(1);

        // 3. Postcondiciones
        assertNotNull(user);
        assertTrue(user.isPresent());
        assertEquals(VALID_ID, user.get().getId());
    }

    @Test
    public void testFindByIdNotFound() {
        // 1. Precondiciones

        // 2. Ejercitar
        Optional<User> user = userService.findById(NON_EXISTENT_ID);

        // 3. Postcondiciones
        assertNotNull(user);
        assertTrue(user.isEmpty());
    }

    @Test
    public void testFindByIdIllegalId() {
        // 1. Precondiciones

        // 2. Ejercitar
        Optional<User> user = userService.findById(INVALID_ID);

        // 3. Postcondiciones
        assertNotNull(user);
        assertTrue(user.isEmpty());
    }

    @Test
    public void testCreateSuccess() {
        // 1. Precondiciones
        Mockito.when(userDaoMock.create(Mockito.eq(TEST_USERNAME)))
                .thenReturn(new User(VALID_ID, TEST_USERNAME));

        // 2. Ejercitar
        User createdUser = userService.create(TEST_USERNAME);

        // 3. Postcondiciones
        assertNotNull(createdUser);
        assertEquals(TEST_USERNAME, createdUser.getUsername());
    }
}