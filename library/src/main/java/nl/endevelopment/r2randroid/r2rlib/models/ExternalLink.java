package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 11/07/16.
 */

public class ExternalLink implements Parcelable {
    /**
     text 	        string 	Link text
     url 	        string 	Link URL
     displayUrl 	string 	Display URL (cleaned up link url) (optional)
     moustacheUrl 	string 	Moustach URL (link url with replacement parameters) (optional)
     */

    private String text;
    private String url;
    private String displayUrl;
    private String moustacheUrl;

    public ExternalLink() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getMoustacheUrl() {
        return moustacheUrl;
    }

    public void setMoustacheUrl(String moustacheUrl) {
        this.moustacheUrl = moustacheUrl;
    }

    protected ExternalLink(Parcel in) {
        text = in.readString();
        url = in.readString();
        displayUrl = in.readString();
        moustacheUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(url);
        dest.writeString(displayUrl);
        dest.writeString(moustacheUrl);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ExternalLink> CREATOR = new Parcelable.Creator<ExternalLink>() {
        @Override
        public ExternalLink createFromParcel(Parcel in) {
            return new ExternalLink(in);
        }

        @Override
        public ExternalLink[] newArray(int size) {
            return new ExternalLink[size];
        }
    };

    @Override
    public String toString() {
        return "ExternalLink{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", displayUrl='" + displayUrl + '\'' +
                ", moustacheUrl='" + moustacheUrl + '\'' +
                '}';
    }
}