package cs2340_64b.com.cs2340_project.model;

public enum UserRights {
    USER,
    LOCATION_EMPLOYEE,
    ADMIN;

    public String toString() {
        switch (this) {
            case USER:
                return "User";
            case LOCATION_EMPLOYEE:
                return "Location Employee";
            case ADMIN:
                return "Admin";
            default:
                return "User";
        }
    }

    public static UserRights userRights(String string) {
        switch (string) {
            case "User":
                return USER;
            case "Location Emplyee":
                return LOCATION_EMPLOYEE;
            case "Admin":
                return ADMIN;
            default:
                return USER;
        }
    }


}
