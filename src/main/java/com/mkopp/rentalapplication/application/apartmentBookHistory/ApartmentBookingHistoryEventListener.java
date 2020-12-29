package com.mkopp.rentalapplication.application.apartmentBookHistory;

import com.mkopp.rentalapplication.domain.apartment.ApartmentBooked;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBooking;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistory;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistoryRepository;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.BookingPeriod;
import org.springframework.context.event.EventListener;

public class ApartmentBookingHistoryEventListener {

    private final ApartmentBookingHistoryRepository apartmentBookingHistoryRepository;

    public ApartmentBookingHistoryEventListener(ApartmentBookingHistoryRepository apartmentBookingHistoryRepository) {
        this.apartmentBookingHistoryRepository = apartmentBookingHistoryRepository;
    }

    @EventListener
    public void consume(ApartmentBooked apartmentBooked) {
        ApartmentBookingHistory apartmentBookingHistory = getApartmentBookingHistoryFor(apartmentBooked.getApartmentId());
        BookingPeriod bookingPeriod = new BookingPeriod(apartmentBooked.getPeriodStart(), apartmentBooked.getPeriodEnd());

        apartmentBookingHistory.add(ApartmentBooking.start(
                apartmentBooked.getOwnerId(), apartmentBooked.getTenantId(), bookingPeriod));
        apartmentBookingHistoryRepository.save(apartmentBookingHistory);
    }

    private ApartmentBookingHistory getApartmentBookingHistoryFor(String apartmentId) {
        if (apartmentBookingHistoryRepository.existsFor(apartmentId)) {
            return apartmentBookingHistoryRepository.findFor(apartmentId);
        } else return new ApartmentBookingHistory(apartmentId);

    }
}
