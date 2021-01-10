package com.mkopp.rentalapplication.domain.apartment;

import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private String id;
    @Enumerated(EnumType.STRING)
    private RentalType rentalType;
    private String rentalPlaceId;
    private String tenantId;
    private List<LocalDate> days;
    private BookingStatus bookingStatus = BookingStatus.OPEN;

    public Booking() {
    }

    private Booking(RentalType rentalType, String rentalPlaceId, String tenantId, List<LocalDate> dates) {
        this.rentalType = rentalType;
        this.rentalPlaceId = rentalPlaceId;
        this.tenantId = tenantId;
        this.days = dates;
    }

    public static Booking apartment(String rentalPlaceId, String tenantId, Period period) {
        List<LocalDate> dates = period.asDays();
        return new Booking(RentalType.APARTMENT, rentalPlaceId, tenantId, dates);
    }

    public static Booking hotel(String rentalPlaceId, String tenantId, List<LocalDate> days) {
        return new Booking(RentalType.HOTEL, rentalPlaceId, tenantId, days);
    }

    public void reject() {
        bookingStatus = BookingStatus.REJECTED;
    }

    public void accept(EventChannel eventChannel) {
        bookingStatus = BookingStatus.ACCEPTED;
        BookingAccepted bookingAccepted = BookingAccepted.create(rentalType, rentalPlaceId, tenantId, days);
        eventChannel.publish(bookingAccepted);
    }
}
