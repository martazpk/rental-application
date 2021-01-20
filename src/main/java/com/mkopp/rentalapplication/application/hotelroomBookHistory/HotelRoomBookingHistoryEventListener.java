package com.mkopp.rentalapplication.application.hotelroomBookHistory;

import com.mkopp.rentalapplication.domain.hotelBookHistory.HotelBookingHistory;
import com.mkopp.rentalapplication.domain.hotelBookHistory.HotelBookingHistoryRepository;
import com.mkopp.rentalapplication.domain.hotelBookHistory.HotelRoomBooking;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomBooked;
import org.springframework.context.event.EventListener;

import java.util.Optional;

public class HotelRoomBookingHistoryEventListener {
    private final HotelBookingHistoryRepository hotelBookingHistoryRepository;

    public HotelRoomBookingHistoryEventListener(HotelBookingHistoryRepository hotelBookingHistoryRepository) {
        this.hotelBookingHistoryRepository = hotelBookingHistoryRepository;
    }

    @EventListener
    public void consume(HotelRoomBooked hotelRoomBooked) {
        String roomId = hotelRoomBooked.getHotelRoomId();
        HotelRoomBooking newBooking = HotelRoomBooking.start(
                hotelRoomBooked.getEventCreationDateTime(), roomId, hotelRoomBooked.getHotelId(),
                hotelRoomBooked.getDates(), hotelRoomBooked.getTenantId());

        HotelBookingHistory history = getFor(roomId);
        history.add(newBooking);
        hotelBookingHistoryRepository.save(history);
    }

    private HotelBookingHistory getFor(String roomId) {
        Optional<HotelBookingHistory> optional = hotelBookingHistoryRepository.getFor(roomId);
        return optional.orElseGet(() -> new HotelBookingHistory(roomId));
    }
}
