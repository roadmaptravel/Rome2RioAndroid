package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Glenn on 09-07-15.
 */
public class FlightItinerary implements Parcelable {

    private List<FlightLeg> legs;

    public List<FlightLeg> getLegs() {
        return legs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(legs);
    }

    public FlightItinerary() {
    }

    protected FlightItinerary(Parcel in) {
        this.legs = in.createTypedArrayList(FlightLeg.CREATOR);
    }

    public static final Creator<FlightItinerary> CREATOR = new Creator<FlightItinerary>() {
        public FlightItinerary createFromParcel(Parcel source) {
            return new FlightItinerary(source);
        }

        public FlightItinerary[] newArray(int size) {
            return new FlightItinerary[size];
        }
    };
}
