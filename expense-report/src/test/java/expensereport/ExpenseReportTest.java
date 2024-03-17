package expensereport;

import org.approvaltests.ApprovalUtilities;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

@UseReporter(QuietReporter.class)
class ExpenseReportTest {

    @Test
    void printReport() {
        ByteArrayOutputStream output = new ApprovalUtilities().writeSystemOutToStringBuffer();
        List<Expense> expenses = List.of(
                new Expense(ExpenseType.DINNER, 100),
                new Expense(ExpenseType.BREAKFAST, 40),
                new Expense(ExpenseType.CAR_RENTAL, 250),
                new Expense(ExpenseType.DINNER, 5001),
                new Expense(ExpenseType.BREAKFAST, 1001)
        );
        new ExpenseReport().printReport(expenses, new Date(0));

        Approvals.verify(output);
    }
}
