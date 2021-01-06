package com.mkopp.rentalapplication.query.apartment;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "APARTMENT_ROOM")
public class RoomReadModel {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private Double size;;

    public RoomReadModel(String id, String name, Double size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public RoomReadModel() {
    }
}
