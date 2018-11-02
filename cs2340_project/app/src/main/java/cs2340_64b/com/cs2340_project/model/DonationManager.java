package cs2340_64b.com.cs2340_project.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DonationManager {
    private static ArrayList<Donation> donations = new ArrayList<>();
    private static Boolean isLoaded = false;
    private static SharedPreferences pref;
    private static InputStream inputStream;

    public static void initialize(SharedPreferences pref, InputStream inputStream) {
        DonationManager.pref = pref;
        DonationManager.inputStream = inputStream;
        load();
    }

    private static void load() {
        if (isLoaded) {
            return;
        }
        isLoaded = true;
        Gson gson = new Gson();
        String donationsJson = pref.getString("donations", "");
        if (!(donationsJson.equals("[]") || donationsJson.isEmpty())) {
            ArrayList<LinkedTreeMap> ltmList = gson.fromJson(donationsJson, ArrayList.class);
            for (LinkedTreeMap donationTM : ltmList) {
                Donation donation = new Donation((String) donationTM.get("location"),
                        new Date((String) donationTM.get("time")), (String) donationTM.get("shortDescription"),
                        (String) donationTM.get("fullDescription"), (Double) donationTM.get("value"),
                        DonationCategory.donationCategory((String) donationTM.get("category")));
                donations.add(donation);
            }
        }
    }

    public static void save() {
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String donationsJson = gson.toJson(donations);
        editor.putString("donations", donationsJson);
        editor.commit();
    }

    public static boolean doDonate(String shortDescription, String fullDescription,
                                   Double value, DonationCategory category) {
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
            save();
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
