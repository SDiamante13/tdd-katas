package tech.pathtoprogramming.leapyear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest {

    private final LeapYear leapYear = new LeapYear();

    @Test
    void isLeapYear_shouldReturnTrue_whenYearIsDivisibleByFour() {
        // Arrange
        boolean expected = true;

        // Act
        boolean result = leapYear.isLeapYear(1996);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void isLeapYear_shouldReturnFalse_whenYearIsNotDivisibleByFour() {
        // Arrange
        boolean expected = false;

        // Act
        boolean result = leapYear.isLeapYear(1999);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void isLeapYear_shouldReturnFalse_whenYearIsDivisbleByHundred_butNotDivisbleByFourHundred() {
        // Arrange
        boolean expected = false;

        // Act
        boolean result = leapYear.isLeapYear(2100);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void isLeapYear_shouldReturnTrue_whenYearIsDivisibleByFourHundred() {
        // Arrange
        boolean expected = true;

        // Act
        boolean result = leapYear.isLeapYear(2000);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
