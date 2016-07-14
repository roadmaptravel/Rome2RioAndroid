package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Glenn on 09-07-15.
 */
public class Codeshare implements Parcelable {

    private String airline;
    private String flight;

    public String getAirline() {
        return airline;
    }

    public String getFlight() {
        return flight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.airline);
        dest.writeString(this.flight);
    }

    public Codeshare() {
    }

    protected Codeshare(Parcel in) {
        this.airline = in.readString();
        this.flight = in.readString();
    }

    public static final Parcelable.Creator<Codeshare> CREATOR = new Parcelable.Creator<Codeshare>() {
        public Codeshare createFromParcel(Parcel source) {
            return new Codeshare(source);
        }

        public Codeshare[] newArray(int size) {
            return new Codeshare[size];
        }
    };
}
