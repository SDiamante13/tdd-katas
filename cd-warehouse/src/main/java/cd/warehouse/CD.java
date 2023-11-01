package cd.warehouse;

import java.util.Objects;

public final class CD {

    private int stock;

    public CD(int stock) {
        this.stock = stock;
    }

    public void buy(int quantity) {
        this.stock -= quantity;
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
