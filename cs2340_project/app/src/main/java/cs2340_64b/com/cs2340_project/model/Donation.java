package cs2340_64b.com.cs2340_project.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Donation implements Parcelable {
    private String location;
    private Date time;
    private String shortDescription;
    private String fullDescription;
    private Double value;
    private DonationCategory category;

    public Donation(String location) {
        this.location = location;
        time = null;
        shortDescription = null;
        fullDescription = null;
        value = null;
        category = null;
    }

    public Donation(String location, Date time, String shortDescription,
                    String fullDescription, Double value, DonationCategory category) {
        this.location = location;
        this.time = time;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    protected Donation(Parcel in) {
        location = in.readString();
        time = (Date) in.readSerializable();
        shortDescription = in.readString();
        fullDescription = in.readString();
        value = in.readDouble();
        category = (DonationCategory) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeSerializable(time);
        dest.writeString(shortDescription);
        dest.writeString(fullDescription);
        dest.writeDouble(value);
        dest.writeSerializable(category);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel source) {
            return new Donation(source);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    public Date getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public Double getValue() {
        return value;
    }

    public DonationCategory getCategory() {
        return category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setCategory(DonationCategory category) {
        this.category = category;
    }
}
