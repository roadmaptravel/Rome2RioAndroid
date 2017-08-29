package com.getroadmap.r2rlib.enums;

/**
 * Created by jan on 29/08/2017.
 * <p>
 * unknown, plane, helicopter, car, bus, taxi, rideshare, shuttle, towncar,
 * train, tram, cablecar, subway, ferry, foot, animal, bicycle
 */

public enum VehicleKind {
    UNKNOWN("unknown"),
    PLANE("plane"),
    HELICOPTER("helicopter"),
    CAR("car"),
    BUS("bus"),
    TAXI("taxi"),
    RIDESHARE("rideshare"),
    SHUTTLE("shuttle"),
    TOWNCAR("towncar"),
    TRAIN("train"),
    TRAM("tram"),
    CABLECAR("cablecar"),
    SUBWAY("subway"),
    FERRY("ferry"),
    FOOT("foot"),
    ANIMAL("animal"),
    BICYCLE("bicycle");


    String type;

    VehicleKind(String s) {
        type = s;
    }

    public String getType() {
        return type;
    }

    public static VehicleKind fromString(String text) {
        for (VehicleKind vehicleKind : VehicleKind.values()) {
            if (vehicleKind.getType().equalsIgnoreCase(text)) {
                return vehicleKind;
            }
        }
        return UNKNOWN;
    }
}
