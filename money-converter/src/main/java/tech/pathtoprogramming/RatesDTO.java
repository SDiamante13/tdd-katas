package tech.pathtoprogramming;

import java.math.BigDecimal;

class RatesDTO {
    private final Rates rates;

    public RatesDTO(Rates rates) {
        this.rates = rates;
    }

    public BigDecimal exchangeRate(Currency targetCurrency) {
        return BigDecimal.valueOf(rates.exchangeRate(targetCurrency));
    }
}
