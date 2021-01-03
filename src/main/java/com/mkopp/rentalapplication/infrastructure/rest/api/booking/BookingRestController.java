package com.mkopp.rentalapplication.infrastructure.rest.api.booking;

import com.mkopp.rentalapplication.application.booking.RejectBooking;
import com.mkopp.rentalapplication.application.commandregistry.CommandRegistry;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingRestController {
    private final CommandRegistry commandRegistry;

    public BookingRestController(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    @PutMapping("/reject/{id}")
    public void reject(String id) {
        commandRegistry.register(new RejectBooking(id));
    }
}
