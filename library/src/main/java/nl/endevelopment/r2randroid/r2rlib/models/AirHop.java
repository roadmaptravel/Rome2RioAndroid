package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/16.
 */

public class AirHop implements Parcelable {

    /**
     depPlace 	        integer 	Departure airport (index into places array)
     arrPlace 	        integer 	Arrival airport (index into places array)
     depTerminal 	    string 	Departure airport terminal (optional)
     arrTerminal 	    string 	Arrival airport terminal (optional)
     depTime 	        string 	Departure time (24-hour local time - hh:mm)
     arrTime 	        string 	Arrival time (24-hour local time - hh:mm)
     flight 	        string 	Flight number
     duration 	        float 	Estimated flight duration (in minutes)
     airline 	        string 	Advertised airline (index into airlines array)
     operatingAirline 	string 	Operating airline (index into airlines array) (optional)
     aircraft 	        string 	Aircraft (index into aircrafts array) (optional)
     dayChange 	        integer 	Num day changes during flight (optional)
     layoverDuration 	float 	Layover time (in minutes) (optional)
     layoverDayChange 	integer 	Num day changes during layover (optional)
     codeshares 	    AirCodeshare[] 	Array of codeshares (optional)
     */

    private int depPlace;
    private int arrPlace;
    private String depTerminal;
    private String arrTerminal;
    private String depTime;
    private String arrTime;
    private String flight;
    private float duration;
    private String airline;
    private String operatingAirline;
    private String aircraft;
    private int dayChange;
    private float layoverDuration;
    private int layoverDayChange;
    private List<AirCodeshare> codeshares;

    public AirHop() {
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

    public String getDepTerminal() {
        return depTerminal;
    }

    public void setDepTerminal(String depTerminal) {
        this.depTerminal = depTerminal;
    }

    public String getArrTerminal() {
        return arrTerminal;
    }

    public void setArrTerminal(String arrTerminal) {
        this.arrTerminal = arrTerminal;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getDayChange() {
        return dayChange;
    }

    public void setDayChange(int dayChange) {
        this.dayChange = dayChange;
    }

    public float getLayoverDuration() {
        return layoverDuration;
    }

    public void setLayoverDuration(float layoverDuration) {
        this.layoverDuration = layoverDuration;
    }

    public int getLayoverDayChange() {
        return layoverDayChange;
    }

    public void setLayoverDayChange(int layoverDayChange) {
        this.layoverDayChange = layoverDayChange;
    }

    public List<AirCodeshare> getCodeshares() {
        return codeshares;
    }

    public void setCodeshares(List<AirCodeshare> codeshares) {
        this.codeshares = codeshares;
    }

    protected AirHop(Parcel in) {
        depPlace = in.readInt();
        arrPlace = in.readInt();
        depTerminal = in.readString();
        arrTerminal = in.readString();
        depTime = in.readString();
        arrTime = in.readString();
        flight = in.readString();
        duration = in.readFloat();
        airline = in.readString();
        operatingAirline = in.readString();
        aircraft = in.readString();
        dayChange = in.readInt();
        layoverDuration = in.readFloat();
        layoverDayChange = in.readInt();
        if (in.readByte() == 0x01) {
            codeshares = new ArrayList<AirCodeshare>();
            in.readList(codeshares, AirCodeshare.class.getClassLoader());
        } else {
            codeshares = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(depPlace);
        dest.writeInt(arrPlace);
        dest.writeString(depTerminal);
        dest.writeString(arrTerminal);
        dest.writeString(depTime);
        dest.writeString(arrTime);
        dest.writeString(flight);
        dest.writeFloat(duration);
        dest.writeString(airline);
        dest.writeString(operatingAirline);
        dest.writeString(aircraft);
        dest.writeInt(dayChange);
        dest.writeFloat(layoverDuration);
        dest.writeInt(layoverDayChange);
        if (codeshares == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(codeshares);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AirHop> CREATOR = new Parcelable.Creator<AirHop>() {
        @Override
        public AirHop createFromParcel(Parcel in) {
            return new AirHop(in);
        }

        @Override
        public AirHop[] newArray(int size) {
            return new AirHop[size];
        }
    };
}