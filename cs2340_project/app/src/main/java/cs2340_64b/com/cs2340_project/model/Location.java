package cs2340_64b.com.cs2340_project.model;

public class Location {
    private int key;
    private String name;
    private long latitude;
    private long longitude;
    private String address;
    private String type;
    private String phone;

    public Location(int k, String n, long la, long lo, String a, String t, String p) {
        key = k;
        name = n;
        latitude = la;
        longitude = lo;
        address = a;
        type = t;
        phone = p;
    }

    public String toString() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }
}
