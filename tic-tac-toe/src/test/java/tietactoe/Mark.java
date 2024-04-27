package tietactoe;

enum Mark {
    X('X'), O('O');

    private char value;

    Mark(char value) {
        this.value = value;
    }

    public char value() {
        return this.value;
    }

    Mark rotate() {
        return equals(X) ? O : X;
    }
}
