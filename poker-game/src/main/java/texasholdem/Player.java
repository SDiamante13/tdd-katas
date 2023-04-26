package texasholdem;

public interface Player {
    Choice choice();

    default boolean didNotFold() {
        return !choice().equals(Choice.FOLD);
    }
}
