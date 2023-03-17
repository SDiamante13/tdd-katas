package texasholdem;

class Choice {

    public static final String CHECK = "C";
    public static final String BET = "B";
    public static final String FOLD = "F";

    private final String value;
    private final int amount;

    public Choice(String value) {
        this.value = value;
        this.amount = 0;
    }

    public Choice(String value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    public static Choice check() {
        return new Choice("C");
    }

    public static Choice bet(int amount) {
        return new Choice("B", amount);
    }

    public static Choice fold() {
        return new Choice("F");
    }

    public String value() {
        return value;
    }

    public int amount() {
        return amount;
    }

    boolean choseToFold() {
        return value.equals("F");
    }
}
