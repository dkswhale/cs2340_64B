package cs2340_64b.com.cs2340_project.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * handles new donation info
 */

public class Donation implements Parcelable {
    private final String location;
    private Date time;
    private String shortDescription;
    private String fullDescription;
    private Double value;
    private DonationCategory category;

    /**
     * This function is setting the location variable at that time that will be used in this class
     * @param location - the current location of the donation
     *
     */
    public Donation(String location) {
        this.location = location;
        time = null;
        shortDescription = null;
        fullDescription = null;
        value = null;
        category = null;
    }

    /**
     * This function is setting all the variables
     * @param location - the location
     * @param time - the current time
     * @param shortDescription - a short description of donation
     * @param fullDescription - detailed description of donation
     * @param value - amount value given
     * @param category - what type of donation
     */
    public Donation(String location, Date time, String shortDescription,
                    String fullDescription, Double value, DonationCategory category) {
        this.location = location;
        this.time = time;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    /**
     * This function takes in whatever is passed in
     * @param in - info that is passed in
     */
    private Donation(Parcel in) {
        location = in.readString();
        time = (Date) in.readSerializable();
        shortDescription = in.readString();
        fullDescription = in.readString();
        value = in.readDouble();
        category = (DonationCategory) in.readSerializable();
    }

    /**
     * This function is writing to parcel
     * @param dest - this is the destination to write
     * @param flags - these are the flags present
     */
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

    /**
     * This function returns the time of the donation
     * @return time - this is the time of donation
     */
    public Date getTime() {
        return time;
    }

    /**
     * gets the location of the donation
     * @return location - location of donation
     */
    public String getLocation() {
        return location;
    }

    /**
     * this is getting the short desctioption
     * @return shortDescription - short description of donation
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * This is getting the full description
     * @return fullDescription - getting the full description of the donation
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * this is getting the value amount of donation
     * @return value - value amount of donation
     */
    public Double getValue() {
        return value;
    }

    /**
     * This is the category of the donation
     * @return category of donation
     */
    public DonationCategory getCategory() {
        return category;
    }

// --Commented out by Inspection START (11/16/18, 4:00 AM):
//    /**
//     * this is setting the location of the donation
//     * @param location - setting location of donation variable
//     */
//    public void setLocation(String location) {
//        this.location = location;
//    }
// --Commented out by Inspection STOP (11/16/18, 4:00 AM)

    /**
     * this is setting the time variable
     * @param time - time of donation
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * this is setting the short description of the variable
     * @param shortDescription - this is the short description of variable
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * This is setting the full description variable
     * @param fullDescription - more detailed description of donation
     */
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /**
     * this is setting the value of the donation
     * @param value - value amount of donation
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * this is setting the category of donation
     * @param category - donation category
     */
    public void setCategory(DonationCategory category) {
        this.category = category;
    }
}
