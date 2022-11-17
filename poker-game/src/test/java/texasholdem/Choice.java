package texasholdem;

class Choice {

    public static final String CHECK_VALUE = "C";
    public static final String BET_VALUE = "B";
    public static final String FOLD_VALUE = "F";

    private String value;
    private int amount;

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

    public void setValue(String value) {
        this.value = value;
    }

    public int amount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
