package com.mkopp.rentalapplication.infrastructure.rest.api.hotelroom;

import com.mkopp.rentalapplication.application.hotelRoom.RoomApplicationService;
import com.mkopp.rentalapplication.query.hotel.HotelReadModel;
import com.mkopp.rentalapplication.query.hotel.QueryHotelRepository;
import com.mkopp.rentalapplication.query.hotelRoom.HotelRoomQueryRepository;
import com.mkopp.rentalapplication.query.hotelRoom.HotelRoomReadModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelroom")
public class  HotelRoomRestController {
    private final RoomApplicationService roomApplicationService;
    private final QueryHotelRepository queryHotelRepository;
    private final HotelRoomQueryRepository hotelRoomQueryRepository;

    public HotelRoomRestController(RoomApplicationService roomApplicationService, QueryHotelRepository queryHotelRepository, HotelRoomQueryRepository hotelRoomQueryRepository) {
        this.roomApplicationService = roomApplicationService;
        this.queryHotelRepository = queryHotelRepository;
        this.hotelRoomQueryRepository = hotelRoomQueryRepository;
    }

    @PostMapping
    public void add(@RequestBody HotelRoomDto hotelRoomDto){
        roomApplicationService.add(hotelRoomDto.getHotelId(), hotelRoomDto.getNumber(), hotelRoomDto.getDescription(), hotelRoomDto.getSectionsDefinition());
    }

    @PutMapping("book/{id}")
    public void book(@PathVariable String id, @RequestBody HotelRoomBookingDto dto){
        roomApplicationService.book(id, dto.getTenantId(), dto.getDates());
    }

    @GetMapping
    public Iterable<HotelReadModel> getAll(){
        return queryHotelRepository.findAll();
    }

    @GetMapping("/hotel/{hotelId}")
    public List<HotelRoomReadModel> getRoomsByHotelId(@PathVariable String hotelId){
        return hotelRoomQueryRepository.findByHotelId(hotelId);
    }
}
