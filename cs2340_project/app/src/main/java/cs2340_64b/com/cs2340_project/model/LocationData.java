package cs2340_64b.com.cs2340_project.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LocationData {
    private ArrayList<Location> locations = new ArrayList<>();

    public LocationData(InputStream inputStream) {
        System.out.println("e");
        ReadCSV read = new ReadCSV(inputStream);
        System.out.println("f");
        List locationData = read.file();
        System.out.println("g");
        for (Object locData : locationData) {
            String[] info = (String[]) locData;
            System.out.println("h");
            Type type = Type.type(info[8]);
            System.out.println("i");
            Location location = new Location(Integer.parseInt(info[0]), info[1],
                    Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                    info[4], type, info[9]);
            System.out.println("j");
            locations.add(location);
            System.out.println("k");
        }
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
