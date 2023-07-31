package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {


    @CsvSource(delimiter = '|', value = {
            "''|0",
            "1|1",
            "2,0|2",
            "2,1|3",
            "2,1,2|5",
            "1\\n2,3|6"
    })
    @ParameterizedTest(name = "Adding {0} together yields {1}")
    void addStrings(String input, String expected) {
        StringCalculator calculator = new StringCalculator();

        String result = calculator.add(input);

        assertThat(result).isEqualTo(expected);
    }

}
