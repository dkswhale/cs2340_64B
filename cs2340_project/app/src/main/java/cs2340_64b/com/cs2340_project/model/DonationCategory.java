package cs2340_64b.com.cs2340_project.model;

public enum DonationCategory {

    CLOTHING ("Clothing"),
    HAT ("Hat"),
    KITCHEN ("Kitchen"),
    ELECTRONICS ("Electronics"),
    HOUSEHOLD ("HouseHold"),
    OTHER ("Other");

    private String category;

    DonationCategory(String category) {
        this.category = category;
    }
}
