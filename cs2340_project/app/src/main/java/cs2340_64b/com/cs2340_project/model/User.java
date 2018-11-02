package cs2340_64b.com.cs2340_project.model;

public class User {
    private String username;
    private String password;
    private String name;
    private UserRights rights;

    public User(String uid, String pass, String name, UserRights rights) {
        username = uid;
        password = pass;
        this.name = name;
        this.rights = rights;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRights getRights() {
        return rights;
    }
}
