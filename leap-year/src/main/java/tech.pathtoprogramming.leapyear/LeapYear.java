package tech.pathtoprogramming.leapyear;

public class LeapYear {

    public boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
