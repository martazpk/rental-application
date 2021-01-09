package com.mkopp.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ApartmentTest {

    @Test
    void shouldCreateApartmentWithAllRequiredFields() {
        String ownerId = "123";
        String street = "zielona";
        String postalCode = "32-030";
        String houseNumber = "12";
        String apartmentNumber = "12";
        String city = "Cracow";
        String country = "Poland";
        Map<String, Double> roomsDefinition = ImmutableMap.of("toilet", 10.0, "bedroom", 20.0);
        String description = "Nice place to stay";

        Apartment actual = new ApartmentFactory().create(
                ownerId, street, postalCode, houseNumber, apartmentNumber,
                city, country, roomsDefinition, description);

        assertThatHasOwnerId(actual, ownerId);
        assertThatHasAddress(actual, street, postalCode, houseNumber, apartmentNumber, city, country);
        assertThatHasRooms(actual, roomsDefinition);
        assertThatHasDescription(actual, description);
    }

    private void assertThatHasDescription(Apartment actual, String description) {
        assertThat(actual).hasFieldOrPropertyWithValue("description", description);
    }

    private void assertThatHasRooms(Apartment actual, Map<String, Double> roomsDefinition) {
        assertThat(actual).extracting("rooms").satisfies(roomsActual -> {
            List<Room> rooms = (List<Room>) roomsActual; // may throw an exception when it will not be possible to cast
            assertThat(rooms).hasSize(roomsDefinition.size());

            roomsDefinition.forEach((name, squareMeter) -> {
                assertThat(rooms).anySatisfy(room -> {
                    assertThat(room)
                            .hasFieldOrPropertyWithValue("name", name)
                            .hasFieldOrPropertyWithValue("squareMeter.size", squareMeter);
                });
            });
        });
    }

    private void assertThatHasAddress(Apartment actual, String street, String postalCode, String houseNumber,
                                      String apartmentNumber, String city, String country) {
        assertThat(actual).extracting("address")
                .hasFieldOrPropertyWithValue("street", street)
                .hasFieldOrPropertyWithValue("postalCode", postalCode)
                .hasFieldOrPropertyWithValue("houseNumber", houseNumber)
                .hasFieldOrPropertyWithValue("apartmentNumber", apartmentNumber)
                .hasFieldOrPropertyWithValue("city", city)
                .hasFieldOrPropertyWithValue("country", country);
    }

    private void assertThatHasOwnerId(Apartment actual, String ownerId) {
// we dont use getter!!!!! we dont need getters in our entity for test
        assertThat(actual).hasFieldOrPropertyWithValue("ownerId", ownerId);
    }
}