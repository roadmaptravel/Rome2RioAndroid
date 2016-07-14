package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 *
 *
 */
public class FlightHop implements Parcelable {

    private String sCode;
    private String tCode;
    private String sTerminal;
    private String tTerminal;
    private String sTime;
    private String tTime;
    private String airline;
    private String flight;
    private double duration;
    private String aircraft;
    private int dayChange;
    private double lDuration;
    private int lDayChange;
    private List<Codeshare> codeshares;

    public String getsCode() {
        return sCode;
    }

    public String gettCode() {
        return tCode;
    }

    public String getsTerminal() {
        return sTerminal;
    }

    public String gettTerminal() {
        return tTerminal;
    }

    public String getsTime() {
        return sTime;
    }

    public String gettTime() {
        return tTime;
    }

    public String getAirline() {
        return airline;
    }

    public String getFlight() {
        return flight;
    }

    public double getDuration() {
        return duration;
    }

    public String getAircraft() {
        return aircraft;
    }

    public int getDayChange() {
        return dayChange;
    }

    public double getlDuration() {
        return lDuration;
    }

    public int getlDayChange() {
        return lDayChange;
    }

    public List<Codeshare> getCodeshares() {
        return codeshares;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sCode);
        dest.writeString(this.tCode);
        dest.writeString(this.sTerminal);
        dest.writeString(this.tTerminal);
        dest.writeString(this.sTime);
        dest.writeString(this.tTime);
        dest.writeString(this.airline);
        dest.writeString(this.flight);
        dest.writeDouble(this.duration);
        dest.writeString(this.aircraft);
        dest.writeInt(this.dayChange);
        dest.writeDouble(this.lDuration);
        dest.writeInt(this.lDayChange);
        dest.writeTypedList(codeshares);
    }

    public FlightHop() {
    }

    protected FlightHop(Parcel in) {
        this.sCode = in.readString();
        this.tCode = in.readString();
        this.sTerminal = in.readString();
        this.tTerminal = in.readString();
        this.sTime = in.readString();
        this.tTime = in.readString();
        this.airline = in.readString();
        this.flight = in.readString();
        this.duration = in.readDouble();
        this.aircraft = in.readString();
        this.dayChange = in.readInt();
        this.lDuration = in.readDouble();
        this.lDayChange = in.readInt();
        this.codeshares = in.createTypedArrayList(Codeshare.CREATOR);
    }

    public static final Parcelable.Creator<FlightHop> CREATOR = new Parcelable.Creator<FlightHop>() {
        public FlightHop createFromParcel(Parcel source) {
            return new FlightHop(source);
        }

        public FlightHop[] newArray(int size) {
            return new FlightHop[size];
        }
    };
}
