package com.mkopp.rentalapplication.domain.hotelBookHistory;

import com.mkopp.rentalapplication.domain.apartmentBookHistory.BookingStep;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class HotelRoomBooking {
    @Id
    private UUID id;
    private LocalDate eventCreationDateTime;
    private String roomId;
    private String hotelId;
    @ElementCollection
    private List<LocalDate> dates;
    private String tenantId;
    private BookingStep bookingStep;

    private HotelRoomBooking(LocalDate eventCreationDateTime, String roomId, String hotelId, List<LocalDate> dates,
                             String tenantId, BookingStep bookingStep) {
        this.eventCreationDateTime = eventCreationDateTime;
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.dates = dates;
        this.tenantId = tenantId;
        this.bookingStep = bookingStep;
    }

    public static HotelRoomBooking start(LocalDate eventCreationDateTime, String roomId, String hotelId, List<LocalDate> dates, String tenantId) {
        return new HotelRoomBooking(eventCreationDateTime, roomId, hotelId, dates, tenantId, BookingStep.START);
    }

    private HotelRoomBooking() {
    }
}
