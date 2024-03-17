package expensereport;

import static java.lang.Integer.MAX_VALUE;

public enum ExpenseType {
    DINNER("Dinner", true, 5000),
    BREAKFAST("Breakfast", true, 1000),
    CAR_RENTAL("Car Rental", false, MAX_VALUE);

    private final String expenseName;
    private final boolean isMeal;
    private final int budgetThreshold;

    ExpenseType(String expenseName, boolean isMeal, int budgetThreshold) {
        this.expenseName = expenseName;
        this.isMeal = isMeal;
        this.budgetThreshold = budgetThreshold;
    }

    public String expenseName() {
        return expenseName;
    }

    int getLimit() {
        return budgetThreshold;
    }

    public boolean isMeal() {
        return isMeal;
    }
}
