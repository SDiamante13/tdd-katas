package tech.pathtotprogramming.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tech.pathtoprogramming.romannumerals.Converter;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    private final Converter converter = new Converter();

    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "4,IV",
            "5,V",
            "7,VII",
            "10,X",
            "12,XII",
            "18,XVIII",
            "30,XXX",
            "2687,MMDCLXXXVII"
    })
    void convertToRomanNumeral_returnsRomanNumeral_whenValidInputIsProvided(int input, String expected) {
        String result = converter.convertToRomanNumeral(input);

        assertThat(result).isEqualTo(expected);
    }
}
