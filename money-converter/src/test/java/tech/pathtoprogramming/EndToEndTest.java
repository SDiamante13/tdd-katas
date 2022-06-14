package tech.pathtoprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class EndToEndTest {

    @DisplayName("given 100 USD at an exchange rate of 0.96 will return 96 Euros")
    @Test
    void happyPath() {
        Money actualMoney = new MoneyConverter(new FakeCurrencyExchangeBoard(), new MoneyCalculator()).convert("100", "USD", "EUR");

        assertThat(actualMoney).isEqualTo(new Money(new BigDecimal(96), Currency.EUR));
    }
}

class FakeCurrencyExchangeBoard implements ExchangeBoard {

    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency) {
        return BigDecimal.valueOf(0.96);
    }
}
