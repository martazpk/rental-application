package com.mkopp.rentalapplication.infrastructure.eventchannel.spring;

import com.mkopp.rentalapplication.domain.apartment.ApartmentBooked;
import com.mkopp.rentalapplication.domain.apartment.BookingAccepted;
import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomBooked;
import org.springframework.context.ApplicationEventPublisher;

public class SpringEventChannel implements EventChannel {
    private final ApplicationEventPublisher publisher;

    public SpringEventChannel(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(ApartmentBooked apartmentBooked) {
        publisher.publishEvent(apartmentBooked);

    }

    @Override
    public void publish(HotelRoomBooked hotelRoomBooked) {
        publisher.publishEvent(hotelRoomBooked);
    }

    @Override
    public void publish(BookingAccepted bookingAccepted) {
        publisher.publishEvent(bookingAccepted);
    }
}
