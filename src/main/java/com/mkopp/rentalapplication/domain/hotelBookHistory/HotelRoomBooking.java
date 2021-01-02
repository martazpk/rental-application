package com.mkopp.rentalapplication.domain.hotelBookHistory;

import com.mkopp.rentalapplication.domain.apartmentBookHistory.BookingStep;

import java.time.LocalDate;
import java.util.List;

public class HotelRoomBooking {
    private final LocalDate eventCreationDateTime;
    private final String roomId;
    private final String hotelId;
    private final List<LocalDate> dates;
    private final String tenantId;
    private final BookingStep bookingStep;

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
}
