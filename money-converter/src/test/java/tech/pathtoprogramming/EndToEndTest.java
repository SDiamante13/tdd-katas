package tech.pathtoprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.UNNECESSARY;
import static org.assertj.core.api.Assertions.assertThat;

class EndToEndTest {

    private final FakeCurrencyExchangeBoard fakeCurrencyExchangeBoard = new FakeCurrencyExchangeBoard();
    private final MoneyCalculator moneyCalculator = new MoneyCalculator();
    private final MoneyConverter moneyConverter = new MoneyConverter(fakeCurrencyExchangeBoard, moneyCalculator);

    @DisplayName("given 100 USD at an exchange rate of 0.96 will return 96 Euros")
    @Test
    void happyPath() {
        Money expectedMoney = new Money(valueOf(96.00).setScale(3, UNNECESSARY), Currency.EUR);

        Money actualMoney = moneyConverter.convert("100", "USD", "EUR");

        assertThat(actualMoney).isEqualTo(expectedMoney);
    }
}

class FakeCurrencyExchangeBoard implements ExchangeBoard {

    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency) {
        return valueOf(0.96);
    }
}
