import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {


//    - The method can take 0, 1 or 2 numbers separated by comma, and returns their sum.
//            - Example of inputs: "", "1", "1.1,2.2".


    @CsvSource(delimiter = '|', value = {
            "''|0",
            "1|1",
            "2,0|2",
            "2,1|3",
    })
    @ParameterizedTest
    void emptyStringReturnsZero(String input, String expected) {
        StringCalculator calculator = new StringCalculator();

        String result = calculator.add(input);

        assertThat(result).isEqualTo(expected);
    }

    private class StringCalculator {

        public String add(String numbers) {
            if (numbers.isEmpty()) {
                return "0";
            }
            if (numbers.length() == 1) {
                return numbers;
            }
            return calculateSumOf(numbers);
        }

        private String calculateSumOf(String numbers) {
            String[] numbersArray = numbers.split(",");
            return sum(numbersArray[0], numbersArray[1]);
        }

        private String sum(String firstNumber, String secondNumber) {
            int sum = covertToInteger(firstNumber) + covertToInteger(secondNumber);
            return String.valueOf(sum);
        }

        private int covertToInteger(String firstNumber) {
            return Integer.parseInt(firstNumber);
        }
    }
}
