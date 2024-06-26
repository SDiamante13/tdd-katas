package tictactoe;

public enum Mark {
    X('X'), O('O');

    private final char value;

    Mark(char value) {
        this.value = value;
    }

    char value() {
        return this.value;
    }

    Mark rotate() {
        return equals(X) ? O : X;
    }
}
