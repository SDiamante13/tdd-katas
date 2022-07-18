package tech.pathtoprogramming.shoppingbasket;

import org.junit.jupiter.api.Test;

import java.util.Collections;
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

    @Test
    void haveZeroTotalForNoItems() {
        float actualTotalPrice = aBasketWith(NO_ITEMS).calculateTotalPrice();

        assertThat(actualTotalPrice).isZero();
    }

    @Test
    void calculateTotalPriceOfOneItem() {
        float actualTotalPrice = aBasketWith(new HashMap<>() {{
            put("eggs", 50);
        }}).calculateTotalPrice();

        assertThat(actualTotalPrice).isEqualTo(50);
    }

    private ShoppingBasket aBasketWith(Map<String, Integer> items) {
        ShoppingBasket shoppingBasket = new ShoppingBasket(items);
        return shoppingBasket;
    }

}

class ShoppingBasket {
    private Map<String, Integer> items;

    public ShoppingBasket(Map<String, Integer> items) {
        this.items = items;
    }

    public float calculateTotalPrice() {
        if (items.containsKey("eggs")) return 50;
        return 0;
    }
}
