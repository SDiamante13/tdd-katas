package tech.pathtoprogramming.humanreadabletime;

public class TimeConverter {

    private TimeConverter() {
    }

    public static String beautifyTime(int seconds) {
        validateInput(seconds);
        return String.format("%02d:%02d:%02d",
                seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

    private static void validateInput(int seconds) {
        if (seconds > 359999 || seconds < 0) {
            throw new IllegalArgumentException(
                    "The input of " + seconds +
                            " is not an acceptable input. (Max: 359999 Min: 0)"
            );
        }
    }
}
