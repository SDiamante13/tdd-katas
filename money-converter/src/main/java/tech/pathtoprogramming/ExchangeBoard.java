package tech.pathtoprogramming;

import java.math.BigDecimal;

interface ExchangeBoard {
    BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency);
}
