package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 11/07/16.
 */

public class SurfaceLineName implements Parcelable {
    String name; // 	Display name or number

    public SurfaceLineName() {
    }

    public SurfaceLineName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected SurfaceLineName(Parcel in) {
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SurfaceLineName> CREATOR = new Parcelable.Creator<SurfaceLineName>() {
        @Override
        public SurfaceLineName createFromParcel(Parcel in) {
            return new SurfaceLineName(in);
        }

        @Override
        public SurfaceLineName[] newArray(int size) {
            return new SurfaceLineName[size];
        }
    };

    @Override
    public String toString() {
        return "SurfaceLineName{" +
                "name='" + name + '\'' +
                '}';
    }
}