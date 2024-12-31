package tech.pathtotprogramming.romannumerals;

public class ArabicToRomanNumeralConverter {
    public String convert(int arabic) {
        String result = "";

        for (ArabicToRoman atr : ArabicToRoman.values()) {
            while (arabic >= atr.arabic()) {
                result += atr.romanNumeral();
                arabic -= atr.arabic();
            }
        }

        return result;
    }
}

enum ArabicToRoman {
    THOUSAND(1000, "M"),
    NINE_HUNDRED(900, "CM"),
    FIVE_HUNDRED(500, "D"),
    FOUR_HUNDRED(400, "CD"),
    HUNDRED(100, "C"),
    NINETY(90, "XC"),
    FIFTY(50, "L"),
    FORTY(40, "XL"),
    TEN(10, "X"),
    NINE(9, "IX"),
    FIVE(5, "V"),
    FOUR(4, "IV"),
    ONE(1, "I");

    private final int arabic;
    private final String romanNumeral;

    ArabicToRoman(int arabic, String romanNumeral) {
        this.arabic = arabic;
        this.romanNumeral = romanNumeral;
    }

    public int arabic() {
        return this.arabic;
    }

    public String romanNumeral() {
        return romanNumeral;
    }
}
