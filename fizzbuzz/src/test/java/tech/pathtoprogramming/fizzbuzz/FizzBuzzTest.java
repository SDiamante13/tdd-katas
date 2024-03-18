package tech.pathtoprogramming.fizzbuzz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FizzBuzzTest {

//    But for multiples of three print “Fizz” instead of the number and for
//    the multiples of five print “Buzz”. For numbers which are multiples
//    of both three and five print “FizzBuzz “.

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void calculate_shouldReturnFizz_whenNumberIsAMultipleOfThree() {
        // Arrange
        String expected = "Fizz";

        // Act
        String result = fizzBuzz.calculate(9);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculate_shouldReturnBuzz_whenNumberIsAMultipleOfFive() {
        // Arrange
        String expected = "Buzz";

        // Act
        String result = fizzBuzz.calculate(10);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculate_shouldReturnFizzBuzz_whenNumberIsAMultipleOfThreeAndFive() {
        // Arrange
        String expected = "FizzBuzz";

        // Act
        String result = fizzBuzz.calculate(15);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculate_shouldReturnTheNumber_whenNumberIsANotAMultipleOfThreeOrFive() {
        // Arrange
        String expected = "4";

        // Act
        String result = fizzBuzz.calculate(4);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculate_shouldReturnTheFizz_whenNumberIsAMultipleOfThree_butIsNegative() {
        // Arrange
        String expected = "Fizz";

        // Act
        String result = fizzBuzz.calculate(-27);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
