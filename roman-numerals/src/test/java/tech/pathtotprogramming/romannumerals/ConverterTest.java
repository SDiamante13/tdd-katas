package tech.pathtotprogramming.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tech.pathtoprogramming.romannumerals.Converter;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    private final Converter converter = new Converter();

    @ParameterizedTest
    @CsvSource({
            "I,1",
            "V,5",
            "X,10",
            "L,50",
            "C,100",
            "D,500",
            "M,1000",
            "II,2",
            "MCCCXXXVII,1337"
    })
    void canConvertRomanNumeralToDecimal(String input, int expected) {
        int result = converter.convertToDecimal(input);

        assertThat(result).isEqualTo(expected);
    }
}
