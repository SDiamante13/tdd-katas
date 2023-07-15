package com.wundawash.laundry;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ReservationDto {

    private final UUID reservationId;
    private final LocalDateTime reservationDateTime;
    private final String phoneNumber;
    private final String emailAddress;

    public ReservationDto(UUID reservationId, LocalDateTime reservationDateTime, String phoneNumber, String emailAddress) {
        this.reservationId = reservationId;
        this.reservationDateTime = reservationDateTime;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public UUID getReservationId() {
        return this.reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationDto that = (ReservationDto) o;

        if (!Objects.equals(reservationId, that.reservationId))
            return false;
        if (!Objects.equals(reservationDateTime, that.reservationDateTime))
            return false;
        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        return Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        int result = reservationId != null ? reservationId.hashCode() : 0;
        result = 31 * result + (reservationDateTime != null ? reservationDateTime.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "reservationId=" + reservationId +
                ", reservationDateTime=" + reservationDateTime +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
