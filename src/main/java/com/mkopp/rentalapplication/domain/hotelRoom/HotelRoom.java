package com.mkopp.rentalapplication.domain.hotelRoom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class HotelRoom {
    @Id
    @GeneratedValue
    private String id;
    private String hotelId;
    private int number;
    private String description;
    @OneToMany
    private List<Section> sections;

    HotelRoom(String hotelId, int number, String description, List<Section> sections) {
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.sections = sections;
    }

    protected HotelRoom() {
    }
}
