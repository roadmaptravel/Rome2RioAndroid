package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/16.
 */

public class SurfaceSegment extends Segment implements Parcelable {

    /*
    segmentKind 	    string 	"surface"
    depPlace 	        integer 	Departure place (index into places array)
    arrPlace 	        integer 	Arrival place (index into places array)
    vehicle 	        integer 	Vehicle (index into vehicles array)
    distance 	        float 	Estimated distance (in km)
    transitDuration 	float 	Estimated duration spent in transit (in minutes)
    transferDuration 	float 	Estimated duration spent waiting for transfer (in minutes)
    path 	            Path 	Path followed by vehicle/pedestrian (optional)
    indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
    stops 	            SurfaceStop[] 	Array of intermediate stops (optional)
    agencies 	        SurfaceAgency[] 	Array of agencies
     */

    private String path;
    private List<SurfaceStop> stops;
    private List<SurfaceAgency> agencies;

    public SurfaceSegment(){}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SurfaceStop> getStops() {
        return stops;
    }

    public void setStops(List<SurfaceStop> stops) {
        this.stops = stops;
    }

    public List<SurfaceAgency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<SurfaceAgency> agencies) {
        this.agencies = agencies;
    }

    protected SurfaceSegment(Parcel in) {
        path = in.readString();
        if (in.readByte() == 0x01) {
            stops = new ArrayList<SurfaceStop>();
            in.readList(stops, SurfaceStop.class.getClassLoader());
        } else {
            stops = null;
        }
        if (in.readByte() == 0x01) {
            agencies = new ArrayList<SurfaceAgency>();
            in.readList(agencies, SurfaceAgency.class.getClassLoader());
        } else {
            agencies = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        if (stops == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(stops);
        }
        if (agencies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(agencies);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SurfaceSegment> CREATOR = new Parcelable.Creator<SurfaceSegment>() {
        @Override
        public SurfaceSegment createFromParcel(Parcel in) {
            return new SurfaceSegment(in);
        }

        @Override
        public SurfaceSegment[] newArray(int size) {
            return new SurfaceSegment[size];
        }
    };
}