package com.mkopp.rentalapplication.query.hotelRoom;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HOTEL_ROOM")
public class HotelRoomReadModel {
    @Id
    @GeneratedValue
    private String id;
    private String hotelId;
    private int number;
    private String description;
    @OneToMany
    private List<SpaceReadModel> spaceList;
}
