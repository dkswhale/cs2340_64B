package cs2340_64b.com.cs2340_project.model;

public class Location {
    private int key;
    private String name;
    private long latitude;
    private long longitude;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String type;
    private String phone;
    private String website;

    public Location(int k, String n, long la, long lo, String a, String c,
                    String s, int z, String t, String p, String w) {
        key = k;
        name = n;
        latitude = la;
        longitude = lo;
        address = a;
        city = c;
        state = s;
        zip = z;
        type = t;
        phone = p;
        website = w;
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

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
