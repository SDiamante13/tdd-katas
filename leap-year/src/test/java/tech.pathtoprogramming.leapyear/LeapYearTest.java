package tech.pathtoprogramming.leapyear;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeapYearTest {

    @Test
    void isNotALeapYearWhenYearIsNotDivisibleByFour() {
        assertThat(new Year(2001).isLeapYear())
                .isFalse();
    }

    @Test
    void isLeapYearWhenYearIsDivisibleByFour() {
        assertThat(new Year(1996).isLeapYear())
                .isTrue();
        assertThat(new Year(1992).isLeapYear())
                .isTrue();
    }

    @Test
    void isNotALeapYearWhenYearIsDivisibleByOneHundred() {
        assertThat(new Year(1900).isLeapYear()).isFalse();
    }

    @Test
    void isALeapYearWhenYearIsDivisibleByFourHundred() {
        assertThat(new Year(2000).isLeapYear()).isTrue();
    }
}

class Year {

    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        return isDivisibleBy(4) &&
                isNotOtherwiseDivisibleBy100UnlessItIsAlsoDivisibleBy400();
    }

    private boolean isNotOtherwiseDivisibleBy100UnlessItIsAlsoDivisibleBy400() {
        return isNotDivisibleBy(100) || isDivisibleBy(400);
    }

    private boolean isDivisibleBy(int number) {
        return year % number == 0;
    }

    private boolean isNotDivisibleBy(int number) {
        return !isDivisibleBy(number);
    }
}
