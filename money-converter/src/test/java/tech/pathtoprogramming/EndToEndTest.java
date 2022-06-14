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

class Money {
private final BigDecimal price;
private final Currency currency;

    Money(BigDecimal price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }
}

enum Currency {
    USD,
    EUR,
    GBP
}

class MoneyConverter {
    private final ExchangeBoard exchangeBoard;
    private final MoneyCalculator moneyCalculator;

    MoneyConverter(ExchangeBoard exchangeBoard, MoneyCalculator moneyCalculator) {
        this.exchangeBoard = exchangeBoard;
        this.moneyCalculator = moneyCalculator;
    }

    public Money convert(String basePrice, String baseCurrency, String targetCurrency) {
        throw new UnsupportedOperationException("Not implemented");
    }
}

class FakeCurrencyExchangeBoard implements ExchangeBoard {

    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency) {
        return BigDecimal.valueOf(0.96);
    }
}

interface ExchangeBoard {
    BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency);
}

class MoneyCalculator {

}
