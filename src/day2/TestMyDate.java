package day2;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate my_birth = new MyDate(22, 7, 1964);
        MyDate addDaysTest = my_birth.addDays(7);
        MyDate addMonthTest = addDaysTest.addMonths(2);
        MyDate addYearTest = addMonthTest.addYears(10);
        MyDate decDayTest = addYearTest.decDays(10);
        MyDate decMonthTest = decDayTest.decMonths(5);

        System.out.println(my_birth);
        System.out.println(addDaysTest);
        System.out.println(addMonthTest);
        System.out.println(addYearTest);
        System.out.println(decDayTest);
        System.out.println(decMonthTest);
    }

}
