package com.wundawash.laundry;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CreateReservationUseCaseTest {

    // MachineAPI - lock machines --> Stub [x] can use Nullable Infrastructure

    // What gets stored in the reservation? pin? machine number?

    private final FakeEmailService fakeEmailService = new FakeEmailService();
    private final FakeReservationStorage fakeReservationStorage = new FakeReservationStorage();
    private final FakeMachineAPI fakeMachineAPI = new FakeMachineAPI();

    @Test
    void successfullyCreateAReservation() {
        CreateReservationUseCase useCase = new CreateReservationUseCase(fakeEmailService, fakeReservationStorage, fakeMachineAPI);

        LocalDateTime reservationDateTime = LocalDateTime.now();
        String phoneNumber = "919-528-9457";
        String emailAddress = "customer.email@gmail.com";

        int machineNumber = 1; // randomly selected out of 25 machines
        UUID reservationId = UUID.fromString("5429f280-a06e-40e9-8fe1-0f42ee165fa0"); // randomly generated
        int pin = 12345; // randomly selected 5 digits
        ConfirmationEmailDto expectedEmail = new ConfirmationEmailDto(machineNumber, reservationId, pin);

        boolean wasReservationCreated = useCase.handle(reservationDateTime, phoneNumber, emailAddress);

        fakeEmailService.shouldHaveSentExactly(expectedEmail);
        fakeReservationStorage.shouldContain(new ReservationDto(reservationId, reservationDateTime, phoneNumber, emailAddress));
        assertThat(wasReservationCreated).isTrue();
    }

    // TODO: What happens when the machine is already reserved?
    // TODO: randomly select a machine instead of always choosing 1
    // TODO: May need to jump down to Machine API to figure out the rest of the design

}
