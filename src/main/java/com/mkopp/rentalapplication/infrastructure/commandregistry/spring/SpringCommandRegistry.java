package com.mkopp.rentalapplication.infrastructure.commandregistry.spring;

import com.mkopp.rentalapplication.application.booking.AcceptBooking;
import com.mkopp.rentalapplication.application.booking.RejectBooking;
import com.mkopp.rentalapplication.application.commandregistry.CommandRegistry;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandRegistry implements CommandRegistry {
    private final ApplicationEventPublisher publisher;

    public SpringCommandRegistry(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void register(RejectBooking rejectBooking) {
        publisher.publishEvent(rejectBooking);
    }

    @Override
    public void register(AcceptBooking acceptBooking) {
        publisher.publishEvent(acceptBooking);
    }
}
