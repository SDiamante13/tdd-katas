package com.wundawash.laundry;

import java.time.LocalDateTime;
import java.util.UUID;

public class FakeMachineAPI implements MachineAPI {

    @Override
    public boolean lock(UUID reservationId, int machineNumber, LocalDateTime reservationDateTime, int pin) {
        return true;
    }
}
