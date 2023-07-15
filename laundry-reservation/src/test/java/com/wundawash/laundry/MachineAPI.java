package com.wundawash.laundry;

import java.time.LocalDateTime;
import java.util.UUID;

public interface MachineAPI {

    boolean lock(UUID reservationId, int machineNumber, LocalDateTime reservationDateTime, int pin);
}
