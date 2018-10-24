package cs2340_64b.com.cs2340_project.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DonationManager {
    private static ArrayList<Donation> donations = new ArrayList<>();

    public static boolean doDonate(String shortDescription, String fullDescription,
                                   int value, DonationCategory category) {
        Date currentTime = Calendar.getInstance().getTime();
        Donation donation = donations.get(donations.size() - 1);
        donation.setTime(currentTime);
        donation.setShortDescription(shortDescription);
        donation.setFullDescription(fullDescription);
        donation.setValue(value);
        donation.setCategory(category);
        if (value >= 0) {
            donations.remove(donations.size() - 1);
            donations.add(donation);
            return true;
        } else {
            return false;
        }
    }

    public static boolean addLocation(String location) {
        donations.add(new Donation(location));
        return true;
    }

    public static void cancelDonation() {
        donations.remove(donations.size() - 1);
    }

    public static ArrayList<Donation> getDonations() {
        return donations;
    }
}
