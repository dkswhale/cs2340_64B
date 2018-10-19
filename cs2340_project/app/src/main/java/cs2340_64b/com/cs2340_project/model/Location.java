package cs2340_64b.com.cs2340_project.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    private int key;
    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private Type type;
    private String phone;

    public Location(int k, String n, Double la, Double lo, String a, Type t, String p) {
        key = k;
        name = n;
        latitude = la;
        longitude = lo;
        address = a;
        type = t;
        phone = p;
    }

    protected Location(Parcel in) {
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

    public String toString() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public Type getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }
}
