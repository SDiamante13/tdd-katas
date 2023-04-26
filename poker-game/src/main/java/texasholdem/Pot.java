package texasholdem;

public class Pot {

    private int chips;

    public Pot(int chips) {
        this.chips = chips;
    }

    public Pot() {
        this.chips = 0;
    }

    public int chips() {
        return chips;
    }
}
