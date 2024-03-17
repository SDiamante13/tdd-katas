package expensereport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Expenses implements Iterable<Expense> {

    private List<Expense> expenseList = new ArrayList<>();

    public Expenses(Expense... expenses) {
        expenseList.addAll(List.of(expenses));
    }

    int getMealExpenses() {
        return expenseList.stream()
                .filter(Expense::isMeal)
                .mapToInt(Expense::amount)
                .sum();
    }

    int calculateTotal() {
        return expenseList.stream()
                .mapToInt(Expense::amount)
                .sum();
    }

    @Override
    public Iterator iterator() {
        return expenseList.iterator();
    }
}
