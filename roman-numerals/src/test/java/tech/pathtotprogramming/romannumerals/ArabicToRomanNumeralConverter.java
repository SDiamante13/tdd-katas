package tech.pathtotprogramming.romannumerals;

public class ArabicToRomanNumeralConverter {
    public String convert(int arabic) {
        String result = "";
        while (arabic >= 10) {
            result += "X";
            arabic -= 10;
        }
        while (arabic >= 5) {
            result += "V";
            arabic -= 5;
        }
        while (arabic >= 1) {
            result += "I";
            arabic -= 1;
        }
        return result;
    }
}
