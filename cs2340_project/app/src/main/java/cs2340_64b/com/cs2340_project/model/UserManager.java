package cs2340_64b.com.cs2340_project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static ArrayList<User> users = new ArrayList<>();

    private static User currentUser = null;

    public static boolean signIn(String username, String password) {
        for (User check : users) {
            boolean approve = check.getUsername().equals(username)
                    && check.getPassword().equals(password);
            if (approve) {
                currentUser = check;
                return true;
            }
        }
        return false;
    }

    public static boolean registerUser(String name, String usern, String pass, UserRights ur) {
        User newUser = new User(name, usern, pass, ur);
        boolean exist = false;
        for (User check : users) {
            if (check.getUsername().equals(usern)) {
                exist = true;
                return false;
            }
        }
        users.add(newUser);
        currentUser = newUser;
        return true;
    }

    public static void signOut() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

}