package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jan on 23-09-17.
 * class for api v1.4
 * https://www.rome2rio.com/documentation/search#Place
 */
public class Place implements Parcelable {

    /**
     * lat 	    float 	Latitude (WGS84)
     * lng 	    float 	Longitude (WGS84)
     * kind 	    string 	Type of place [1]
     * shortName 	string 	Display name
     * code 	    string 	Airport or Station code (eg: IATA)
     * regionCode string 	Region code (ISO 3166-2 or FIPS) (optional)
     * countryCodestring 	Country code (ISO 3166-1 alpha-2) (optional)
     * timeZone 	string 	Time zone (IANA) (optional)
     */

    @SerializedName("lat")
    @Expose
    private float lat;
    @SerializedName("lng")
    @Expose
    private float lng;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("longName")
    @Expose
    private String longName;
    @SerializedName("canonicalName")
    @Expose
    private String canonicalName;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;
    @SerializedName("code")
    @Expose
    private String code;

    public Place() {
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    protected Place(Parcel in) {
        lat = in.readFloat();
        lng = in.readFloat();
        kind = in.readString();
        shortName = in.readString();
        longName = in.readString();
        canonicalName = in.readString();
        regionCode = in.readString();
        countryCode = in.readString();
        timeZone = in.readString();
        code = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(lat);
        dest.writeFloat(lng);
        dest.writeString(kind);
        dest.writeString(shortName);
        dest.writeString(longName);
        dest.writeString(canonicalName);
        dest.writeString(regionCode);
        dest.writeString(countryCode);
        dest.writeString(timeZone);
        dest.writeString(code);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Place{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", kind='" + kind + '\'' +
                ", shortName='" + shortName + '\'' +
                ", longName='" + longName + '\'' +
                ", canonicalName='" + canonicalName + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}