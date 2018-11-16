package cs2340_64b.com.cs2340_project;

import org.junit.Test;

import cs2340_64b.com.cs2340_project.model.User;
import cs2340_64b.com.cs2340_project.model.UserManager;
import cs2340_64b.com.cs2340_project.model.UserRights;

import static org.junit.Assert.*;

public class UserManagerTest {

    private User user1 = new User("Kate", "1234", "KateB", UserRights.USER);
    User user2 = new User("Tessa", "abcd", "TessaS", UserRights.ADMIN);
    User user3 = new User("Sranee", "12ab", "SraneeP", UserRights.USER);
    User user4 = new User("Gregg", "34cd", "GreggV", UserRights.USER);
    User user5 = new User("Doh", "5678", "DohY", UserRights.ADMIN);


    @Test
    public void testRegisterUser() {
        assertNull(UserManager.getCurrentUser());
        UserManager.registerUser("Kate", "1234", "KateB", UserRights.USER);
        assertEquals(user1, UserManager.getCurrentUser());
        UserManager.registerUser("Tessa", "abcd", "TessaS", UserRights.ADMIN);
        assertEquals(user2, UserManager.getCurrentUser());
        UserManager.registerUser("Sranee", "12ab", "SraneeP", UserRights.USER);
        assertEquals(user3, UserManager.getCurrentUser());
        assertTrue(UserManager.registerUser("Gregg", "34cd", "GreggV", UserRights.USER) == true);
        assertEquals(user4, UserManager.getCurrentUser());
        UserManager.registerUser("Doh", "5678", "DohY", UserRights.ADMIN);
        assertEquals(user5, UserManager.getCurrentUser());
    }
}