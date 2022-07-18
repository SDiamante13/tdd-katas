package tech.pathtoprogramming.shoppingbasket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// test list:



class AShoppingBasketShould {

    @Test
    void haveZeroTotalForNoItems() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(Collections.emptyList());

        float actualTotalPrice = shoppingBasket.calculateTotalPrice();

        assertThat(actualTotalPrice).isZero();
    }

}

class ShoppingBasket {
    public ShoppingBasket(List<Object> items) {

    }

    public float calculateTotalPrice() {
        return 0;
    }
}
