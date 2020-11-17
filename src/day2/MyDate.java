package day2;

public class MyDate {
    private int day = 1;
    private int month = 1;
    private int year = 2000;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(MyDate date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate addDays(int moreDays) {
        MyDate newDate = new MyDate(this);
        newDate.day = newDate.day + moreDays;
        // Not Yet Implemented: wrap around code...
        return newDate;
    }

    public MyDate addMonths(int moreMonths) {
        MyDate newMonth = new MyDate(this);
        newMonth.month = newMonth.month + moreMonths;
        // Not Yet Implemented: wrap around code...
        return newMonth;
    }

    public MyDate decDays(int moreDays) {
        MyDate newDate = new MyDate(this);
        newDate.day = newDate.day - moreDays;
        // Not Yet Implemented: wrap around code...
        return newDate;
    }

    public MyDate decMonths(int moreMonths) {
        MyDate newMonth = new MyDate(this);
        newMonth.month = newMonth.month - moreMonths;
        // Not Yet Implemented: wrap around code...
        return newMonth;
    }

    public MyDate addYears(int moreYears) {
        MyDate newYear = new MyDate(this);
        newYear.year = newYear.year + moreYears;
        // Not Yet Implemented: wrap around code...
        return newYear;
    }

    public String toString() {
        String retString = "" + day + "-" + month + "-" + year;
        return retString;
    }


}
