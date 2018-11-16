package cs2340_64b.com.cs2340_project.model;

/**
 * Handles User information
 */
public class User {
    private final String username;
    private final String password;
    private final String name;
    private UserRights rights;

    /**
     * constructor for User
     * @param uid user's id
     * @param pass user's password
     * @param name user's name
     * @param rights user's rights
     */
    public User(String uid, String pass, String name, UserRights rights) {
        username = uid;
        password = pass;
        this.name = name;
        this.rights = rights;
    }

// --Commented out by Inspection START (11/16/18, 4:01 AM):
//    /**
//     * Gets user's name
//     * @return name of user
//     */
//    public String getName() {
//        return name;
//    }
// --Commented out by Inspection STOP (11/16/18, 4:01 AM)

    /**
     * Gets user's username
     * @return username of user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets user's password
     * @return password of user
     */
    public String getPassword() {
        return password;
    }

// --Commented out by Inspection START (11/16/18, 12:57 PM):
//    /**
//     * Gets user's rights. ie admin, employee, user ext.
//     * @return rights of user
//     */
//    public UserRights getRights() {
//        return rights;
//    }
// --Commented out by Inspection STOP (11/16/18, 12:57 PM)
}
