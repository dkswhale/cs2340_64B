package cs2340_64b.com.cs2340_project.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Handles location information inputs
 */

public class Location implements Parcelable {
    private final int key;
    private final String name;
    private final Double latitude;
    private final Double longitude;
    private final String address;
    private final Type type;
    private final String phone;

    /**
     * this is initializing all the variables
     * @param k - hey
     * @param n - name
     * @param la - latitude
     * @param lo - longitude
     * @param a - address
     * @param t - type
     * @param p - phone
     */
    public Location(int k, String n, Double la, Double lo, String a, Type t, String p) {
        key = k;
        name = n;
        latitude = la;
        longitude = lo;
        address = a;
        type = t;
        phone = p;
    }

    /**
     * this is a protected class taking in all the location variables
     * @param in - what is brought into the function
     */
    private Location(Parcel in) {
        key = in.readInt();
        name = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        address = in.readString();
        type = (Type) in.readSerializable();
        phone = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(key);
        dest.writeString(name);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(address);
        dest.writeSerializable(type);
        dest.writeString(phone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    /**
     * To string is converting the name to a string
     * @return name - name of location
     */
    @NonNull
    public String toString() {
        return name;
    }

    /**
     * this is getting the key of location
     * @return key - key of location
     */
    public int getKey() {
        return key;
    }

    /**
     * getting the name of location
     * @return name - this is getting the name
     */
    public String getName() {
        return name;
    }

    /**
     * this is getting the latitude of location
     * @return latitude - latitude of location
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * this is getting the longitude of location
     * @return - returns the longitude of the location
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * this is setting the address of the location
     * @return - this is getting the address of location
     */
    public String getAddress() {
        return address;
    }

    /**
     * this is getting the type of location
     * @return type - type of location
     */
    public Type getType() {
        return type;
    }

    /**
     * this is getting the phone of the location
     * @return location - location of the phone
     */
    public String getPhone() {
        return phone;
    }
}
