package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 11/07/16.
 *
 * https://www.rome2rio.com/documentation/search#Alternative
 */

public class Alternative implements Parcelable {
    /**
     firstSegment 	integer 	First segment to replace (index into segments array) [1]
     lastSegment 	integer 	Last segment to replace (index into segments array) [1]
     route 	        Route 	    Alternative route
     */

    private int firstSegment;
    private int lastSegment;
    private Route route;

    public Alternative() {
    }

    public int getFirstSegment() {
        return firstSegment;
    }

    public void setFirstSegment(int firstSegment) {
        this.firstSegment = firstSegment;
    }

    public int getLastSegment() {
        return lastSegment;
    }

    public void setLastSegment(int lastSegment) {
        this.lastSegment = lastSegment;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    protected Alternative(Parcel in) {
        firstSegment = in.readInt();
        lastSegment = in.readInt();
        route = (Route) in.readValue(Route.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(firstSegment);
        dest.writeInt(lastSegment);
        dest.writeValue(route);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Alternative> CREATOR = new Parcelable.Creator<Alternative>() {
        @Override
        public Alternative createFromParcel(Parcel in) {
            return new Alternative(in);
        }

        @Override
        public Alternative[] newArray(int size) {
            return new Alternative[size];
        }
    };

    @Override
    public String toString() {
        return "Alternative{" +
                "firstSegment=" + firstSegment +
                ", lastSegment=" + lastSegment +
                ", route=" + route +
                '}';
    }
}