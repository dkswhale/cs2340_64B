package cs2340_64b.com.cs2340_project.model;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> _users;

    public UserManager() {
        _users = new HashMap<>();
    }

    public boolean addUser(String username, String password, String name, UserRights rights) {
        User user = new User(username, password, name, rights);
        if (_users.containsKey(username)) {
            return false;
        }
        _users.put(username, user);
        return true;
    }

    public User checkLogin(String username, String password) {
        User user = null;
        if (_users.containsKey(username)) {
            user = _users.get(username);
            if (user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}
