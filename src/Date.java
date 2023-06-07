/**
 * This class represents a date in the Gregorian calendar.
 */
public class Date {
    private int year;
    private int month;
    private int day;

    /**
     * Constructor
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    public Date(int year, int month, int day) {
        if (-4000 < year && year < 4000) {
            this.year = year;
        } else
            this.year = 0;
        if (0 < month && month < 13) {
            this.month = month;
        } else
            this.month = 1;
        if (0 < day && day < 32) {
            this.day = day;
        } else
            this.day = 1;
    }

    /**
     * override the toString method
     *
     * @return the date in the format of dd/mm/yyyy
     */
    public String toString() {
        String newString = "";
        newString+=String.format("%02d", day)+"/"+String.format("%02d", month)+"/"+String.format("%04d", year);
        return newString;
    }

    /**
     * set the month
     *
     * @param month the month
     */

    public void setMonth(int month) {
        if (0 < month && month < 13) {
            this.month = month;
        } else {
            this.month = 1;
        }
    }

    /**
     * set the day
     *
     * @param day the day
     */
    public void setDay(int day) {
        if (0 < day && day < 32) {
            this.day = day;
        } else {
            this.day = 1;
        }
    }
    /**
     * set the year
     *
     * @param year the year
     */
    public void setYear(int year) {
        if (-4000 < year && year < 4000) {
            this.year = year;
        } else {
            this.year = 0;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * check if the date is equal to the other date
     *
     * @param o the other date
     * @return true if the date is equal to the other date
     */
    public boolean equals(Object o) {
        if (!(o instanceof Date))//type check
            return false;
        if (o == this)//reflexive
            return true;
        if(o.hashCode() != this.hashCode())//if the hashcode is not the same, return false
            return false;
        Date other = (Date) o;
        if (this.year == other.getYear() && this.month == other.getMonth() && this.day == other.getDay()) {//simtric
            return true;
        } else
            return false;
    }

    /**
     * override the hashCode method
     *
     * @return the hashcode of the date
     */
    @Override
    public int hashCode() {
        int result = this.year;
        result = 51 * result + this.month;
        result = 51 * result + this.day;
        return result;
    }
}
