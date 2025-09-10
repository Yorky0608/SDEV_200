import java.util.Calendar;
import java.util.GregorianCalendar;

public class assignment_10_14 {

    /** Creates one MyDate class that is a no-arg constructor
     * The other takes the elapsed time and converts it to year, month, day
     */
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);
        System.out.printf("Date 1: %d-%d-%d\n", date1.getYear(), date1.getMonth(), date1.getDay());
        System.out.printf("Date 2: %d-%d-%d\n", date2.getYear(), date2.getMonth(), date2.getDay());
    }
}


class MyDate {
    
    private int year;
    private int month; // 0-based
    private int day;

    // No-arg constructor: current date
    public MyDate() {
        setDate(System.currentTimeMillis());
    }

    // Constructor with elapsed time
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Constructor with year, month, day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getters
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    // setDate method
    public void setDate(long elapsedTime) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH);
        this.day = cal.get(Calendar.DAY_OF_MONTH);
    }
}