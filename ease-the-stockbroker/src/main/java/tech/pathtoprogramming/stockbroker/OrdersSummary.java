package tech.pathtoprogramming.stockbroker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.valueOf;
import static java.util.Arrays.asList;

public class OrdersSummary {

    private static final String ORDER_DELIMITER = ",";
    private static final String ORDER_COMPONENT_DELIMITER = " ";
    private static final String BUY = "B";
    private static final String SELL = "S";

    public static String balanceStatements(String orders) {
        if (orders.isEmpty()) return "Buy: 0 Sell: 0";
        List<List<String>> ordersList = Arrays.stream(orders.split(ORDER_DELIMITER))
                .map(String::trim)
                .map(order -> asList(order.split(ORDER_COMPONENT_DELIMITER)))
                .collect(Collectors.toList());

        Map<Boolean, List<List<String>>> partition = ordersList.stream()
                .collect(Collectors.partitioningBy(OrdersSummary::isValidOrder));

        List<List<String>> orderMistakes = partition.get(false);

        double totalPriceOfBuys = getTotalPriceOfOrders(partition.get(true), BUY);

        double totalPriceOfSells = getTotalPriceOfOrders(partition.get(true), SELL);

        StringBuilder output = new StringBuilder(String.format("Buy: %.0f Sell: %.0f", totalPriceOfBuys, totalPriceOfSells));

        if (!orderMistakes.isEmpty()) {
            output.append("; Badly formed ")
                    .append(orderMistakes.size())
                    .append(": ");
            orderMistakes.forEach(order -> {
                        order.forEach(oc ->
                                output.append(oc).append(" ")
                        );
                        output.append(";");
                    });
        }
        return output.toString();
    }

    private static boolean isValidOrder(List<String> order) {
        return order.size() == 4 && order.get(0).matches("[a-zA-Z]+") && order.get(2).contains(".");
    }

    private static double getTotalPriceOfOrders(List<List<String>> ordersList, String status) {
        return ordersList.stream()
                .filter(order -> order.get(3).equalsIgnoreCase(status))
                .map(orderComponents -> valueOf(orderComponents.get(1))
                        * valueOf(orderComponents.get(2)))
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
