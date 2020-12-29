package com.mkopp.rentalapplication.domain.eventchannel;

import com.mkopp.rentalapplication.domain.apartment.ApartmentBooked;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomBooked;

public interface EventChannel {
    void publish(ApartmentBooked apartmentBooked);

    void publish(HotelRoomBooked hotelRoomBooked);
}
