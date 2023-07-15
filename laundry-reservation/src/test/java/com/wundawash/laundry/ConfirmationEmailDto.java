package com.wundawash.laundry;

import java.util.Objects;
import java.util.UUID;

class ConfirmationEmailDto {

    private final int machineNumber;
    private final UUID reservationId;
    private final int pin;

    public ConfirmationEmailDto(int machineNumber, UUID reservationId, int pin) {
        this.machineNumber = machineNumber;
        this.reservationId = reservationId;
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfirmationEmailDto that = (ConfirmationEmailDto) o;

        if (machineNumber != that.machineNumber) return false;
        if (pin != that.pin) return false;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        int result = machineNumber;
        result = 31 * result + (reservationId != null ? reservationId.hashCode() : 0);
        result = 31 * result + pin;
        return result;
    }

    @Override
    public String toString() {
        return "ConfirmationEmailDto{" +
                "machineNumber=" + machineNumber +
                ", reservationId=" + reservationId +
                ", pin=" + pin +
                '}';
    }
}
