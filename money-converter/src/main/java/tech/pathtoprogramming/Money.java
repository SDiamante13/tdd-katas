package tech.pathtoprogramming;

import java.math.BigDecimal;

class Money {
    private final BigDecimal price;
    private final Currency currency;

    Money(BigDecimal price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public static Money createMoney(String price, String currency) {
        return new Money(BigDecimal.valueOf(Double.parseDouble(price)), Currency.valueOf(currency));
    }

    public Currency currency() {
        return currency;
    }

    public static Money createMoney(BigDecimal price, String currency) {
        return new Money(price, Currency.valueOf(currency));


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (price != null ? !price.equals(money.price) : money.price != null) return false;
        return currency == money.currency;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "price=" + price +
                ", currency=" + currency +
                '}';
    }
}
