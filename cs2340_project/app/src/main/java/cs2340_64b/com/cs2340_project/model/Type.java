package cs2340_64b.com.cs2340_project.model;

/**
 * Enum storing type of donation
 */
public enum Type {

    DROP_OFF, STORE, WAREHOUSE;

// --Commented out by Inspection START (11/16/18, 4:01 AM):
//    /**
//     * toString of donation type
//     * @return String of donation type
//     */
//    public String getName() {
//        switch (this) {
//            case DROP_OFF:
//                return "Drop Off";
//            case STORE:
//                return "Store";
//            case WAREHOUSE:
//                return "Warehouse";
//            default:
//                return "else";
//        }
//    }
// --Commented out by Inspection STOP (11/16/18, 4:01 AM)

    /**
     * Defining Donation type
     * @param string string of location of donation
     * @return Type of donation
     */
    public static Type type(String string) {
        switch (string) {
            case "Drop Off":
                return DROP_OFF;
            case "Store":
                return STORE;
            case "Warehouse":
                return WAREHOUSE;
            default:
                return WAREHOUSE;
        }
    }

}
