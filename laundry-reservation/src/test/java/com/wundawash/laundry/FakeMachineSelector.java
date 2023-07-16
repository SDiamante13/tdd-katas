package com.wundawash.laundry;

import java.util.ArrayDeque;
import java.util.Queue;

public class FakeMachineSelector implements MachineSelector {

    private final Queue<Integer> machineNumbers;

    public FakeMachineSelector() {
        this.machineNumbers = new ArrayDeque<>();
    }

    @Override
    public int findAvailableMachine() {
        if (machineNumbers.isEmpty()) {
            throw new NextElementIsNotSetupException();
        }
        return machineNumbers.remove();
    }

    public void setupAvailableMachine(int machineNumber) {
        machineNumbers.add(machineNumber);
    }
}
