package banking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class Account {

    public static final String ACCOUNT_STATEMENT_HEADER = "Date\t\t\tAmount\t\t\tBalance\n";
    private int balance;
    private final List<String> statements;

    public Account(int initialBalance) {
        balance = initialBalance;
        statements = new ArrayList<>();
    }

    public void deposit(int amount, Supplier<LocalDate> date) {
        balance += amount;
        addToStatements(date, amount, balance, true);
    }

    private void addToStatements(Supplier<LocalDate> date, int amount, int balance, boolean isCredit) {
        statements.add(format(date, amount, balance, isCredit));
    }

    private String format(Supplier<LocalDate> date, int amount, int balance, boolean isCredit) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String unaryOperator = isCredit ? "+" : "-";
        return date.get().format(formatter) + "\t\t\t" + unaryOperator + amount + "\t\t\t" + balance;
    }

    public String printStatement() {
        return ACCOUNT_STATEMENT_HEADER +
                String.join("\n", statements);
    }

    public void withdraw(int amount, Supplier<LocalDate> date) {
        balance -= amount;
        addToStatements(date, amount, balance, false);
    }
}
