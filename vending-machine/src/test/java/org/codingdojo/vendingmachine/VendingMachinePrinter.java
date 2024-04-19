package org.codingdojo.vendingmachine;

import java.util.Arrays;

public class VendingMachinePrinter {

    private final int columns;
    private final VendingMachine machine;

    public VendingMachinePrinter(VendingMachine machine) {
        this.columns = 60;
        this.machine = machine;
    }

    public String print(){
        return "VendingMachine\n" +
                formatLineWithWhitespace("Display", machine.display()) +
                formatLineWithWhitespace("Balance", "" + machine.balance()) +
                formatLineWithWhitespace("Coins", Arrays.toString(machine.coins()));
    }

    /** Convenience function that lays out a name and a value at either ends of a fixed-width line.
     eg if you call it with name="Foo" value="Bar" it will return
     Foo                                       Bar
     */
    private String formatLineWithWhitespace(String name, String value){
        int whitespaceSize = columns - name.length() - value.length();
        return String.format("%s%s%s\n", name, " ".repeat(Math.max(0, whitespaceSize)), value);
    }
}
