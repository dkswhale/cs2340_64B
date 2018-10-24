package cs2340_64b.com.cs2340_project.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private InputStream inputStream;

    public ReadCSV(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List file() {
        List locationList = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] location = line.split(",");
                locationList.add(location);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the CSV file: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException io) {
                throw new RuntimeException("Connot close input stream: " + io);
            }
        }
        return locationList;
    }
}
