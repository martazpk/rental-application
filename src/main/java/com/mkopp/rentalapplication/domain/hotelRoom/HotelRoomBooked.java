package com.mkopp.rentalapplication.domain.hotelRoom;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class HotelRoomBooked {
    private final String id;
    private final LocalDate eventCreationDateTime;
    private final String hotelRoomId;
    private final String hotelId;
    private final String tenantId;
    private final List<LocalDate> dates;

    private HotelRoomBooked(String id, LocalDate eventCreationDateTime, String hotelRoomId, String hotelId, String tenantId, List<LocalDate> dates) {
        this.id = id;
        this.eventCreationDateTime = eventCreationDateTime;
        this.hotelRoomId = hotelRoomId;
        this.hotelId = hotelId;
        this.tenantId = tenantId;
        this.dates = dates;
    }

    public static HotelRoomBooked create(String hotelRoomId, String hotelId, String tenantId, List<LocalDate> dates) {
        String eventId = UUID.randomUUID().toString();
        LocalDate eventCreationDateTime = LocalDate.now();

        return new HotelRoomBooked(eventId, eventCreationDateTime, hotelRoomId, hotelId, tenantId, dates);
    }

    public String getId() {
        return id;
    }

    public LocalDate getEventCreationDateTime() {
        return eventCreationDateTime;
    }

    public String getHotelRoomId() {
        return hotelRoomId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public List<LocalDate> getDates() {
        return dates;
    }
}
