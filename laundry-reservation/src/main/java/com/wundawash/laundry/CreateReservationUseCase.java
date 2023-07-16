package com.wundawash.laundry;

import java.time.LocalDateTime;
import java.util.UUID;

class CreateReservationUseCase {

    private final MachineSelector machineSelector;
    private final EmailService emailService;
    private final ReservationStorage reservationStorage;
    private final MachineAPI machineAPI;

    public CreateReservationUseCase(
            MachineSelector machineSelector,
            EmailService emailService,
            ReservationStorage reservationStorage,
            MachineAPI machineAPI
    ) {
        this.machineSelector = machineSelector;
        this.emailService = emailService;
        this.reservationStorage = reservationStorage;
        this.machineAPI = machineAPI;
    }

    public boolean handle(LocalDateTime reservationDateTime, String phoneNumber, String emailAddress) {
        UUID reservationId = UUID.fromString("5429f280-a06e-40e9-8fe1-0f42ee165fa0");
        int machineNumber = machineSelector.findAvailableMachine();
        ConfirmationEmailDto email = new ConfirmationEmailDto(
                machineNumber,
                reservationId,
                12345);
        emailService.sendConfirmationEmail(email);
        reservationStorage.save(new ReservationDto(reservationId, reservationDateTime, phoneNumber, emailAddress));
        boolean machineWasLocked = machineAPI.lock(reservationId, machineNumber, reservationDateTime, 12345);
        return machineWasLocked;
    }
}
