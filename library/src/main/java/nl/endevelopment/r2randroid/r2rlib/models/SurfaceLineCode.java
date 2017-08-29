package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 11/07/16.
 */

public class SurfaceLineCode implements Parcelable {
    private String code; // 	Internal line code

    public SurfaceLineCode() {
    }

    public SurfaceLineCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    protected SurfaceLineCode(Parcel in) {
        code = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SurfaceLineCode> CREATOR = new Parcelable.Creator<SurfaceLineCode>() {
        @Override
        public SurfaceLineCode createFromParcel(Parcel in) {
            return new SurfaceLineCode(in);
        }

        @Override
        public SurfaceLineCode[] newArray(int size) {
            return new SurfaceLineCode[size];
        }
    };
}