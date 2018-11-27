package cs2340_64b.com.cs2340_project.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * handles location data
 */

public class LocationData {
    private static final ArrayList<Location> locations = new ArrayList<>();

    /**
     * this is getting all the location and adding them to stream
     * @param inputStream - stream of location
     */
    public LocationData(InputStream inputStream) {
        if (locations.isEmpty()) {
            ReadCSV read = new ReadCSV(inputStream);
            List locationData = read.file();
            for (Object locData : locationData) {
                String[] info = (String[]) locData;
                Type type = Type.type(info[8]);
                Location location = new Location(Integer.parseInt(info[0]), info[1],
                        Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        info[4], type, info[9]);
                locations.add(location);
            }
        }
    }

    /**
     * this is dealing with the array list of location
     * @return locations - this is locations of donation
     */
    public static ArrayList<Location> getLocations() {
        return locations;
    }
}
