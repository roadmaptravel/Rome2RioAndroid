package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 11/07/16.
 *
 * https://www.rome2rio.com/documentation/search#SurfaceStop
 */

public class SurfaceStop implements Parcelable {
    /**
     place 	            integer 	Place (index into places array)
     transitDuration 	float 	Estimated duration spent in transit (in minutes)
     stopDuration 	    float 	Estimated duration spent waiting at stop before departing (in minutes)
     */

    private int place;
    private float transitDuration;
    private float stopDuration;

    public SurfaceStop() {
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public float getTransitDuration() {
        return transitDuration;
    }

    public void setTransitDuration(float transitDuration) {
        this.transitDuration = transitDuration;
    }

    public float getStopDuration() {
        return stopDuration;
    }

    public void setStopDuration(float stopDuration) {
        this.stopDuration = stopDuration;
    }

    protected SurfaceStop(Parcel in) {
        place = in.readInt();
        transitDuration = in.readFloat();
        stopDuration = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(place);
        dest.writeFloat(transitDuration);
        dest.writeFloat(stopDuration);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SurfaceStop> CREATOR = new Parcelable.Creator<SurfaceStop>() {
        @Override
        public SurfaceStop createFromParcel(Parcel in) {
            return new SurfaceStop(in);
        }

        @Override
        public SurfaceStop[] newArray(int size) {
            return new SurfaceStop[size];
        }
    };

    @Override
    public String toString() {
        return "SurfaceStop{" +
                "place=" + place +
                ", transitDuration=" + transitDuration +
                ", stopDuration=" + stopDuration +
                '}';
    }
}