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
        StringBuilder text = new StringBuilder();
        text.append("VendingMachine\n");
        text.append(formatLineWithWhitespace("Display", machine.display()));
        text.append(formatLineWithWhitespace("Balance", "" + machine.balance()));
        text.append(formatLineWithWhitespace("Coins", Arrays.toString(machine.coins())));
        return text.toString();
    }

    /** Convenience function that lays out a name and a value at either ends of a fixed-width line.
     eg if you call it with name="Foo" value="Bar" it will return
     Foo                                       Bar
     */
    private String formatLineWithWhitespace(String name, String value){
        int whitespaceSize = columns - name.length() - value.length();
        StringBuilder whiteSpace = new StringBuilder();
        for (int i = 0; i < whitespaceSize; i++) {
            whiteSpace.append(" ");
        }
        String line = String.format("%s%s%s\n", name, whiteSpace.toString(), value);
        return line;
    }
}
