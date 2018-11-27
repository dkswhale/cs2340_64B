package cs2340_64b.com.cs2340_project.model;

/**
 * this is an enum of all the donation categories
 */
public enum DonationCategory {

    CLOTHING,
    HAT,
    KITCHEN,
    ELECTRONICS,
    HOUSEHOLD,
    OTHER;

    /**
     * This is returning a string of the corresponding case
     * @return - returning type/category of donation
     */
    public String toString() {
        switch (this) {
            case CLOTHING:
                return "Clothing";
            case HAT:
                return "Hat";
            case KITCHEN:
                return "Kitchen";
            case ELECTRONICS:
                return "Electronics";
            case HOUSEHOLD:
                return "HouseHold";
            case OTHER:
                return "Other";
            default:
                return "Other";
        }
    }

    /**
     * This is taking that donation category
     * @param string - the string that is passed in
     * @return the type/category of donation
     */
    public static DonationCategory donationCategory(String string) {
        switch (string) {
            case "Clothing":
                return CLOTHING;
            case "Hat":
                return HAT;
            case "Kitchen":
                return KITCHEN;
            case "Electronics":
                return ELECTRONICS;
            case "HouseHold":
                return HOUSEHOLD;
            case "Other":
                return OTHER;
            default:
                return OTHER;
        }
    }
}
