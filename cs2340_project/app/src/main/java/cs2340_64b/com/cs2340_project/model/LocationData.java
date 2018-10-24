package cs2340_64b.com.cs2340_project.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LocationData {
    private ArrayList<Location> locations = new ArrayList<>();

    public LocationData(InputStream inputStream) {
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

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
