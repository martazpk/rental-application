package com.mkopp.rentalapplication.infrastructure.rest.api.hotelroom;

import com.mkopp.rentalapplication.application.hotelRoom.RoomApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotelroom")
public class  HotelRoomRestController {
    private final RoomApplicationService roomApplicationService;

    public HotelRoomRestController(RoomApplicationService roomApplicationService) {
        this.roomApplicationService = roomApplicationService;
    }

    @PostMapping
    public void add(@RequestBody HotelRoomDto hotelRoomDto){
        roomApplicationService.add(hotelRoomDto.getHotelId(), hotelRoomDto.getNumber(), hotelRoomDto.getDescription(), hotelRoomDto.getSectionsDefinition());
    }
}
