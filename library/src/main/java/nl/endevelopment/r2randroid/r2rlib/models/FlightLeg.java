package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 *
 */
public class FlightLeg implements Parcelable {

    /*
     * 0x01	Sunday
     * 0x02	Monday
     * 0x04	Tuesday
     * 0x08	Wednesday
     * 0x10	Thursday
     * 0x20	Friday
     * 0x40	Saturday
     * Weekdays: 0x3E (0x02 + 0x04 + 0x08 + 0x10 + 0x20)
     * Weekends: 0x41 (0x01 + 0x40)
     * Every day: 0x7F
     */
    private int days;
    private List<FlightHop> hops;

    public int getDays() {
        return days;
    }

    public List<FlightHop> getHops() {
        return hops;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.days);
        dest.writeTypedList(hops);
    }

    public FlightLeg() {
    }

    protected FlightLeg(Parcel in) {
        this.days = in.readInt();
        this.hops = in.createTypedArrayList(FlightHop.CREATOR);
    }

    public static final Parcelable.Creator<FlightLeg> CREATOR = new Parcelable.Creator<FlightLeg>() {
        public FlightLeg createFromParcel(Parcel source) {
            return new FlightLeg(source);
        }

        public FlightLeg[] newArray(int size) {
            return new FlightLeg[size];
        }
    };
}
