package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.RoomDto;
import com.cnpm.workingspace.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomDto> getAllRoom();
    void insertRoom(RoomDto roomDto);
    boolean updateRoom(RoomDto roomDto, int id);
    void deleteRoom(int id);
    RoomDto getRoomById(int id);
}
