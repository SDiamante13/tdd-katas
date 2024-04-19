package org.codingdojo.vendingmachine;

public class Story {

    private String toVerify = "";
    private final VendingMachinePrinter printer;

    public Story(VendingMachinePrinter printer) {
        this.printer = printer;
    }

    public void init(String name) {
        this.toVerify = "%s\n\n".formatted(name);
    }

    public void arrange() {
        this.toVerify += printer.print();
    }

    public void act(String action) {
        this.toVerify += "\n%s\n\n%s".formatted(action, printer.print());
    }

    @Override
    public String toString() {
        return this.toVerify;
    }
}
