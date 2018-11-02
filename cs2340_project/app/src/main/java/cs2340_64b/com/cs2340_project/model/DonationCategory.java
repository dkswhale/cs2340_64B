package cs2340_64b.com.cs2340_project.model;

public enum DonationCategory {

    CLOTHING,
    HAT,
    KITCHEN,
    ELECTRONICS,
    HOUSEHOLD,
    OTHER;

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
