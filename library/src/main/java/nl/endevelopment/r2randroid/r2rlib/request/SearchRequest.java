package nl.endevelopment.r2randroid.r2rlib.request;

import nl.endevelopment.r2randroid.r2rlib.models.Position;

/**
 * Created by jan on 14/07/16.
 */

public class SearchRequest {
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

    private SearchRequest(SearchRequestBuilder builder) {
        this.oName = builder.oName;
        this.dName = builder.dName;
        this.oPos = builder.oPos;
        this.dPos = builder.dPos;
        this.oKind = builder.oKind;
        this.dKind = builder.dKind;
        this.currencyCode = builder.currencyCode;
        this.languageCode = builder.languageCode;
        this.data = builder.data;
        this.noAir = builder.noAir;
        this.noAirLeg = builder.noAirLeg;
        this.noRail = builder.noRail;
        this.noBus = builder.noBus;
        this.noFerry = builder.noFerry;
        this.noCar = builder.noCar;
        this.noBikeshare = builder.noBikeshare;
        this.noRideshare = builder.noRideshare;
        this.noTowncar = builder.noTowncar;
        this.noCommuter = builder.noCommuter;
        this.noSpecial = builder.noSpecial;
        this.noMinorStart = builder.noMinorStart;
        this.noMinorEnd = builder.noMinorEnd;
        this.noPath = builder.noPath;
        this.noPrice = builder.noPrice;
        this.noStop = builder.noStop;

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

    public void setnoAir(boolean noAir) {
        this.noAir = noAir;
    }

    public void setnoRail(boolean noRail) {
        this.noRail = noRail;
    }

    public void setnoAirLeg(boolean noAirLeg) {
        this.noAirLeg = noAirLeg;
    }

    public void setnoBus(boolean noBus) {
        this.noBus = noBus;
    }

    public void setnoFerry(boolean noFerry) {
        this.noFerry = noFerry;
    }

    public void setnoCar(boolean noCar) {
        this.noCar = noCar;
    }

    public void setnoBikeshare(boolean noBikeshare) {
        this.noBikeshare = noBikeshare;
    }

    public void setnoRideshare(boolean noRideshare) {
        this.noRideshare = noRideshare;
    }

    public void setnoTowncar(boolean noTowncar) {
        this.noTowncar = noTowncar;
    }

    public void setnoCommuter(boolean noCommuter) {
        this.noCommuter = noCommuter;
    }

    public void setnoSpecial(boolean noSpecial) {
        this.noSpecial = noSpecial;
    }

    public void setnoMinorEnd(boolean noMinorEnd) {
        this.noMinorEnd = noMinorEnd;
    }

    public void setnoMinorStart(boolean noMinorStart) {
        this.noMinorStart = noMinorStart;
    }

    public void setnoPath(boolean noPath) {
        this.noPath = noPath;
    }

    public void setnoPrice(boolean noPrice) {
        this.noPrice = noPrice;
    }

    public void setnoStop(boolean noStop) {
        this.noStop = noStop;
    }

    public String getoName() {
        return oName;
    }

    public String getdName() {
        return dName;
    }

    public Position getoPos() {
        return oPos;
    }

    public Position getdPos() {
        return dPos;
    }

    public String getoKind() {
        return oKind;
    }

    public String getdKind() {
        return dKind;
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

    public boolean isnoAir() {
        return noAir;
    }

    public boolean isnoAirLeg() {
        return noAirLeg;
    }

    public boolean isnoRail() {
        return noRail;
    }

    public boolean isnoBus() {
        return noBus;
    }

    public boolean isnoFerry() {
        return noFerry;
    }

    public boolean isnoCar() {
        return noCar;
    }

    public boolean isnoBikeshare() {
        return noBikeshare;
    }

    public boolean isnoRideshare() {
        return noRideshare;
    }

    public boolean isnoTowncar() {
        return noTowncar;
    }

    public boolean isnoCommuter() {
        return noCommuter;
    }

    public boolean isnoSpecial() {
        return noSpecial;
    }

    public boolean isnoMinorStart() {
        return noMinorStart;
    }

    public boolean isnoMinorEnd() {
        return noMinorEnd;
    }

    public boolean isnoPath() {
        return noPath;
    }

    public boolean isnoPrice() {
        return noPrice;
    }

    public boolean isnoStop() {
        return noStop;
    }


    /**
     * create the url with query params
     * dont make use of the retrofit query params because of the custom boolean params of rome2rio e.g. noAir
     *
     * @return url String
     */
    public String toUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search?");
        if (oName != null) sb.append("&oName=").append(oName);
        if (dName != null) sb.append("&dName=").append(dName);
        if (oPos != null)
            sb.append("&oPos=").append(oPos.getLatitude()).append(",").append(oPos.getLongitude());
        if (dPos != null)
            sb.append("&dPos=").append(dPos.getLatitude()).append(",").append(dPos.getLongitude());
        if (oKind != null) sb.append("&oKind=").append(oKind);
        if (dKind != null) sb.append("&dKind=").append(dKind);
        if (currencyCode != null) sb.append("&currencyCode=").append(currencyCode);
        if (languageCode != null) sb.append("&languageCode=").append(languageCode);
        if (data != null) sb.append("&data=").append(data);
        if (noAir) sb.append("&noAir");
        if (noAirLeg) sb.append("&noAirLeg");
        if (noRail) sb.append("&noRail");
        if (noBus) sb.append("&noBus");
        if (noFerry) sb.append("&noFerry");
        if (noCar) sb.append("&noCar");
        if (noBikeshare) sb.append("&noBikeshare");
        if (noRideshare) sb.append("&noRideshare");
        if (noTowncar) sb.append("&noTowncar");
        if (noCommuter) sb.append("&noCommuter");
        if (noSpecial) sb.append("&noSpecial");
        if (noMinorEnd) sb.append("&noMinorEnd");
        if (noPath) sb.append("&noPath");
        if (noPrice) sb.append("&noPrice");
        if (noStop) sb.append("&noStop");

        return sb.toString();
    }


    public static class SearchRequestBuilder {
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

        public SearchRequestBuilder oName(String oName) {
            this.oName = oName;
            return this;
        }

        public SearchRequestBuilder dName(String dName) {
            this.dName = dName;
            return this;
        }

        public SearchRequestBuilder oPos(Position oPos) {
            this.oPos = oPos;
            return this;
        }

        public SearchRequestBuilder dPos(Position dPos) {
            this.dPos = dPos;
            return this;
        }

        public SearchRequestBuilder oKind(String oKind) {
            this.oKind = oKind;
            return this;
        }

        public SearchRequestBuilder dKind(String dKind) {
            this.dKind = dKind;
            return this;
        }

        public SearchRequestBuilder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public SearchRequestBuilder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public SearchRequestBuilder data(String data) {
            this.data = data;
            return this;
        }

        public SearchRequestBuilder noAir() {
            this.noAir = noAir;
            return this;
        }

        public SearchRequestBuilder noAirLeg() {
            this.noAirLeg = noAirLeg;
            return this;
        }

        public SearchRequestBuilder noRail() {
            this.noRail = noRail;
            return this;
        }

        public SearchRequestBuilder noBus() {
            this.noBus = true;
            return this;
        }

        public SearchRequestBuilder noFerry(boolean noFerry) {
            this.noFerry = true;
            return this;
        }

        public SearchRequestBuilder noCar() {
            this.noCar = true;
            return this;
        }

        public SearchRequestBuilder noBikeshare() {
            this.noBikeshare = true;
            return this;
        }

        public SearchRequestBuilder noRideshare() {
            this.noRideshare = true;
            return this;
        }

        public SearchRequestBuilder noTowncar() {
            this.noTowncar = true;
            return this;
        }

        public SearchRequestBuilder noCommuter() {
            this.noCommuter = true;
            return this;
        }

        public SearchRequestBuilder noSpecial() {
            this.noSpecial = true;
            return this;
        }

        public SearchRequestBuilder noMinorStart() {
            this.noMinorStart = true;
            return this;
        }

        public SearchRequestBuilder noMinorEnd() {
            this.noMinorEnd = true;
            return this;
        }

        public SearchRequestBuilder noPath() {
            this.noPath = true;
            return this;
        }

        public SearchRequestBuilder noPrice() {
            this.noPrice = true;
            return this;
        }

        public SearchRequestBuilder noStop() {
            this.noStop = true;
            return this;
        }

        public SearchRequest build() {
            return new SearchRequest(this);
        }
    }
}
