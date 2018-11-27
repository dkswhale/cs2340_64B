package cs2340_64b.com.cs2340_project.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads CSV file that stores info
 */
class ReadCSV {
    private final InputStream inputStream;

    /**
     * Constructor for ReadCVS
     * @param inputStream stream of data
     */
    public ReadCSV(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Reads CVS file
     * @return locationList, which is list of donation locations
     */
    @SuppressWarnings("ThrowFromFinallyBlock")
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
                throw new RuntimeException("Cannot close input stream: " + io);
            }
        }
        return locationList;
    }
}
