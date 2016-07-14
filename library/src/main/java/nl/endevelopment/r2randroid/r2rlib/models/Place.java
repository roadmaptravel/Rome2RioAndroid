package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Glenn on 09-07-15.
 * class for api v1.4
 * https://www.rome2rio.com/documentation/search#Place
 */
public class Place implements Parcelable {

    /**
     lat 	    float 	Latitude (WGS84)
     lng 	    float 	Longitude (WGS84)
     kind 	    string 	Type of place [1]
     shortName 	string 	Display name
     code 	    string 	Airport or Station code (eg: IATA)
     regionCode string 	Region code (ISO 3166-2 or FIPS) (optional)
     countryCodestring 	Country code (ISO 3166-1 alpha-2) (optional)
     timeZone 	string 	Time zone (IANA) (optional)
     */

    private float lat;
    private float lng;
    private String kind;
    private String shortName;
    private String code;
    private String countryCode;
    private String regionCode;
    private String timeZone;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    protected Place(Parcel in) {
        lat = in.readFloat();
        lng = in.readFloat();
        kind = in.readString();
        shortName = in.readString();
        code = in.readString();
        countryCode = in.readString();
        regionCode = in.readString();
        timeZone = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(lat);
        dest.writeFloat(lng);
        dest.writeString(kind);
        dest.writeString(shortName);
        dest.writeString(code);
        dest.writeString(countryCode);
        dest.writeString(regionCode);
        dest.writeString(timeZone);
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
}