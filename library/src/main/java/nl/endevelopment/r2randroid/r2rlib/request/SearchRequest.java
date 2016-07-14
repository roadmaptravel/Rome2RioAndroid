package nl.endevelopment.r2randroid.r2rlib.request;

import nl.endevelopment.r2randroid.r2rlib.models.Position;

/**
 * Created by jan on 14/07/16.
 */

public class SearchRequest {
    private String key;
    private String oName;
    private String dName;
    private Position oPos;
    private Position dPos;
    private String oKind;
    private String dKind;
    private String currencyCode;
    private String languageCode;
    private String data;
    private boolean noAir;
    private boolean noAirLeg;
    private boolean noRail;
    private boolean noBus;
    private boolean noFerry;
    private boolean noCar;
    private boolean noBikeshare;
    private boolean noRideshare;
    private boolean noTowncar;
    private boolean noCommuter;
    private boolean noSpecial;
    private boolean noMinorStart;
    private boolean noMinorEnd;
    private boolean noPath;
    private boolean noPrice;
    private boolean noStop;

    public SearchRequest() {
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setoPos(Position oPos) {
        this.oPos = oPos;
    }

    public void setdPos(Position dPos) {
        this.dPos = dPos;
    }

    public void setoKind(String oKind) {
        this.oKind = oKind;
    }

    public void setdKind(String dKind) {
        this.dKind = dKind;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNoAir(boolean noAir) {
        this.noAir = noAir;
    }

    public void setNoRail(boolean noRail) {
        this.noRail = noRail;
    }

    public void setNoAirLeg(boolean noAirLeg) {
        this.noAirLeg = noAirLeg;
    }

    public void setNoBus(boolean noBus) {
        this.noBus = noBus;
    }

    public void setNoFerry(boolean noFerry) {
        this.noFerry = noFerry;
    }

    public void setNoCar(boolean noCar) {
        this.noCar = noCar;
    }

    public void setNoBikeshare(boolean noBikeshare) {
        this.noBikeshare = noBikeshare;
    }

    public void setNoRideshare(boolean noRideshare) {
        this.noRideshare = noRideshare;
    }

    public void setNoTowncar(boolean noTowncar) {
        this.noTowncar = noTowncar;
    }

    public void setNoCommuter(boolean noCommuter) {
        this.noCommuter = noCommuter;
    }

    public void setNoSpecial(boolean noSpecial) {
        this.noSpecial = noSpecial;
    }

    public void setNoMinorEnd(boolean noMinorEnd) {
        this.noMinorEnd = noMinorEnd;
    }

    public void setNoMinorStart(boolean noMinorStart) {
        this.noMinorStart = noMinorStart;
    }

    public void setNoPath(boolean noPath) {
        this.noPath = noPath;
    }

    public void setNoPrice(boolean noPrice) {
        this.noPrice = noPrice;
    }

    public void setNoStop(boolean noStop) {
        this.noStop = noStop;
    }
}
