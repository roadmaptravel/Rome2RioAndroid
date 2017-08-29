package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.rome2rio.com/documentation/search#Route
 */
public class Route implements Parcelable {

    /**
     name 	                string 	            Route display name
     depPlace 	            integer 	        Departure place (index into places array)
     arrPlace 	            integer 	        Arrival place (index into places array)
     distance 	            float 	            Estimated total distance (in km)
     totalDuration 	        float 	            Estimated total duration (in minutes, includes transfers)
     totalTransitDuration 	float 	            Estimated total duration spent in transit (in minutes)
     totalTransferDuration 	float 	            Estimated total duration spent waiting for transfers (in minutes)
     indicativePrices 	    IndicativePrice[] 	Array of indicative prices (optional)
     segments 	            Segment[] 	        Array of segments
     alternatives 	        Alternative[] 	    Array of alternative segments (optional)
     */

    private String name;
    private int depPlace;
    private int arrPlace;
    private float distance;
    private float totalDuration;
    private float totalTransitDuration;
    private float totalTransferDuration;
    private List<IndicativePrice> indicativePrices;
    private List<Segment> segments;
    private List<Alternative> alternatives;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepPlace() {
        return depPlace;
    }

    public void setDepPlace(int depPlace) {
        this.depPlace = depPlace;
    }

    public int getArrPlace() {
        return arrPlace;
    }

    public void setArrPlace(int arrPlace) {
        this.arrPlace = arrPlace;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public float getTotalTransitDuration() {
        return totalTransitDuration;
    }

    public void setTotalTransitDuration(float totalTransitDuration) {
        this.totalTransitDuration = totalTransitDuration;
    }

    public float getTotalTransferDuration() {
        return totalTransferDuration;
    }

    public void setTotalTransferDuration(float totalTransferDuration) {
        this.totalTransferDuration = totalTransferDuration;
    }

    public List<IndicativePrice> getIndicativePrices() {
        return indicativePrices;
    }

    public void setIndicativePrices(List<IndicativePrice> indicativePrices) {
        this.indicativePrices = indicativePrices;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Route(){}

    protected Route(Parcel in) {
        name = in.readString();
        depPlace = in.readInt();
        arrPlace = in.readInt();
        distance = in.readFloat();
        totalDuration = in.readFloat();
        totalTransitDuration = in.readFloat();
        totalTransferDuration = in.readFloat();
        if (in.readByte() == 0x01) {
            indicativePrices = new ArrayList<IndicativePrice>();
            in.readList(indicativePrices, IndicativePrice.class.getClassLoader());
        } else {
            indicativePrices = null;
        }
        if (in.readByte() == 0x01) {
            segments = new ArrayList<Segment>();
            in.readList(segments, Segment.class.getClassLoader());
        } else {
            segments = null;
        }
        if (in.readByte() == 0x01) {
            alternatives = new ArrayList<Alternative>();
            in.readList(alternatives, Alternative.class.getClassLoader());
        } else {
            alternatives = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(depPlace);
        dest.writeInt(arrPlace);
        dest.writeFloat(distance);
        dest.writeFloat(totalDuration);
        dest.writeFloat(totalTransitDuration);
        dest.writeFloat(totalTransferDuration);
        if (indicativePrices == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(indicativePrices);
        }
        if (segments == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(segments);
        }
        if (alternatives == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(alternatives);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Route> CREATOR = new Parcelable.Creator<Route>() {
        @Override
        public Route createFromParcel(Parcel in) {
            return new Route(in);
        }

        @Override
        public Route[] newArray(int size) {
            return new Route[size];
        }
    };

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name + '\'' +
                ", depPlace=" + depPlace +
                ", arrPlace=" + arrPlace +
                ", distance=" + distance +
                ", totalDuration=" + totalDuration +
                ", totalTransitDuration=" + totalTransitDuration +
                ", totalTransferDuration=" + totalTransferDuration +
                ", indicativePrices=" + indicativePrices +
                ", segments=" + segments +
                ", alternatives=" + alternatives +
                '}';
    }
}