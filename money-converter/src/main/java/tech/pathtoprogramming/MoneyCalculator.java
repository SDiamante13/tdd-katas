package tech.pathtoprogramming;

import java.math.BigDecimal;

class MoneyCalculator {

    public BigDecimal calculate(BigDecimal basePrice, BigDecimal exchangeRate) {
        return basePrice.multiply(exchangeRate);
    }
}
