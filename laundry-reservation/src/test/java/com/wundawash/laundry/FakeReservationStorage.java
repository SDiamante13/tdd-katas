package com.wundawash.laundry;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeReservationStorage implements ReservationStorage {

    private final Map<UUID, ReservationEntity> reservations;

    public FakeReservationStorage() {
        this.reservations = new HashMap<>();
    }

    @Override
    public void save(ReservationEntity reservationEntity) {
        this.reservations.put(reservationEntity.getReservationId(), reservationEntity);
    }

    public void shouldContain(ReservationEntity expectedReservation) {
        UUID reservationId = expectedReservation.getReservationId();
        var retrievedReservation = reservations.get(reservationId);
        assertThat(retrievedReservation).isEqualTo(expectedReservation);
    }
}
