package com.wundawash.laundry;

import java.time.LocalDateTime;
import java.util.UUID;

class CreateReservationUseCase {

    private final MachineSelector machineSelector;
    private final EmailService emailService;
    private final ReservationStorage reservationStorage;
    private final MachineAPI machineAPI;
    private final IdGenerator idGenerator = new IdGenerator();

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

        UUID reservationId = idGenerator.generateReservationId();
        int machineNumber = machineSelector.findAvailableMachine();
        int pin = generatePin();

        sendConfirmationEmail(reservationId, machineNumber, pin); // data clump?
        saveReservation(reservationDateTime, phoneNumber, emailAddress, reservationId);
        // need MachineState enum
        boolean machineWasLocked = machineAPI.lock(reservationId, machineNumber, reservationDateTime, pin);
        return machineWasLocked;
    }

    private int generatePin() {
        return 12345;
    }

    private void saveReservation(LocalDateTime reservationDateTime, String phoneNumber, String emailAddress, UUID reservationId) {
        reservationStorage.save(new ReservationEntity(reservationId, reservationDateTime, phoneNumber, emailAddress));
    }

    private void sendConfirmationEmail(UUID reservationId, int machineNumber, int pin) {
        emailService.sendConfirmationEmail(new ConfirmationEmailDto(
                machineNumber,
                reservationId,
                pin));
    }

}
