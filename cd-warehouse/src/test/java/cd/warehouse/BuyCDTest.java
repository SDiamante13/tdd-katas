package cd.warehouse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyCDTest {

    @Test
    void buyingCDReducesStockByQuantityBought() {
        CD cd = new CD(3);

        cd.buy(1);

        assertThat(cd.stock())
                .isEqualTo(2);
    }
}
