package cs2340_64b.com.cs2340_project.model;

public enum UserRights {
    USER ("User"),
    LOCATION_EMPLOYEE ("Location Employee"),
    ADMIN ("Admin");

    private String _type;

    UserRights(String type) {
        _type = type;
    }


}
