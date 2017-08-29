package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jan on 11/07/16.
 */

public class AirCodeshare implements Parcelable {
    /**
     airline 	integer 	Airline (index into airlines array)
     flight 	string 	    Flight number
     */

    @SerializedName("airline")
    @Expose
    private int airline;
    @SerializedName("flight")
    @Expose
    private String flight;

    public AirCodeshare() {
    }

    public int getAirline() {
        return airline;
    }

    public void setAirline(int airline) {
        this.airline = airline;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    protected AirCodeshare(Parcel in) {
        airline = in.readInt();
        flight = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(airline);
        dest.writeString(flight);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AirCodeshare> CREATOR = new Parcelable.Creator<AirCodeshare>() {
        @Override
        public AirCodeshare createFromParcel(Parcel in) {
            return new AirCodeshare(in);
        }

        @Override
        public AirCodeshare[] newArray(int size) {
            return new AirCodeshare[size];
        }
    };
}