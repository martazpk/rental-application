package com.mkopp.rentalapplication.infrastructure.rest.api.hotelroom;

import java.time.LocalDate;
import java.util.List;

public class HotelRoomBookingDto {
    private List<LocalDate> dates;
    private String tenantId;

    public List<LocalDate> getDates() {
        return dates;
    }

    public String getTenantId() {
        return tenantId;
    }
}
