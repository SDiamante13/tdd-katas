package tech.pathtoprogramming.shoppingbasket;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// test list:

// map > list? name, Item

// zero items
// one item $50
// 1 item of $25, 2 items of $ 49
//


class AShoppingBasketShould {

    private static final Map<String, Integer> NO_ITEMS = Map.of();
    public static final HashMap<String, Integer> ONE_ITEM = new HashMap<>() {{
        put("eggs", 50);
    }};


    public static final HashMap<String, Integer> one = new HashMap<>() {{
        put("eggs", 50);
    }};

    @Test
    void haveZeroTotalForNoItems() {
        float actualTotalPrice = new ShoppingBasket(Items.of()).calculateTotalPrice();

        assertThat(actualTotalPrice).isZero();
    }

    @Test
    void calculateTotalPriceOfOneItem() {
        float actualTotalPrice = new ShoppingBasket(
                Items.of(
                        new Item("eggs", 50)
                ))
                .calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(50);
    }

    @Test
    void twoItems() {
        float actualTotalPrice = new ShoppingBasket(Items.of(new Item("eggs", 50), new Item("milk", 3))).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(50 + 3);

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
    // wrote too much code here. The get is not necessary since items calculate its own total
//    public Item get(String name) {
//        return items.get(name);
//    }

    public float total() {
        return items.values().stream()
                .map(Item::getUnitPrice)
                .reduce(Float::sum)
                .orElse(0.0f);
    }
}

class Item {
    private final String name;
    private final float unitPrice;

    Item(String name, float unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
