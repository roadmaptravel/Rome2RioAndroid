package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.rome2rio.com/documentation/search#Segment
 */
public class Segment implements Parcelable {

    /**
     * segmentKind	string	Segment kind [1]
     * depPlace	integer	Departure airport (index into places array)
     * arrPlace	integer	Arrival airport (index into places array)
     * vehicle	integer	Vehicle (index into vehicles array)
     * distance	float	Estimated distance (in km)
     * transitDuration	float	Estimated duration spent in transit (in minutes)
     * transferDuration	float	Estimated duration spent waiting for transfer (in minutes)
     * indicativePrices	IndicativePrice[]	Array of indicative prices (optional)
     */

    @SerializedName("segmentKind")
    @Expose
    private String segmentKind; //e.g. "air"
    @SerializedName("depPlace")
    @Expose
    private int depPlace;//Departure airport (index into places array)
    @SerializedName("arrPlace")
    @Expose
    private int arrPlace;//Arrival airport (index into places array)
    @SerializedName("vehicle")
    @Expose
    private int vehicle;//Vehicle (index into vehicles array)
    @SerializedName("distance")
    @Expose
    private float distance;//Estimated distance (in km)
    @SerializedName("transitDuration")
    @Expose
    private float transitDuration;//Estimated duration spent in transit (in minutes)
    @SerializedName("transferDuration")
    @Expose
    private float transferDuration;//Estimated duration spent waiting for transfer (in minutes)
    @SerializedName("indicativePrices")
    @Expose
    private List<IndicativePrice> indicativePrices = null;//IndicativePrice[] 	Array of indicative prices (optional)

    public Segment() {
    }

    public String getSegmentKind() {
        return segmentKind;
    }

    public void setSegmentKind(String segmentKind) {
        this.segmentKind = segmentKind;
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

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getTransitDuration() {
        return transitDuration;
    }

    public void setTransitDuration(float transitDuration) {
        this.transitDuration = transitDuration;
    }

    public float getTransferDuration() {
        return transferDuration;
    }

    public void setTransferDuration(float transferDuration) {
        this.transferDuration = transferDuration;
    }

    public List<IndicativePrice> getIndicativePrices() {
        return indicativePrices;
    }

    public void setIndicativePrices(List<IndicativePrice> indicativePrices) {
        this.indicativePrices = indicativePrices;
    }

    protected Segment(Parcel in) {
        segmentKind = in.readString();
        depPlace = in.readInt();
        arrPlace = in.readInt();
        vehicle = in.readInt();
        distance = in.readFloat();
        transitDuration = in.readFloat();
        transferDuration = in.readFloat();
        if (in.readByte() == 0x01) {
            indicativePrices = new ArrayList<IndicativePrice>();
            in.readList(indicativePrices, IndicativePrice.class.getClassLoader());
        } else {
            indicativePrices = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(segmentKind);
        dest.writeInt(depPlace);
        dest.writeInt(arrPlace);
        dest.writeInt(vehicle);
        dest.writeFloat(distance);
        dest.writeFloat(transitDuration);
        dest.writeFloat(transferDuration);
        if (indicativePrices == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(indicativePrices);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Segment> CREATOR = new Parcelable.Creator<Segment>() {
        @Override
        public Segment createFromParcel(Parcel in) {
            return new Segment(in);
        }

        @Override
        public Segment[] newArray(int size) {
            return new Segment[size];
        }
    };

    @Override
    public String toString() {
        return "Segment{" +
                "segmentKind='" + segmentKind + '\'' +
                ", depPlace=" + depPlace +
                ", arrPlace=" + arrPlace +
                ", vehicle=" + vehicle +
                ", distance=" + distance +
                ", transitDuration=" + transitDuration +
                ", transferDuration=" + transferDuration +
                ", indicativePrices=" + indicativePrices +
                '}';
    }
}