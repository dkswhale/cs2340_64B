package cs2340_64b.com.cs2340_project.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

/**
 * UserManager Class
 */
public class UserManager {
    private static final ArrayList<User> users = new ArrayList<>();
    private static User currentUser = null;
    private static Boolean isLoaded = false;
    private static SharedPreferences pref;

    /**
     * Initializes preferences
     * @param pref the input SharedPreferences to initialize
     */
    public static void initialize(SharedPreferences pref) {
        UserManager.pref = pref;
        load();
    }

    /**
     * load user information username and password
     */
    private static void load() {
        if (isLoaded) {
            return;
        }
        isLoaded = true;
        Gson gson = new Gson();
        String usersJson = pref.getString("users", "");
        if (!(usersJson.equals("[]") || usersJson.isEmpty())) {
            ArrayList<LinkedTreeMap> ltmList = gson.fromJson(usersJson, ArrayList.class);
            for (LinkedTreeMap userTM : ltmList) {
                User user = new User((String) userTM.get("username"), (String) userTM.get("password"),
                        (String) userTM.get("name"), UserRights.userRights((String) userTM.get("rights")));
                users.add(user);
            }
        }
    }

    /**
     * saves the user information
     */
    private static void save() {
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String usersJson = gson.toJson(users);
        editor.putString("users", usersJson);
        editor.apply();
    }

    /**
     *
     * @param username username of the user
     * @param password password of the user
     * @return true if signed in, false if not
     */
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

    /**
     *
     * @param name name of user
     * @param usern username of user
     * @param pass password of user
     * @param ur type of userRight
     * @return returns true if user is registered, false if not
     */
    public static boolean registerUser(String name, String usern, String pass, UserRights ur) {
        User newUser = new User(name, usern, pass, ur);
        for (User check : users) {
            if (check.getUsername().equals(usern)) {
                return false;
            }
        }
        users.add(newUser);
        currentUser = newUser;
        save();
        return true;
    }

    /**
     * handles signout, if user is signed out then current user is null
     */
    public static void signOut() {
        currentUser = null;
    }

    /**
     * Gets current user info
     * @return currentUser info
     */
    public static User getCurrentUser() {
        return currentUser;
    }

}