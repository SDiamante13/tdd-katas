package banking;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @Test
    void userCanDepositMoneyAndPrintStatements() {
        Account account = new Account(0);
        account.deposit(500, () ->
                LocalDate.of(2015, 12, 24));
        account.withdraw(100, () ->
                LocalDate.of(2016, 8, 23));

        String statement = account.printStatement();

        assertThat(statement).isEqualTo("""
                Date			Amount			Balance
                24.12.2015			+500			500
                23.08.2016			-100			400"""
        );
    }
}
