package cs2340_64b.com.cs2340_project.controllers.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs2340_64b.com.cs2340_project.model.Location;


public class DummyContent {


    public static final List<DummyItem> ITEMS = new ArrayList<>();

    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();

    public static void setup(ArrayList<Location> locations) {
        clearOut();
        for (Location location: locations) {
            DummyItem dummy = new DummyItem(location);
            addItem(dummy);
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static void clearOut() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    public static class DummyItem {
        public final String id;
        public final Location location;

        public DummyItem(Location location) {
            this.id = String.valueOf(location.getKey());
            this.location = location;
        }

        @Override
        public String toString() {
            return location.getName();
        }
    }
}
