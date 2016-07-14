package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 11/07/16.
 */

public class AirSegment extends Segment implements Parcelable {

    /**
     segmentKind 	    string 	"air"
     depPlace 	        integer 	Departure airport (index into places array)
     arrPlace 	        integer 	Arrival airport (index into places array)
     vehicle 	        integer 	Vehicle (index into vehicles array)
     distance 	        float 	Estimated distance (in km)
     transitDuration 	float 	Estimated duration spent in transit (in minutes)
     transferDuration 	float 	Estimated duration spent waiting for transfer (in minutes)
     indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
     outbound 	        AirLeg[] 	Array of outbound legs
     return 	        AirLeg[] 	Array of return legs
     * @return
     */

    @Override
    public String getSegmentKind() {
        return "air";
    }

    public AirSegment() {
    }

    protected AirSegment(Parcel in) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AirSegment> CREATOR = new Parcelable.Creator<AirSegment>() {
        @Override
        public AirSegment createFromParcel(Parcel in) {
            return new AirSegment(in);
        }

        @Override
        public AirSegment[] newArray(int size) {
            return new AirSegment[size];
        }
    };
}