package texasholdem;

public class Pot {

    private int amount;

    private Pot(int amount) {
        this.amount = amount;
    }

    public static Pot EMPTY() {
        return new Pot(0);
    }

    public int amount() {
        return this.amount;
    }

    public void add(int chips) {
        this.amount += chips;
    }
}
