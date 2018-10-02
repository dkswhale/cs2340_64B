package cs2340_64b.com.cs2340_project.model;

public class LoginServiceFacade {

    private static LoginServiceFacade INSTANCE = new LoginServiceFacade();
    private User currentUser = null;

    public static LoginServiceFacade getInstance() {
        return INSTANCE;
    }

    private UserManager _userManager;


    private LoginServiceFacade() {
        _userManager = new UserManager();
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

}
