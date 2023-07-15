package com.wundawash.laundry;

import java.time.LocalDateTime;
import java.util.UUID;

class CreateReservationUseCase {

    private final EmailService emailService;
    private final ReservationStorage reservationStorage;
    private final MachineAPI machineAPI;

    public CreateReservationUseCase(EmailService emailService, ReservationStorage reservationStorage, MachineAPI machineAPI) {
        this.emailService = emailService;
        this.reservationStorage = reservationStorage;
        this.machineAPI = machineAPI;
    }

    public boolean handle(LocalDateTime reservationDateTime, String phoneNumber, String emailAddress) {
        UUID reservationId = UUID.fromString("5429f280-a06e-40e9-8fe1-0f42ee165fa0");
        ConfirmationEmailDto email = new ConfirmationEmailDto(
                1,
                reservationId,
                12345);
        emailService.sendConfirmationEmail(email);
        reservationStorage.save(new ReservationDto(reservationId, reservationDateTime, phoneNumber, emailAddress));
        boolean machineWasLocked = machineAPI.lock(reservationId, 1, reservationDateTime, 12345);
        return machineWasLocked;
    }
}
