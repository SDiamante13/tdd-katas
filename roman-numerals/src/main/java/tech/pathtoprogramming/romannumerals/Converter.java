package tech.pathtoprogramming.romannumerals;

public class Converter {
    public String convertToRomanNumeral(int decimal) {
        String roman = "";

        for (RomanToDecimal romanToDecimal : RomanToDecimal.values()) {
            while (decimal >= romanToDecimal.decimal) {
                roman += romanToDecimal.roman;
                decimal -= romanToDecimal.decimal;
            }
        }

        return roman;
    }

    enum RomanToDecimal {
        THOUSAND("M", 1000),
        NINE_HUNDRED("CM", 900),
        FIVE_HUNDRED("D", 500),
        FOUR_HUNDRED("CD", 400),
        HUNDRED("C", 100),
        NINETY("XC", 90),
        FIFTY("L", 50),
        FORTY("XL", 40),
        TEN("X", 10),
        NINE("X", 9),
        FIVE("V", 5),
        FOUR("IV", 4),
        ONE("I", 1);

        private final String roman;
        private final int decimal;

        RomanToDecimal(String roman, int decimal) {
            this.roman = roman;
            this.decimal = decimal;
        }
    }
}
