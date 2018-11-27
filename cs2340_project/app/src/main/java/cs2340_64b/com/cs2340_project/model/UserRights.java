package cs2340_64b.com.cs2340_project.model;

/**
 * Userights that will be used
 */
public enum UserRights {
    USER,
    LOCATION_EMPLOYEE,
    ADMIN;

    /**
     * toString of user type
     * @return string of user type
     */
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

    /**
     * Defining different user rights
     * @param string of type of user
     * @return userRights of the user
     */
    public static UserRights userRights(String string) {
        switch (string) {
            case "User":
                return USER;
            case "Location Employee":
                return LOCATION_EMPLOYEE;
            case "Admin":
                return ADMIN;
            default:
                return USER;
        }
    }


}
