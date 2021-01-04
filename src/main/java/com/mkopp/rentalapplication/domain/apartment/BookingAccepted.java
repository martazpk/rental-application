package com.mkopp.rentalapplication.domain.apartment;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
public class BookingAccepted {
    private final String id;
    private final String rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;
    private final LocalDateTime creationDate;

    private BookingAccepted(String id, String rentalType, String rentalPlaceId, String tenantId, List<LocalDate> days, LocalDateTime creationDate) {
        this.id = id;
        this.rentalType = rentalType;
        this.rentalPlaceId = rentalPlaceId;
        this.tenantId = tenantId;
        this.days = days;
        this.creationDate = creationDate;
    }

    public static BookingAccepted create(RentalType rentalType, String rentalPlaceId, String tenantId, List<LocalDate> days) {
        String eventId = UUID.randomUUID().toString();
        LocalDateTime creationDate = LocalDateTime.now();

        return new BookingAccepted(eventId, rentalType.name(), rentalPlaceId, tenantId, days, creationDate);
    }
}
