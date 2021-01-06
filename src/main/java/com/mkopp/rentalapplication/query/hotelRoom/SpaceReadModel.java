package com.mkopp.rentalapplication.query.hotelRoom;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Entity
@Table(name = "ROOM_SPACE")
public class SpaceReadModel {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private Double squareMeter;


}
