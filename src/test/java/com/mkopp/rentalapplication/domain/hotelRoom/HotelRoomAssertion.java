package com.mkopp.rentalapplication.domain.hotelRoom;

import org.assertj.core.api.Assertions;

public class HotelRoomAssertion {
    private final HotelRoom actual;

    public HotelRoomAssertion(HotelRoom actual) {
        this.actual = actual;
    }

    public static HotelRoomAssertion assertThat(HotelRoom actual) {
        return new HotelRoomAssertion(actual);
    }

    public HotelRoomAssertion hasHotelIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("hotelId", expected);
        return this;
    }

    public HotelRoomAssertion hasRoomNumberEqualTo(int expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("number", expected);
        return this;
    }

    public HotelRoomAssertion hasDescriptionEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("description", expected);
        return this;
    }
}
