package expensereport;

import nl.altindag.log.LogCaptor;
import org.approvaltests.ApprovalUtilities;
import org.approvaltests.Approvals;
import org.approvaltests.approvers.ApprovalApprover;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

@UseReporter(QuietReporter.class)
class ExpenseReportTest {

    private LogCaptor logCaptor = LogCaptor.forClass(ExpenseReport.class);

    @Test
    void printReport() {
        ExpenseReport expenseReport = new ExpenseReport();

        Expenses expenses = new Expenses(
                new Expense(ExpenseType.DINNER, 100),
                new Expense(ExpenseType.BREAKFAST, 40),
                new Expense(ExpenseType.CAR_RENTAL, 250),
                new Expense(ExpenseType.DINNER, 5001),
                new Expense(ExpenseType.BREAKFAST, 1001)
        );
        expenseReport.printReport(expenses, new Date(0));

        Approvals.verify(getLogs());
    }

    private String getLogs() {
        return logCaptor.getLogs()
                .stream()
                .collect(joining("\n"));
    }
}