package cs2340_64b.com.cs2340_project;

import org.junit.Before;
import org.junit.Test;

import cs2340_64b.com.cs2340_project.model.UserRights;

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
        assertEquals(userRights(rights), UserRights.USER);
    }

    @Before
    public void createLocationRights() {
        rights = "Location Employee";
    }
    @Test
    public void testLocationRights() {
        assertEquals(userRights(rights), UserRights.LOCATION_EMPLOYEE);
    }

    @Before
    public void createAdminRights() {
        rights = "Admin";
    }
    @Test
    public void testAdminRights() {
        assertEquals(userRights(rights), UserRights.ADMIN);
    }
}
