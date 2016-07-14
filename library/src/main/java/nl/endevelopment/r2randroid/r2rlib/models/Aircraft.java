package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Glenn on 09-07-15.
 *
 * https://www.rome2rio.com/documentation/search#Aircraft
 * class for api v1.4
 */
public class Aircraft implements Parcelable {

    /**
     code 	        string 	Aircraft code (IATA)
     manufacturer 	string 	Manufacturer name
     model 	        string 	Model name
     */

    private String code;
    private String manufacturer;
    private String model;

    public String getCode() {
        return code;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.manufacturer);
        dest.writeString(this.model);
    }

    public Aircraft() {
    }

    protected Aircraft(Parcel in) {
        this.code = in.readString();
        this.manufacturer = in.readString();
        this.model = in.readString();
    }

    public static final Parcelable.Creator<Aircraft> CREATOR = new Parcelable.Creator<Aircraft>() {
        public Aircraft createFromParcel(Parcel source) {
            return new Aircraft(source);
        }

        public Aircraft[] newArray(int size) {
            return new Aircraft[size];
        }
    };
}
