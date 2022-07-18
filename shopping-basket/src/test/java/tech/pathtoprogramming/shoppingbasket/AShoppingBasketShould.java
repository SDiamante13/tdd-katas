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

    @Test
    void haveZeroTotalPriceForNoItems() {
        float actualTotalPrice = new ShoppingBasket(of()).calculateTotalPrice();

        assertThat(actualTotalPrice).isZero();
    }

    @Test
    void calculateTotalPriceOfOneItem() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("eggs", 50, 1)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(50);
    }

    @Test
    void calculateTotalPriceOfTwoItems() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("eggs", 50, 1),
                new Item("milk", 3, 1)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(50 + 3);
    }

    // 1 item of $25, 2 items of $ 49

    @Test
    void calculateTotalPriceOfMultipleItemsOfSameName() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("steak", 33, 3)
        )).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(99);

    }
}

class ShoppingBasket {
    private final Items newItems;

    public ShoppingBasket(Items newItems) {
        this.newItems = newItems;
    }

    public float calculateTotalPrice() {
        return newItems.total();
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
