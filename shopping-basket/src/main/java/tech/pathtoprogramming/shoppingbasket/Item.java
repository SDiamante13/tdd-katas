package tech.pathtoprogramming.shoppingbasket;

class Item {
    private final String name;
    private final float unitPrice;
    private final int quantity;

    Item(String name, float unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    float itemSubtotal() {
        return unitPrice * quantity;
    }
}
