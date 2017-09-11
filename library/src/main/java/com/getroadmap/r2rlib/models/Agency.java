package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * https://www.rome2rio.com/documentation/search#Agency
 * class for api v1.4
 */
public class Agency implements Parcelable {

    /**
     name 	string 	Display name
     url 	string 	Agency URL (optional)
     phone 	string 	Agency Phone Number (optional)
     icon 	Icon 	Agency icon (optional)
     */

    private String name;
    private String url;
    private String phone;
    private Icon icon;


    protected Agency(Parcel in) {
        name = in.readString();
        url = in.readString();
        phone = in.readString();
        icon = (Icon) in.readValue(Icon.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(phone);
        dest.writeValue(icon);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Agency> CREATOR = new Parcelable.Creator<Agency>() {
        @Override
        public Agency createFromParcel(Parcel in) {
            return new Agency(in);
        }

        @Override
        public Agency[] newArray(int size) {
            return new Agency[size];
        }
    };

    @Override
    public String toString() {
        return "Agency{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                ", icon=" + icon +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}