package cs2340_64b.com.cs2340_project.model;

import java.util.ArrayList;
import java.util.List;

public class LoginServiceFacade {

    private static LoginServiceFacade INSTANCE = new LoginServiceFacade();
    private User currentUser = null;

    public static LoginServiceFacade getInstance() {
        return INSTANCE;
    }

    private UserManager _userManager;
    private List<Location> locations;

    private LoginServiceFacade() {
        _userManager = new UserManager();
        locations = new ArrayList<>();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean doLogin(String username, String password) {
            //don't do anything if someone is already logged in
        if (hasLoggedInUser()) return false;
            //get the user from the model
        User user = _userManager.checkLogin(username, password);
            //check for success
        if (user != null) {
            currentUser = user;
            //Log.d("aaa", "Set current user to :" + user);
            return true;
        }
        return false;
    }

    public boolean addNewUser(String username, String password, String name, UserRights rights) {
        if (_userManager.addUser(username, password, name, rights)) {
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        currentUser = null;
    }

    public boolean hasLoggedInUser() {
        return currentUser != null;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location findLocationByKey(int key) {
        for (Location l : locations) {
            if (l.getKey() == key) return l;
        }
        return null;
    }

}
