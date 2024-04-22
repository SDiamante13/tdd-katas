package org.codingdojo.vendingmachine;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.intellij.IntelliJReporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@UseReporter(QuietReporter.class)
class VendingMachineTest {

    private VendingMachine machine;
    private VendingMachinePrinter printer;
    private Story story;
    private Map<String, Integer> coins = new HashMap<>() {{
        put("penny", 1);
        put("nickel", 5);
        put("dime", 10);
        put("quarter", 25);
    }};

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
        printer = new VendingMachinePrinter(machine);
        story = new Story(printer);
    }

    @Test
    void accept_nickel() {
        story.init("Feature: Nickel is accepted");
        story.arrange();

        story.act(insertCoin("nickel"));

        Approvals.verify(story.toString());
    }

    @Test
    void accept_dime() {
        story.init("Feature: Dime is accepted");
        story.arrange();

        story.act(insertCoin("dime"));

        Approvals.verify(story.toString());
    }

    @Test
    void accept_quarter() {
        story.init("Feature: Quarter is accepted");
        story.arrange();

        story.act(insertCoin("quarter"));

        Approvals.verify(story.toString());
    }

    @Test
    void update_balance() {
        story.init("Feature: Update balance displayed when coin inserted");
        insertCoin("nickel");
        insertCoin("quarter");
        story.arrange();

        story.act(insertCoin("dime"));

        Approvals.verify(story.toString());
    }

    private String insertCoin(String coin) {
        machine.insertCoin(coins.get(coin));
        return "insert coin: %s".formatted(coin);
    }
}
