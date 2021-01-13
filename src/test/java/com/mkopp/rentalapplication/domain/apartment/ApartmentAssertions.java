package com.mkopp.rentalapplication.domain.apartment;

import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class ApartmentAssertions {
    private Apartment actual;

    public ApartmentAssertions(Apartment actual) {
        this.actual = actual;
    }

    public static ApartmentAssertions assertThat(Apartment actual) {
       return new ApartmentAssertions(actual);
    }

    public ApartmentAssertions hasOwnerId(String ownerId) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId", ownerId);
        return this;
    }

    public ApartmentAssertions hasAddress(String street, String postalCode, String houseNumber, String apartmentNumber, String city, String country) {
        Assertions.assertThat(actual).extracting("address")
                .hasFieldOrPropertyWithValue("street", street)
                .hasFieldOrPropertyWithValue("postalCode", postalCode)
                .hasFieldOrPropertyWithValue("houseNumber", houseNumber)
                .hasFieldOrPropertyWithValue("apartmentNumber", apartmentNumber)
                .hasFieldOrPropertyWithValue("city", city)
                .hasFieldOrPropertyWithValue("country", country);
        return this;
    }

    public ApartmentAssertions hasRooms(Map<String, Double> roomsDefinition) {
        Assertions.assertThat(actual).extracting("rooms").satisfies(roomsActual -> {
            List<Room> rooms = (List<Room>) roomsActual; // may throw an exception when it will not be possible to cast
            Assertions.assertThat(rooms).hasSize(roomsDefinition.size());

            roomsDefinition.forEach((name, squareMeter) -> {
                Assertions.assertThat(rooms).anySatisfy(room -> {
                    Assertions.assertThat(room)
                            .hasFieldOrPropertyWithValue("name", name)
                            .hasFieldOrPropertyWithValue("squareMeter.size", squareMeter);
                });
            });
        });
        return this;
    }

    public ApartmentAssertions hasDescription(String description) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("description", description);
        return this;
    }
}
