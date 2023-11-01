package cd.warehouse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class BuyCDTest {

    CreditCard mockCreditCard = mock(CreditCard.class);

    @Test
    void buyingCDReducesStockByQuantityBought() {
        CD cd = new CD(3, 0);

        cd.buy(3, mockCreditCard);

        assertThat(cd.stock()).isZero();
    }

    @Test
    void paymentReceivedIsQuantityTimesPrice() {
        CD cd = new CD(3, 10.0);

        cd.buy(2, mockCreditCard);

        verify(mockCreditCard).pay(20.00);
    }

    @Test
    void aCDPurchaseIsDeniedIfTheQuantityExceedsTheAvailableStock() {
        CD cd = new CD(3, 0);

        assertThatThrownBy(
                () -> cd.buy(4, mockCreditCard)
        ).isInstanceOf(InsufficientStockException.class)
                .hasMessage("This CD has insufficient stock to process this order.");
    }

    @Test
    void theCDStockRemainsTheSameWhenThePaymentIsRejected() {
        doThrow(new PaymentException())
                .when(mockCreditCard)
                .pay(10.00);
        CD cd = new CD(3, 10.00);

        cd.buy(1, mockCreditCard);

        assertThat(cd.stock()).isEqualTo(3);
    }
}
