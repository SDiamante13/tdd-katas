package promotionservice;

public class Item {

    private final String name;
    private final int price;
    private final double tax;

    private static final int STANDARD_DISCOUNT_AMOUNT = 2;

    public Item(String name, int price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    double calculatePriceWithTax() {
        return price + price * tax;
    }

    Item applyPriceAndTaxDiscounts() {
        return new Item(
                this.name,
                priceWithStandardDiscount(),
                isPromotional() ? taxForPromotional() : this.tax
        );
    }

    private int priceWithStandardDiscount() {
        return price - STANDARD_DISCOUNT_AMOUNT;
    }

    private boolean isPromotional() {
        return price > 122;
    }

     private double taxForPromotional() {
        return tax / 2;
    }
}
