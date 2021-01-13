package com.mkopp.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableMap;
import com.mkopp.rentalapplication.domain.eventchannel.EventChannel;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

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
    private static final String TENANT_ID = "654";
    private static final LocalDate START = LocalDate.of(2020, 12, 12);
    private static final LocalDate MIDDLE = LocalDate.of(2020, 12, 13);
    private static final LocalDate END = LocalDate.of(2020, 12, 14);
    private static final Period PERIOD = new Period(START, END);
    private final EventChannel eventChannel = mock(EventChannel.class);

    ApartmentFactory apartmentFactory = new ApartmentFactory();

    @Test
    void shouldCreateApartmentWithAllRequiredFields() {

        Apartment actual = createApartment();

        ApartmentAssertions.assertThat(actual)
                .hasOwnerId(OWNER_ID)
                .hasAddress(STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY)
                .hasRooms(ROOMS_DEFINITION)
                .hasDescription(DESCRIPTION);
    }

    private Apartment createApartment() {
        return apartmentFactory.create(
                OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER,
                CITY, COUNTRY, ROOMS_DEFINITION, DESCRIPTION);
    }

    @Test
    void shouldCreateBooking() {
        Apartment apartment = createApartment();

        Booking actual = apartment.book(TENANT_ID, PERIOD, RentalType.APARTMENT, eventChannel);

        BookingAssertions.assertThat(actual)
                .hasTenantIdEqualTo(TENANT_ID)
                .hasAllDays(List.of(START, MIDDLE, END))
                .isApartment();
    }

    @Test
    void shouldPublishApartmentBooked() {
        Apartment apartment = createApartment();
        ArgumentCaptor<ApartmentBooked> captor = ArgumentCaptor.forClass(ApartmentBooked.class);

        apartment.book(TENANT_ID, PERIOD, RentalType.APARTMENT, eventChannel);

        then(eventChannel).should().publish(captor.capture());
        ApartmentBooked actual = captor.getValue();

        assertThat(actual.getPeriodStart()).isEqualTo(START);
        assertThat(actual.getPeriodEnd()).isEqualTo(END);
        assertThat(actual.getTenantId()).isEqualTo(TENANT_ID);
        assertThat(actual.getOwnerId()).isEqualTo(OWNER_ID);
    }
}