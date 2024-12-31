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
            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "9,IX",
            "10,X",
            "13,XIII",
            "15,XV",
            "19,XIX",
            "30,XXX",
            "40,XL",
            "50,L",
            "90,XC",
            "100,C",
            "400,CD",
            "500,D",
            "900,CM",
            "1000,M",
            "1999,MCMXCIX",
    })
    void convertArabicToRoman(int arabic, String expectedRomanNumeral) {
        var arabicToRomanConverter = new ArabicToRomanNumeralConverter();
        String roman = arabicToRomanConverter.convert(arabic);
        assertThat(roman).isEqualTo(expectedRomanNumeral);
    }
}
