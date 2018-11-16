package cs2340_64b.com.cs2340_project;

import org.junit.Before;
import org.junit.Test;

import static cs2340_64b.com.cs2340_project.model.UserRights.userRights;
import static junit.framework.TestCase.assertEquals;

@SuppressWarnings("ALL")
public class UserRightsTest {

    private String rights;

    @Before
    public void createUserRights() {
        rights = "User";
    }
    @Test
    public void testUserRights() {
        assertEquals(userRights(rights), "User");
    }

    @Before
    public void createLocationRights() {
        rights = "Location Employee";
    }
    @Test
    public void testLocationRights() {
        assertEquals(userRights(rights), "Location Employee");
    }

    @Before
    public void createAdminRights() {
        rights = "Admin";
    }
    @Test
    public void testAdminRights() {
        assertEquals(userRights(rights), "Admin");
    }
}
