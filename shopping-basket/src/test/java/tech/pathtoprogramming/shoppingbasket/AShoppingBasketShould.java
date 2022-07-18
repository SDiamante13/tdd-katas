package tech.pathtoprogramming.shoppingbasket;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.shoppingbasket.Items.of;

// test list:

// map > list? name, Item

// zero items
// one item $50
// 1 item of $25, 2 items of $ 49


class AShoppingBasketShould {

    private static final float FIVE_PERCENT_DISCOUNT = 1 - 0.05f;
    private static final float TEN_PERCENT_DISCOUNT = 1 - 0.1f;

    @Test
    void haveZeroTotalPriceForNoItems() {
        float actualTotalPrice = new ShoppingBasket(of()).calculateTotalPrice();

        assertThat(actualTotalPrice).isZero();
    }

    @Test
    void calculateTotalPriceOfOneItem() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("eggs", 5, 1)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(5);
    }

    @Test
    void calculateTotalPriceOfTwoItems() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("eggs", 5, 1),
                new Item("milk", 3, 1)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(5 + 3);
    }


    @Test
    void calculateTotalPriceOfMultipleItemsOfSameName() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("steak", 33, 3)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(99);
    }

    @Test
    void calculateTotalPriceAppliesDiscountForOrderOver100() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("clothes", 100, 1),
                new Item("milk", 3, 1)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(103 * FIVE_PERCENT_DISCOUNT);
    }


    @Test
    void calculateTotalPriceAppliesDiscountForOrderOver200() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("pots", 20, 5),
                new Item("flowers", 30, 10)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(400 * TEN_PERCENT_DISCOUNT);
    }
}

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
}

class Items {
    private final Map<String, Item> items;

    public static Items of(Item... itemList) {
        return new Items(itemList);
    }

    private Items(Item... newItems) {
        items = new HashMap<>();

        for (Item newItem : newItems) {
            this.items.put(newItem.getName(), newItem);
        }
    }

    public float total() {
        return items.values().stream()
                .map(Item::itemSubtotal)
                .reduce(Float::sum)
                .orElse(0.0f);
    }

}

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
