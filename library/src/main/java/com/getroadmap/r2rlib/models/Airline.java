package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Glenn on 09-07-15.
 *
 * https://www.rome2rio.com/documentation/search#Airline
 * class for api v1.4
 */
public class Airline implements Parcelable {

    /**
     code 	string 	Airline code (IATA)
     name 	string 	Display name
     url 	string 	Airline URL (optional)
     icon 	Icon 	Airline icon (optional)
     */

    private String code;
    private String name;
    private String url;
    private Icon icon;


    public Airline() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    protected Airline(Parcel in) {
        code = in.readString();
        name = in.readString();
        url = in.readString();
        icon = (Icon) in.readValue(Icon.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeValue(icon);
    }

    public static final Parcelable.Creator<Airline> CREATOR = new Parcelable.Creator<Airline>() {
        public Airline createFromParcel(Parcel source) {
            return new Airline(source);
        }

        public Airline[] newArray(int size) {
            return new Airline[size];
        }
    };

    @Override
    public String toString() {
        return "Airline{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon=" + icon +
                '}';
    }
}