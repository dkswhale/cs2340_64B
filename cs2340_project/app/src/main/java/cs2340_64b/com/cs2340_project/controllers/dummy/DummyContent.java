package cs2340_64b.com.cs2340_project.controllers.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs2340_64b.com.cs2340_project.model.Location;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static ArrayList<Location> locations = new ArrayList<Location>();

    public static void setup(ArrayList<Location> charities) {
        for (Location location: locations) {
            DummyItem d = new DummyItem(location);
            addItem(d);
        }
    }

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();


    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(locations.get(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
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
