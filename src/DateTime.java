/**
 * DateTime class
 */

public class DateTime extends Date {
    private int hour;
    private int minute;

    /**
     * Constructor
     *
     * @param year   the year
     * @param month  the month
     * @param day    the day
     * @param hour   the hour
     * @param minute the minute
     */
    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if (0 <= hour && hour < 24) {
            this.hour = hour;
        } else
            this.hour = 0;
        if (0 <= minute && minute < 60) {
            this.minute = minute;
        } else
            this.minute = 0;
    }


    /**
     * override the toString method
     *
     * @return the date in the format of dd/mm/yyyy
     */
    public String toString() {
        return super.toString() + " " + String.format("%02d", this.hour) + ":" + String.format("%02d", this.minute);
    }

    /**
     * set the hour
     *
     * @param hour the hour
     */
    public void setHour(int hour) {
        if (0 <= hour && hour < 24) {
            this.hour = hour;
        }
    }

    /**
     * set the minute
     *
     * @param minute the minute
     */
    public void setMinute(int minute) {
        if (0 <= minute && minute < 60) {
            this.minute = minute;
        }
    }

    /**
     * set the year
     *
     * @param month the year
     */
    public void setMonth(int month) {
        super.setMonth(month);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    /**
     * check if the DateTime is equal to the other date
     *
     * @param o the other date
     * @return true if the date is equal to the other date
     */
    public boolean equals(Object o) {
        if (!(o instanceof DateTime))//if the object is not a date
            return false;
        if (o == this)//if the object is the same object in memory
            return true;
        if (o.hashCode() != this.hashCode())//if the hashcode is not the same, return false
            return false;
        DateTime other = (DateTime) o;
        if (super.equals((Date) o) && this.hour == other.getHour() && this.minute == other.getMinute())//if the date is equal and the time is equal
            return true;
        else
            return false;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 51 * result + this.minute;
        result = 51 * result + this.hour;
        return result;
    }

}