package com.cnpm.workingspace.adapter;

import com.cnpm.workingspace.dto.RoomServiceDto;
import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.model.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoomServiceAdapter {
    @Autowired
    private static com.cnpm.workingspace.service.RoomService roomService;
    public static RoomServiceDto toRoomServiceDto(RoomService roomService){
        return new RoomServiceDto(
                roomService.getRoomServiceId(),
                roomService.getRoom().getRoomId(),
                roomService.getRoomServiceName(),
                roomService.getQuantityAvailable(),
                roomService.getPrice()
        );
    }

    public static RoomService toRoomService(RoomServiceDto roomServiceDto){
        // Optional<Room> roomOptional=roomService.getRoomById(roomServiceDto.getRoomId());
        // if(roomOptional.isPresent()){
        //     Room room=roomOptional.get();
        //     RoomService roomService=new RoomService();
        //     roomService.setRoomServiceId(roomServiceDto.getRoomServiceId());
        //     roomService.setRoom(room);
        //     roomService.setRoomServiceName(roomServiceDto.getRoomServiceName());
        //     roomService.setQuantityAvailable(roomServiceDto.getQuantityAvailable());
        //     roomService.setPrice(roomServiceDto.getPrice());
        //     return roomService;
        // }
        return null;

    }
}
