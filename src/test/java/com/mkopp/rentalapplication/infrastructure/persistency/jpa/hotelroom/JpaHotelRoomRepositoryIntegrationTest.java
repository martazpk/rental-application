package com.mkopp.rentalapplication.infrastructure.persistency.jpa.hotelroom;

import com.google.common.collect.ImmutableMap;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoom;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomAssertion;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomFactory;
import com.mkopp.rentalapplication.domain.hotelRoom.HotelRoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

@SpringBootTest
class JpaHotelRoomRepositoryIntegrationTest {
    private static final String HOTEL_ID = "123";
    private static final int NUMBER = 12;
    private static final String DESCRIPTION = "description";
    private static final ImmutableMap<String, Double> SECTIONS_DEFINITION = ImmutableMap.of("bedroom", 20.0);
    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Test
    void shouldThrowExceptionWhenHotelRoomDoesNotExist() {
        String id = UUID.randomUUID().toString();
        Assertions.assertThrows(HotelRoomDoesNotExistException.class, () ->
                hotelRoomRepository.getById(id));
    }

    @Test
    @Transactional
    void shouldFindExistingRoom() {
        HotelRoom hotelRoom = createRoom();
        String id = hotelRoomRepository.save(hotelRoom);

        HotelRoom actual = hotelRoomRepository.getById(id);

        HotelRoomAssertion.assertThat(actual)
                .hasHotelIdEqualTo(HOTEL_ID)
                .hasRoomNumberEqualTo(NUMBER)
                .hasDescriptionEqualTo(DESCRIPTION);
    }

    private HotelRoom createRoom() {
        return new HotelRoomFactory()
                .create(HOTEL_ID, NUMBER, DESCRIPTION, SECTIONS_DEFINITION);
    }
}