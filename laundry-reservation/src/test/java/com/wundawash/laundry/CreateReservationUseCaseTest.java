package com.wundawash.laundry;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CreateReservationUseCaseTest {

    // MachineAPI - lock machines --> Stub [x] can use Nullable Infrastructure

    // What gets stored in the reservation? pin? machine number?

    private final FakeMachineSelector fakeMachineSelector = new FakeMachineSelector();
    private final FakeEmailService fakeEmailService = new FakeEmailService();
    private final FakeReservationStorage fakeReservationStorage = new FakeReservationStorage();
    private final FakeMachineAPI fakeMachineAPI = new FakeMachineAPI();

    @Test
    void successfullyCreateAReservation() {
        CreateReservationUseCase useCase = new CreateReservationUseCase(
                fakeMachineSelector,
                fakeEmailService,
                fakeReservationStorage,
                fakeMachineAPI
        );

        var reservationDateTime = LocalDateTime.now();
        var phoneNumber = "919-528-9457";
        var emailAddress = "customer.email@gmail.com";

        var machineNumber = 2;
        fakeMachineSelector.setupAvailableMachine(machineNumber);

        UUID reservationId = UUID.fromString("5429f280-a06e-40e9-8fe1-0f42ee165fa0"); // randomly generated
        int pin = 12345; // randomly selected 5 digits
        ConfirmationEmailDto expectedEmail = new ConfirmationEmailDto(machineNumber, reservationId, pin);

        boolean wasReservationCreated = useCase.handle(reservationDateTime, phoneNumber, emailAddress);

        fakeEmailService.shouldHaveSentExactly(expectedEmail);
        fakeReservationStorage.shouldContain(new ReservationDto(reservationId, reservationDateTime, phoneNumber, emailAddress));
        assertThat(wasReservationCreated).isTrue();
    }



    // TODO: Generate Reservation Id
    // TODO: Generate Pin Number
    // TODO: Use Generator abstraction from bank repo
    // TODO: What happens when the machine is already reserved? Resides in Machine API logic
    // TODO: What happens when the reservation already exists? Resides in Machine API logic
    // TODO: May need to jump down to Machine API to figure out the rest of the design

}
