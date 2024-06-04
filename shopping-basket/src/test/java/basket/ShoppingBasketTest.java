package basket;

public class ShoppingBasketTest {

    // test list:
    // find quantity of item returns 0 for empty basket
    // find quantity of item returns 1 for basket with 1 of given item
    // empty basket - 0.00
    // basket with 1 item (pizza) - $5 = $5.00
    // basket with 1 item quantity (steak) 2, $10 = $20
    // basket with 2 items (pizza, steak) $5 (2) $10 (3) = $40.00
    // no discount for $100 -> 3 items (pizza, steak, water) $5 (4) $10 (5) $30 (1)
    // over $100 gives 5% discount -> 1 item (pizza) $5 (30) = 142.50
    // at $200 gives 5% discount -> 1 item (steak) $10 (20) = 190.00
    // over $200 gives 10% discount -> 1 item (steak) $10 (22) = 198.00

}
