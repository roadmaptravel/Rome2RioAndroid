package nl.endevelopment.r2randroid.r2rlib.enums;

/**
 * Created by jan on 29/08/2017.
 * <p>
 * unknown, continent, country, admin3, admin2, admin1, island, village, town, city,
 * capital, landmark, place, road, accomodation, station, airport, seaport, sea, lake and river
 */

public enum PlaceKind {
    UNKNOWN("unknown"),
    CONTINENT("continent"),
    COUNTRY("country"),
    ADMIN3("admin3"),
    ADMIN2("admin2"),
    ADMIN1("admin1"),
    ISLAND("island"),
    VILLAGE("village"),
    TOWN("town"),
    CAPITAL("capital"),
    LANDMARK("landmark"),
    PLACE("place"),
    ROAD("road"),
    ACCOMODATION("accomodation"),
    STATION("station"),
    AIRPORT("airport"),
    SEAPORT("seaport"),
    SEA("sea"),
    LAKE("lake"),
    RIVER("river");


    private String type;

    PlaceKind(String s) {
        type = s;
    }

    public String getType() {
        return type;
    }

    public static PlaceKind fromString(String text) {
        for (PlaceKind p : PlaceKind.values()) {
            if (p.getType().equalsIgnoreCase(text)) {
                return p;
            }
        }
        return UNKNOWN;
    }
}
