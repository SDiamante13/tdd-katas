package tech.pathtoprogramming.stockbroker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrdersSummaryTest {

    private static final String GOOGLE_ORDER = "GOOG 300 542.0 B";
    private static final String TESLA_ORDER = "TSLA 100 435.0 B";

    @Test
    void balanceStatements_returnsBuyAndSellTotals_givenASingleStock() {
        String expected = "Buy: 162600 Sell: 0";

        String result = OrdersSummary.balanceStatements(GOOGLE_ORDER);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void balanceStatements_returnsBuyAndSellTotals_givenTwoBuyStocks() {
        String twoOrders = GOOGLE_ORDER + "," + TESLA_ORDER;
        String expected = "Buy: 206100 Sell: 0";

        String result = OrdersSummary.balanceStatements(twoOrders);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void balanceStatements_returnsBuyAndSellTotals_givenOneBuyAndOneSell() {
        String oneOfEach = GOOGLE_ORDER + ", TSLA 100 435.0 S";
        String expected = "Buy: 162600 Sell: 43500";

        String result = OrdersSummary.balanceStatements(oneOfEach);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void balanceStatements_returnsTotalsAndFormatMessage_givenOneBuyAndOneBadlyFormattedOrder() {
        String oneOfEach = GOOGLE_ORDER + ", TSLA 100 435.0";
        String expected = "Buy: 162600 Sell: 0; Badly formed 1: TSLA 100 435.0 ;";

        String result = OrdersSummary.balanceStatements(oneOfEach);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void balanceStatements_returnsTotalsAndFormatMessage_givenAnOrderPriceWithoutADecimal_andAStockSymbolWithNumbers() {
        String oneOfEach = GOOGLE_ORDER + ", TSLA 100 435 B , CLH16.NYM 50 56 S";
        String expected = "Buy: 162600 Sell: 0; Badly formed 2: TSLA 100 435 B ;CLH16.NYM 50 56 S ;";

        String result = OrdersSummary.balanceStatements(oneOfEach);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void balanceStatements_returnsEmpty() {
        String noOrders = "";
        String expected = "Buy: 0 Sell: 0";

        String result = OrdersSummary.balanceStatements(noOrders);

        assertThat(result).isEqualTo(expected);
    }
}