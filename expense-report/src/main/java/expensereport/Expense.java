package expensereport;

public class Expense {

    private final ExpenseType type;
    private final int amount;

    public Expense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    boolean isOverLimit() {
        return amount > type.getLimit();
    }

    String getName() {
        return type.expenseName();
    }

    boolean isMeal() {
        return type.isMeal();
    }
}
