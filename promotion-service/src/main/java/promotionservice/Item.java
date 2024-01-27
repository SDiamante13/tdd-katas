package promotionservice;

public class Item {
    private String name;
    private int price;
    private double tax;

    private static final int STANDARD_DISCOUNT_AMOUNT = 2;

    public Item(String name, int price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    double calculatePriceAfterPromotion() {
        return price + price * tax;
    }

    int priceWithStandardDiscount() {
        return price - STANDARD_DISCOUNT_AMOUNT;
    }

    boolean isPromotional() {
        return price > 122;
    }
}
