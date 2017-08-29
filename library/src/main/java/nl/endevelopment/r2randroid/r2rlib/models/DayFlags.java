package nl.endevelopment.r2randroid.r2rlib.models;

/**
 * Created by jan on 11/07/16.
 */

public class DayFlags {
    public static final int SUNDAY = 1;
    public static final int MONDAY = 2;
    public static final int TUESDAY = 4;
    public static final int WEDNESDAY = 8;
    public static final int THURSDAY = 16;
    public static final int FRIDAY = 32;
    public static final int SATURDAY = 64;

    public static final int EVERYDAY = SUNDAY + MONDAY + TUESDAY + WEDNESDAY + THURSDAY + FRIDAY + SATURDAY;
    public static final int WEEKENDS = SATURDAY + SUNDAY;
    public static final int WEEKDAYS = MONDAY + TUESDAY + WEDNESDAY + THURSDAY + FRIDAY;
    public static final int NEVER = 0;


    private int flag;

    public DayFlags(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


    /**
     * is given day flagged
     * use static integer from this class
     * @param day static int above
     * @return boolean
     */
    public boolean isDay(int day) {
        return (flag & day) == day;
    }


    @Override
    public String toString() {
        return "DayFlags{" +
                "flag=" + flag +
                '}';
    }
}
