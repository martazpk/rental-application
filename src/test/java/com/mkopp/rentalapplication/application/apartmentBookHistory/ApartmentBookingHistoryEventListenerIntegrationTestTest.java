package com.mkopp.rentalapplication.application.apartmentBookHistory;

import com.google.common.collect.ImmutableMap;
import com.mkopp.rentalapplication.application.apartment.ApartmentApplicationService;
import com.mkopp.rentalapplication.domain.apartment.Apartment;
import com.mkopp.rentalapplication.domain.apartment.ApartmentFactory;
import com.mkopp.rentalapplication.domain.apartment.ApartmentRepository;
import com.mkopp.rentalapplication.domain.apartment.RentalType;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBooking;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingAssertions;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistory;
import com.mkopp.rentalapplication.domain.apartmentBookHistory.ApartmentBookingHistoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@SpringBootTest
class ApartmentBookingHistoryEventListenerIntegrationTestTest {
    private static final String OWNER_ID = "123";
    private static final String STREET = "zielona";
    private static final String POSTAL_CODE = "32-030";
    private static final String HOUSE_NUMBER = "12";
    private static final String APARTMENT_NUMBER = "12";
    private static final String CITY = "Cracow";
    private static final String COUNTRY = "Poland";
    private static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of("toilet", 10.0, "bedroom", 20.0);
    private static final String DESCRIPTION = "Nice place to stay";

    @Autowired
    private ApartmentApplicationService apartmentApplicationService;

    @Autowired
    private ApartmentBookingHistoryRepository bookingHistory;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    @Transactional
    void shouldUpdateApartmentHistory() {
        String apartmentId = givenExistingApartment();
        String tenantId = "3344";
        RentalType rentalType = RentalType.APARTMENT;
        LocalDate start = LocalDate.of(2021, 17, 01);
        LocalDate end = LocalDate.of(2021, 17, 02);

        apartmentApplicationService.book(apartmentId, tenantId, rentalType, start, end);
        ApartmentBookingHistory actual = bookingHistory.findFor(apartmentId);

        Assertions.assertThat(actual).extracting("bookings").satisfies(actualBookings -> {
                    List<ApartmentBooking> bookings = (List<ApartmentBooking>) actualBookings;
                    Assertions.assertThat(bookings).hasSize(1)
                            .allSatisfy(booking -> {
                                ApartmentBookingAssertions.assertThat(booking)
                                        .hasOwnerIdEqualTo(OWNER_ID)
                                        .hasTenantIdEqualTo(tenantId)
                                        .hasBookingPeriodThatHas(start, end);
                            });
                }
        );
    }

    private String givenExistingApartment() {
       return apartmentRepository.save(createApartment());
    }

    private Apartment createApartment() {
        return new ApartmentFactory().create(
                OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER,
                CITY, COUNTRY, ROOMS_DEFINITION, DESCRIPTION);
    }
}