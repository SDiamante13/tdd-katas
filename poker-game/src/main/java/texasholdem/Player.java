package texasholdem;

public interface Player {

    Choice choice(); // could be queue?

    default boolean didNotFold() {
        return !choice().equals(Choice.FOLD);
    }
}
