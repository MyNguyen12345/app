package com.cnpm.workingspace.adapter;

import com.cnpm.workingspace.dto.RoomServiceDto;
import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.model.RoomService;
import com.cnpm.workingspace.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomServiceAdapter {

    @Autowired
    private RoomRepository roomRepository;

    public RoomServiceDto toRoomServiceDto(RoomService roomService) {
        return new RoomServiceDto(
                roomService.getRoomServiceId(),
                roomService.getRoom().getRoomId(),
                roomService.getRoomServiceName(),
                roomService.getQuantityAvailable(),
                roomService.getPrice()
        );
    }

    public RoomService toRoomService(RoomServiceDto roomServiceDto) {
        Room room = roomRepository.getById(roomServiceDto.getRoomId());
        RoomService roomService = new RoomService();
        roomService.setRoomServiceId(roomServiceDto.getRoomServiceId());
        roomService.setRoom(room);
        roomService.setRoomServiceName(roomServiceDto.getRoomServiceName());
        roomService.setQuantityAvailable(roomServiceDto.getQuantityAvailable());
        roomService.setPrice(roomServiceDto.getPrice());
        return roomService;
    }
}
