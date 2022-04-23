package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAllRoom();
    void insertRoom(RoomDto roomDto);
    boolean updateRoom(RoomDto roomDto, int id);
    void deleteRoom(int id);
    RoomDto getRoomById(int id);
    List<RoomDto> getByPropertyId(int propertyId);
}
