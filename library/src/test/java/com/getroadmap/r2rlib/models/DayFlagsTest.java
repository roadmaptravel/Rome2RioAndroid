package com.getroadmap.r2rlib.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jan on 28/08/2017.
 * test dayflag bitwise and operator
 */

public class DayFlagsTest {
    @Test
    public void isSunday() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getSUNDAY());

        assertThat(dayFlags.isDay(DayFlags.Companion.getSUNDAY()), is(true));
    }

    @Test
    public void isWeekday() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getWEEKDAYS());

        assertThat(dayFlags.isDay(DayFlags.Companion.getFRIDAY()), is(true));
    }

    @Test
    public void isNotWeekday() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getWEEKDAYS());

        assertThat(dayFlags.isDay(DayFlags.Companion.getSUNDAY()), is(false));
    }

    @Test
    public void isWeekend() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getWEEKENDS());

        assertThat(dayFlags.isDay(DayFlags.Companion.getSATURDAY()), is(true));
    }

    @Test
    public void isNotWeekend() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getWEEKENDS());

        assertThat(dayFlags.isDay(DayFlags.Companion.getTHURSDAY()), is(false));
    }

    @Test
    public void isAlways() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getEVERYDAY());

        assertThat(dayFlags.isDay(DayFlags.Companion.getSATURDAY()), is(true));
    }

    @Test
    public void isAlwaysWeekend() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getEVERYDAY());

        assertThat(dayFlags.isDay(DayFlags.Companion.getWEEKENDS()), is(true));
    }

    @Test
    public void isNever() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.Companion.getNEVER());

        assertThat(dayFlags.isDay(DayFlags.Companion.getSATURDAY()), is(false));
    }

}