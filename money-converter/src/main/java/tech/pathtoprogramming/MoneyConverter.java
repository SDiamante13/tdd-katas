package tech.pathtoprogramming;

import java.math.BigDecimal;

import static tech.pathtoprogramming.Currency.valueOf;
import static tech.pathtoprogramming.Money.createMoney;

class MoneyConverter {
    private final ExchangeBoard exchangeBoard;
    private final MoneyCalculator moneyCalculator;

    MoneyConverter(ExchangeBoard exchangeBoard, MoneyCalculator moneyCalculator) {
        this.exchangeBoard = exchangeBoard;
        this.moneyCalculator = moneyCalculator;
    }

    public Money convert(String basePrice, String baseCurrency, String targetCurrency) {
        Money baseMoney = createMoney(basePrice, baseCurrency);
        BigDecimal exchangeRate = exchangeBoard.getExchangeRateFor(baseMoney, valueOf(targetCurrency));
        BigDecimal targetPrice = moneyCalculator.calculate(BigDecimal.valueOf(Double.parseDouble(basePrice)), exchangeRate);

        return createMoney(targetPrice, targetCurrency);
    }
}
