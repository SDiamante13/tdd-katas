package tech.pathtotprogramming.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralTest {

    @ParameterizedTest(name = "{0} converts to {1}")
    @CsvSource({
            "1,I",
            "2,II",
            "3,III",
            "5,V",
            "7,VII",
            "10,X",
            "12,XII",
            "18,XVIII",
            "30,XXX",
            "4,IV",
            "99,XCIX",
            "4942,MMMMXMXLII"
    })
    void arabicToRomanNumeralConversion(int decimal, String expectedRomanNumeral) {
        assertThat(RomanNumeral.convert(decimal)).isEqualTo(expectedRomanNumeral);
    }


}

class RomanNumeral {
    public static String convert(int decimal) {
        StringBuilder roman = new StringBuilder();

        for (DecimalToRomanNumeral decimalToRomanNumeral : DecimalToRomanNumeral.values()) {
            while (decimal >= decimalToRomanNumeral.decimal()) {
                roman.append(decimalToRomanNumeral.romanNumeral());
                decimal -= decimalToRomanNumeral.decimal();
            }
        }

        return roman.toString();
    }
}

enum DecimalToRomanNumeral {
    ONE_THOUSAND(1000, "M"),
    NINE_HUNDRED(900, "XM"),
    FIVE_HUNDRED(500, "D"),
    FOUR_HUNDRED(400, "XD"),
    ONE_HUNDRED(100, "C"),
    NINETY(90, "XC"),
    FIFTY(50, "L"),
    FORTY(40, "XL"),
    TEN(10, "X"),
    NINE(9, "IX"),
    FIVE(5, "V"),
    FOUR(4, "IV"),
    ONE(1,"I");

    private final int decimal;
    private final String romanNumeral;

    DecimalToRomanNumeral(int decimal, String romanNumeral) {
        this.decimal = decimal;
        this.romanNumeral = romanNumeral;
    }

    public int decimal() {
        return decimal;
    }

    public String romanNumeral() {
        return romanNumeral;
    }
}
