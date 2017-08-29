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
        DayFlags dayFlags = new DayFlags(DayFlags.SUNDAY);

        assertThat(dayFlags.isDay(DayFlags.SUNDAY), is(true));
    }

    @Test
    public void isWeekday() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.WEEKDAYS);

        assertThat(dayFlags.isDay(DayFlags.FRIDAY), is(true));
    }

    @Test
    public void isNotWeekday() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.WEEKDAYS);

        assertThat(dayFlags.isDay(DayFlags.SUNDAY), is(false));
    }

    @Test
    public void isWeekend() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.WEEKENDS);

        assertThat(dayFlags.isDay(DayFlags.SATURDAY), is(true));
    }

    @Test
    public void isNotWeekend() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.WEEKENDS);

        assertThat(dayFlags.isDay(DayFlags.THURSDAY), is(false));
    }

    @Test
    public void isAlways() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.EVERYDAY);

        assertThat(dayFlags.isDay(DayFlags.SATURDAY), is(true));
    }

    @Test
    public void isAlwaysWeekend() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.EVERYDAY);

        assertThat(dayFlags.isDay(DayFlags.WEEKENDS), is(true));
    }

    @Test
    public void isNever() throws Exception {
        DayFlags dayFlags = new DayFlags(DayFlags.NEVER);

        assertThat(dayFlags.isDay(DayFlags.SATURDAY), is(false));
    }

}