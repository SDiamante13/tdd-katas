package tech.pathtoprogramming.romannumerals;

public class Converter {

    public int convertToDecimal(String romanNumeral) {
        int total = 0;
        for (char romanLetter : romanNumeral.toCharArray()) {
            total += convertLetterToDecimal(romanLetter);
        }
        return total;
    }

    private int convertLetterToDecimal(char romanNumeral) {
        if (romanNumeral == 'I') {
            return 1;
        } else if (romanNumeral == 'V') {
            return 5;
        } else if (romanNumeral == 'X') {
            return 10;
        } else if (romanNumeral == 'L') {
            return 50;
        } else if (romanNumeral == 'C') {
            return 100;
        } else if (romanNumeral == 'D') {
            return 500;
        } else if (romanNumeral == 'M') {
            return 1000;
        }
        return 0;
    }
}
