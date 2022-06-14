package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class AMoneyConverterShould {

    private static final BigDecimal BASE_PRICE = valueOf(100.0);
    private static final BigDecimal EXCHANGE_RATE = valueOf(0.96);
    public static final BigDecimal TARGET_PRICE = valueOf(96);


    private final MoneyCalculator mockMoneyCalculator = Mockito.mock(MoneyCalculator.class);
    private final MoneyConverter moneyConverter = new MoneyConverter(
            new FakeCurrencyExchangeBoard(), mockMoneyCalculator);

    @Test
    void convertUSDtoEuros() {
        given(mockMoneyCalculator.calculate(BASE_PRICE, EXCHANGE_RATE)).willReturn(TARGET_PRICE);
        Money expectedMoney = new Money(new BigDecimal(96), Currency.EUR);

        Money actualMoney = moneyConverter.convert("100", "USD", "EUR");

        assertThat(actualMoney).isEqualTo(expectedMoney);
    }

    // pass in invalid base currency
    // pass in invalid target currency
    // pass in letters in basePrice
}
