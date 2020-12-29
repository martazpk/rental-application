package com.mkopp.rentalapplication.infrastructure.rest.api.hotelroom;

import com.mkopp.rentalapplication.application.hotelRoom.RoomApplicationService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("book/{id}")
    public void book(@PathVariable String id, @RequestBody HotelRoomBookingDto dto){
        roomApplicationService.book(id, dto.getTenantId(), dto.getDates());
    }
}
