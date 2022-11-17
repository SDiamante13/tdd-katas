package texasholdem;

public class Pot {
    private int amount;

    public Pot() {
        this.amount = 0;
    }

    public int amount() {
        return this.amount;
    }

    public void add(int chips) {
        this.amount += chips;
    }
}
