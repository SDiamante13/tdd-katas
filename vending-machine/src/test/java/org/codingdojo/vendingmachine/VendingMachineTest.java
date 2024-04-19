package org.codingdojo.vendingmachine;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VendingMachineTest {

    private VendingMachine machine;
    private Map<String, Integer> coins;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
        coins = new HashMap<>() {{
            put("penny", 1);
            put("nickel", 5);
            put("dime", 10);
            put("quarter", 25);
        }};
    }

    @Test
    void test_accept_coins() {
        String initialState = new VendingMachinePrinter(machine).print();

        machine.insertCoin(coins.get("nickel"));

        String finalState = new VendingMachinePrinter(machine).print();

        Approvals.verify(initialState + "********************\n" + finalState);
    }
}
