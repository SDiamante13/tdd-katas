package banking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class Account {

    public static final String ACCOUNT_STATEMENT_HEADER = "Date\t\t\tAmount\t\t\tBalance\n";
    private int balance;
    private List<String> statements;

    public Account(int initialBalance) {
        balance = initialBalance;
        statements = new ArrayList<>();
    }

    public void deposit(int amount, Supplier<LocalDate> date) {
        balance += amount;
        addToStatements(date, amount, balance);
    }

    private void addToStatements(Supplier<LocalDate> date, int amount, int balance) {
        statements.add(format(date, amount, balance));
    }

    private String format(Supplier<LocalDate> date, int amount, int balance) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return ACCOUNT_STATEMENT_HEADER +
                date.get().format(formatter) + "\t\t\t" + "+" + amount + "\t\t\t" + balance;

    }

    public String printStatement() {
        return String.join("\n", statements);
    }
}
