package expensereport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


public class ExpenseReport {

    Logger log = LoggerFactory.getLogger(ExpenseReport.class);

    public void printReport(Expenses expenses) {
        printReport(expenses, new Date());
    }

    public void printReport(Expenses expenses, Date date) {
        log.info("Expenses " + date);

        for (Expense expense : expenses) {
            printSingleExpense(expense);
        }

        log.info("Meal expenses: " + expenses.getMealExpenses());
        log.info("Total expenses: " + expenses.calculateTotal());
    }

    private void printSingleExpense(Expense expense) {
        String mealOverExpensesMarker = expense.isOverLimit() ? "X" : " ";
        log.info(expense.getName() + "\t" + expense.amount() + "\t" + mealOverExpensesMarker);
    }
}
