package tech.pathtoprogramming.shoppingbasket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.shoppingbasket.Items.of;
import static tech.pathtoprogramming.shoppingbasket.ShoppingBasket.FIVE_PERCENT_DISCOUNT;
import static tech.pathtoprogramming.shoppingbasket.ShoppingBasket.TEN_PERCENT_DISCOUNT;

class AShoppingBasketShould {

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

        float discount = 103 * FIVE_PERCENT_DISCOUNT;
        assertThat(actualTotalPrice).isEqualTo(103 - discount);
    }


    @Test
    void calculateTotalPriceAppliesDiscountForOrderOver200() {
        float actualTotalPrice = new ShoppingBasket(of(
                new Item("pots", 20, 5),
                new Item("flowers", 30, 10)
        )).calculateTotalPrice();

        float discount = 400 * TEN_PERCENT_DISCOUNT;
        assertThat(actualTotalPrice).isEqualTo(400 - discount);
    }

    @Test
    void findOutTheQuantityOfAParticularItem() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(of(
                new Item("eggs", 5, 1),
                new Item("milk", 5, 2),
                new Item("steak", 5, 3)
        ));


        assertThat(shoppingBasket.getItemQuantity("eggs")).isEqualTo(1);
        assertThat(shoppingBasket.getItemQuantity("milk")).isEqualTo(2);
        assertThat(shoppingBasket.getItemQuantity("steak")).isEqualTo(3);
    }
}

