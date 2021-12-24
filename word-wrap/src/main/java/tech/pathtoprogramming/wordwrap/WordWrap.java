package tech.pathtoprogramming.wordwrap;

public class WordWrap {

    public static String wrap(String input, int columnLength) {
        if (input == null || input.length() < 1) {
            return "";
        }

        if (input.split(" ")[0].length() < columnLength) {
            return input.replace(" ", "\n");
        }

        return input;
    }
}
