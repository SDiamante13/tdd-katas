package tictactoe;

public record Player(String name, Mark mark) {

    @Override
    public String toString() {
        return "%s (%s)".formatted(name, mark);
    }
}
