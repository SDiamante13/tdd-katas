package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.RoundingMode.UNNECESSARY;
import static org.assertj.core.api.Assertions.assertThat;

class AMoneyCalculatorShould {

    @Test
    void returnTheTargetPriceBasedOnTheBasePriceAndExchangeRate() {
        BigDecimal expectedTargetPrice = BigDecimal.valueOf(96.00).setScale(2, UNNECESSARY);

        BigDecimal actualTargetPrice = new MoneyCalculator().calculate(BigDecimal.valueOf(100), BigDecimal.valueOf(0.96));

        assertThat(actualTargetPrice).isEqualTo(expectedTargetPrice);
    }
}