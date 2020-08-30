package tech.pathtoprogramming.leapyear;

import net.jqwik.api.*;
import org.assertj.core.api.Assertions;


public class LeapYearPropertyBasedTest {

    private final LeapYear leapYear = new LeapYear();

    @Provide("leap years")
    Arbitrary<Integer> numbers() {
        return Arbitraries.integers().between(1993, 1995);
    }

    @Property
    void leapYear(@ForAll("leap years") int year) {
        Assertions.assertThat(leapYear.isLeapYear(year)).isFalse();
    }
}
