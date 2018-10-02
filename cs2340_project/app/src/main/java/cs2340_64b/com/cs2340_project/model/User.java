package cs2340_64b.com.cs2340_project.model;

public class User {
    private String _username;
    private String _password;
    private String _name;
    private UserRights _rights;

    public User(String uid, String pass, String name, UserRights rights) {
        _username = uid;
        _password = pass;
        _name = name;
        _rights = rights;
    }

    public boolean checkPassword(String pass) {
        return _password.equals(pass);
    }

    public String getName() {
        return _name;
    }
}
