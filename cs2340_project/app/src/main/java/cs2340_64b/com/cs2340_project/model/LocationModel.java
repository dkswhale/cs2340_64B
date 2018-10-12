package cs2340_64b.com.cs2340_project.model;

import java.util.ArrayList;
import java.util.List;

public class LocationModel {
    public static final LocationModel INSTANCE = new LocationModel();

    private List<Location> locations;

    private LocationModel() {
        locations = new ArrayList<>();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location findLocationByKey(int key) {
        for (Location l : locations) {
            if (l.getKey() == key) return l;
        }
        return null;
    }
}
