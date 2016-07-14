package nl.endevelopment.r2randroid.r2rlib.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import nl.endevelopment.r2randroid.r2rlib.models.Agency;
import nl.endevelopment.r2randroid.r2rlib.models.Aircraft;
import nl.endevelopment.r2randroid.r2rlib.models.Airline;
import nl.endevelopment.r2randroid.r2rlib.models.Place;
import nl.endevelopment.r2randroid.r2rlib.models.Route;
import nl.endevelopment.r2randroid.r2rlib.models.Vehicle;

/**
 *
 */
public class SearchResponse implements Parcelable {

    /**
     * elapsedTime 	string 	    Time to process request (in milliseconds)
     * currencyCode 	string 	    Response currency code (ISO 4217)
     * languageCode 	string 	    Response language code (ISO 639-1)
     * data 	        string 	    Caller supplied data string (optional)
     * places 	    Place[] 	Array of places [1]
     * airlines 	    Airline[] 	Array of airlines
     * aircrafts 	    Aircraft[] 	Array of aircrafts
     * agencies 	    Agency[] 	Array of transit agencies
     * vehicles 	    Vehicle[] 	Array of transit vehicles
     * routes
     */

    private String elapsedTime;
    private String currencyCode;
    private String languageCode;
    private String data;
    private List<Place> places;
    private List<Airline> airlines;
    private List<Aircraft> aircrafts;
    private List<Agency> agencies;
    private List<Route> routes;
    private List<Vehicle> vehicles;


    public SearchResponse() {
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getData() {
        return data;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    protected SearchResponse(Parcel in) {
        elapsedTime = in.readString();
        currencyCode = in.readString();
        languageCode = in.readString();
        data = in.readString();
        if (in.readByte() == 0x01) {
            places = new ArrayList<Place>();
            in.readList(places, Place.class.getClassLoader());
        } else {
            places = null;
        }
        if (in.readByte() == 0x01) {
            airlines = new ArrayList<Airline>();
            in.readList(airlines, Airline.class.getClassLoader());
        } else {
            airlines = null;
        }
        if (in.readByte() == 0x01) {
            aircrafts = new ArrayList<Aircraft>();
            in.readList(aircrafts, Aircraft.class.getClassLoader());
        } else {
            aircrafts = null;
        }
        if (in.readByte() == 0x01) {
            agencies = new ArrayList<Agency>();
            in.readList(agencies, Agency.class.getClassLoader());
        } else {
            agencies = null;
        }
        if (in.readByte() == 0x01) {
            routes = new ArrayList<Route>();
            in.readList(routes, Route.class.getClassLoader());
        } else {
            routes = null;
        }
        if (in.readByte() == 0x01) {
            vehicles = new ArrayList<Vehicle>();
            in.readList(vehicles, Vehicle.class.getClassLoader());
        } else {
            vehicles = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(elapsedTime);
        dest.writeString(currencyCode);
        dest.writeString(languageCode);
        dest.writeString(data);
        if (places == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(places);
        }
        if (airlines == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(airlines);
        }
        if (aircrafts == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(aircrafts);
        }
        if (agencies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(agencies);
        }
        if (routes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(routes);
        }
        if (vehicles == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(vehicles);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SearchResponse> CREATOR = new Parcelable.Creator<SearchResponse>() {
        @Override
        public SearchResponse createFromParcel(Parcel in) {
            return new SearchResponse(in);
        }

        @Override
        public SearchResponse[] newArray(int size) {
            return new SearchResponse[size];
        }
    };
}