package banking;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @Test
    void userCanDepositMoneyAndPrintStatements() {
        Account account = new Account(0);
        account.deposit(500, () -> LocalDate.of(2015, 12, 24));

        String statement = account.printStatement();

        assertThat(statement).isEqualTo("""
                Date\t\t\tAmount\t\t\tBalance
                24.12.2015\t\t\t+500\t\t\t500"""
        );
    }
}
