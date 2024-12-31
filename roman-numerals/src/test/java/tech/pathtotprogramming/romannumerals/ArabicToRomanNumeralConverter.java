package tech.pathtotprogramming.romannumerals;

public class ArabicToRomanNumeralConverter {
    public String convert(int arabic) {
        String result = "";
        while (arabic >= 10) {
            result += "X";
            arabic -= 10;
        }
        if (arabic >= 5) {
            result = "V";
            arabic -= 5;
        }
        return result + "I".repeat(arabic);
    }
}
