package com.getroadmap.r2rlib.models

/**
 * Created by jan on 11/07/16.
 */

class DayFlags(var flag: Int) {


    /**
     * is given day flagged
     * use static integer from this class
     * @param day static int above
     * @return boolean
     */
    fun isDay(day: Int): Boolean {
        return flag and day == day
    }


    override fun toString(): String {
        return "DayFlags{" +
                "flag=" + flag +
                '}'.toString()
    }

    companion object {
        @JvmField val SUNDAY = 1
        @JvmField val MONDAY = 2
        @JvmField val TUESDAY = 4
        @JvmField val WEDNESDAY = 8
        @JvmField val THURSDAY = 16
        @JvmField val FRIDAY = 32
        @JvmField val SATURDAY = 64

        @JvmField val EVERYDAY = SUNDAY + MONDAY + TUESDAY + WEDNESDAY + THURSDAY + FRIDAY + SATURDAY
        @JvmField val WEEKENDS = SATURDAY + SUNDAY
        @JvmField val WEEKDAYS = MONDAY + TUESDAY + WEDNESDAY + THURSDAY + FRIDAY
        @JvmField val NEVER = 0
    }
}
