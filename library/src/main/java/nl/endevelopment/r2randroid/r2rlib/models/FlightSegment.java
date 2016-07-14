package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Glenn on 09-07-15.
 */
public class FlightSegment implements Parcelable {

    private String kind;
    private Boolean isMajor;
    private double distance;
    private double duration;
    private String sCode;
    private String tCode;
    private IndicativePrice indicativePrice;
    private List<FlightItinerary> itineraries;

    public String getKind() {
        return kind;
    }

    public Boolean isMajor() {
        return isMajor;
    }

    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }

    public String getsCode() {
        return sCode;
    }

    public String gettCode() {
        return tCode;
    }

    public IndicativePrice getIndicativePrice() {
        return indicativePrice;
    }

    public List<FlightItinerary> getItineraries() {
        return itineraries;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kind);
        dest.writeValue(this.isMajor);
        dest.writeDouble(this.distance);
        dest.writeDouble(this.duration);
        dest.writeString(this.sCode);
        dest.writeString(this.tCode);
        dest.writeParcelable(this.indicativePrice, 0);
        dest.writeTypedList(itineraries);
    }

    public FlightSegment() {
    }

    protected FlightSegment(Parcel in) {
        this.kind = in.readString();
        this.isMajor = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.distance = in.readDouble();
        this.duration = in.readDouble();
        this.sCode = in.readString();
        this.tCode = in.readString();
        this.indicativePrice = in.readParcelable(IndicativePrice.class.getClassLoader());
        this.itineraries = in.createTypedArrayList(FlightItinerary.CREATOR);
    }

    public static final Creator<FlightSegment> CREATOR = new Creator<FlightSegment>() {
        public FlightSegment createFromParcel(Parcel source) {
            return new FlightSegment(source);
        }

        public FlightSegment[] newArray(int size) {
            return new FlightSegment[size];
        }
    };
}
