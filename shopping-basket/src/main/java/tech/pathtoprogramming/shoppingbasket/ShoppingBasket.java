package tech.pathtoprogramming.shoppingbasket;

class ShoppingBasket {
    public static final float TEN_PERCENT_DISCOUNT = 0.1f;
    public static final float FIVE_PERCENT_DISCOUNT = 0.05f;
    private final Items items;

    public ShoppingBasket(Items newItems) {
        this.items = newItems;
    }

    public float calculateTotalPrice() {
        float totalPrice = items.total();
        return totalPrice - discountFor(totalPrice);
    }

    private float discountFor(float totalPrice) {
        if (totalPrice > 200) {
            return totalPrice * TEN_PERCENT_DISCOUNT;
        }
        if (totalPrice > 100) {
            return totalPrice * FIVE_PERCENT_DISCOUNT;
        }
        return 0;
    }

    public int getItemQuantity(String itemName) {
        return items.get(itemName).getQuantity();
    }
}
