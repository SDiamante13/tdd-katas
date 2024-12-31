package tech.pathtotprogramming.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ArabicToRomanNumeralConverterTest {

    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "3,III",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "10,X",
            "13,XIII",
            "20,XX",
    })
    void convertArabicToRoman(int arabic, String expectedRomanNumeral) {
        var arabicToRomanConverter = new ArabicToRomanNumeralConverter();
        String roman = arabicToRomanConverter.convert(arabic);
        assertThat(roman).isEqualTo(expectedRomanNumeral);
    }
}
