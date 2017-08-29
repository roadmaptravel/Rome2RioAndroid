package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/16.
 */

public class SurfaceAgency implements Parcelable {

    /**
     * agency 	    integer 	Agency (index into agencies array)
     * frequency 	    float 	Estimated feequency (per week) (optional)
     * duration 	    float 	Estimated duration (in minutes) (optional)
     * operatingDays 	DayFlags 	Days of operation bitmask (optional)
     * lineNames 	    SurfaceLineName[] 	Array of line names (optional) [1]
     * lineCodes 	    SurfaceLineCode[] 	Array of line codes (optional) [1]
     * links 	        ExternalLink[] 	Array of links (optional)
     */

    private int agency;
    private float frequency;
    private float duration;
    private DayFlags operatindDays;
    private List<SurfaceLineName> lineNames;
    private List<SurfaceLineCode> lineCodes;
    private List<ExternalLink> links;

    public SurfaceAgency() {
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public DayFlags getOperatindDays() {
        return operatindDays;
    }

    public void setOperatindDays(DayFlags operatindDays) {
        this.operatindDays = operatindDays;
    }

    public List<SurfaceLineName> getLineNames() {
        return lineNames;
    }

    public void setLineNames(List<SurfaceLineName> lineNames) {
        this.lineNames = lineNames;
    }

    public List<SurfaceLineCode> getLineCodes() {
        return lineCodes;
    }

    public void setLineCodes(List<SurfaceLineCode> lineCodes) {
        this.lineCodes = lineCodes;
    }

    public List<ExternalLink> getLinks() {
        return links;
    }

    public void setLinks(List<ExternalLink> links) {
        this.links = links;
    }



    protected SurfaceAgency(Parcel in) {
        agency = in.readInt();
        frequency = in.readFloat();
        duration = in.readFloat();
        operatindDays = (DayFlags) in.readValue(DayFlags.class.getClassLoader());
        if (in.readByte() == 0x01) {
            lineNames = new ArrayList<SurfaceLineName>();
            in.readList(lineNames, SurfaceLineName.class.getClassLoader());
        } else {
            lineNames = null;
        }
        if (in.readByte() == 0x01) {
            lineCodes = new ArrayList<SurfaceLineCode>();
            in.readList(lineCodes, SurfaceLineCode.class.getClassLoader());
        } else {
            lineCodes = null;
        }
        if (in.readByte() == 0x01) {
            links = new ArrayList<ExternalLink>();
            in.readList(links, ExternalLink.class.getClassLoader());
        } else {
            links = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(agency);
        dest.writeFloat(frequency);
        dest.writeFloat(duration);
        dest.writeValue(operatindDays);
        if (lineNames == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(lineNames);
        }
        if (lineCodes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(lineCodes);
        }
        if (links == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(links);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SurfaceAgency> CREATOR = new Parcelable.Creator<SurfaceAgency>() {
        @Override
        public SurfaceAgency createFromParcel(Parcel in) {
            return new SurfaceAgency(in);
        }

        @Override
        public SurfaceAgency[] newArray(int size) {
            return new SurfaceAgency[size];
        }
    };
}