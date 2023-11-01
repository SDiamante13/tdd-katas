package cd.warehouse;

import java.util.Objects;

public final class CD {

    private int stock;
    private double price;

    public CD(int stock, double price) {
        this.stock = stock;
        this.price = price;
    }

    public void buy(int quantity, CreditCard creditCard) {
        checkThatStockIsEnoughFor(quantity);
        try {
            creditCard.pay(quantity * price);
        } catch (PaymentException e) {
            return;
        }
        this.stock -= quantity;
    }

    private void checkThatStockIsEnoughFor(int quantity) {
        if (quantity > stock) {
            throw new InsufficientStockException();
        }
    }

    public int stock() {
        return stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CD) obj;
        return this.stock == that.stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock);
    }

    @Override
    public String toString() {
        return "CD[" +
                "stock=" + stock + ']';
    }
}
