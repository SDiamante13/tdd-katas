package tech.pathtoprogramming.leapyear;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.leapyear.LeapYear.isLeapYear;

class LeapYearTest {

    @Test
    void typicalCommonYearReturnsFalse() {
        assertThat(isLeapYear(2001)).isFalse();
    }

    @Test
    void atypicalCommonYearReturnsFalse() {
        assertThat(isLeapYear(1900)).isFalse();
    }

    @Test
    void typicalLeapYearReturnsTrue() {
        assertThat(isLeapYear(1996)).isTrue();
    }

    @Test
    void anotherTypicalLeapYearReturnsTrue() {
        assertThat(isLeapYear(1992)).isTrue();
    }

    @Test
    void atypicalLeapYearReturnsTrue() {
        assertThat(isLeapYear(2000)).isTrue();
    }
}

class LeapYear {

    public static boolean isLeapYear(int year) {
        return isDivisibleBy(year, 4) && (isNotDivisibleBy(year, 100) || isDivisibleBy(year, 400));
    }

    private static boolean isNotDivisibleBy(int year, int number) {
        return year % number != 0;
    }

    private static boolean isDivisibleBy(int year, int number) {
        return year % number == 0;
    }
}
