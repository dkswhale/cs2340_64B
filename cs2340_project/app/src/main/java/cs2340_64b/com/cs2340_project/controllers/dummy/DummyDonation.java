package cs2340_64b.com.cs2340_project.controllers.dummy;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs2340_64b.com.cs2340_project.model.Donation;

public class DummyDonation {


    public static final List<DummyDon> ITEMS = new ArrayList<>();

    private static final Map<String, DummyDon> ITEM_MAP = new HashMap<>();

    public static void setup(ArrayList<Donation> donations) {
        clearOut();
        for (Donation donation: donations) {
            DummyDon dummy = new DummyDon(donation);
            addItem(dummy);
        }
    }

    private static void addItem(DummyDon item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static void clearOut() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    public static class DummyDon {
        public final String id;
        public final Donation donation;

        DummyDon(Donation donation) {
            this.id = String.valueOf(donation.getValue());
            this.donation = donation;
        }

        @NonNull
        @Override
        public String toString() {
            return donation.getShortDescription();
        }
    }
}
