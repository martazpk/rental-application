package com.mkopp.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ApartmentTest {

    private static final String OWNER_ID = "123";
    private static final String STREET = "zielona";
    private static final String POSTAL_CODE = "32-030";
    private static final String HOUSE_NUMBER = "12";
    private static final String APARTMENT_NUMBER = "12";
    private static final String CITY = "Cracow";
    private static final String COUNTRY = "Poland";
    private static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of("toilet", 10.0, "bedroom", 20.0);
    private static final String DESCRIPTION = "Nice place to stay";
    ApartmentFactory apartmentFactory = new ApartmentFactory();

    @Test
    void shouldCreateApartmentWithAllRequiredFields() {

        Apartment actual = apartmentFactory.create(
                OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER,
                CITY, COUNTRY, ROOMS_DEFINITION, DESCRIPTION);

        ApartmentAssertions.assertThat(actual)
                .hasOwnerId(OWNER_ID)
                .hasAddress(STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY)
                .hasRooms(ROOMS_DEFINITION)
                .hasDescription(DESCRIPTION);
    }

}