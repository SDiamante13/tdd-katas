package tech.pathtoprogramming;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.Currency.EUR;

class CurrencyExchangeBoardTest {

    public static final Money USD_MONEY = new Money(BigDecimal.valueOf(100), Currency.USD);
    private final CurrencyExchangeBoard currencyExchangeBoard = new CurrencyExchangeBoard();

    @Test
    @Disabled
    void liveCallToFixerAPI() {
        BigDecimal expectedExchangeRateStart = BigDecimal.valueOf(0.9);
        BigDecimal expectedExchangeRateEnd = BigDecimal.valueOf(1.0);

        BigDecimal actualExchangeRate = currencyExchangeBoard.getExchangeRateFor(USD_MONEY, EUR);

        assertThat(actualExchangeRate).isBetween(expectedExchangeRateStart, expectedExchangeRateEnd);
    }
}