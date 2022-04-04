package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAllRoom();
    void insertRoom(Room Room);
    boolean updateRoom(Room Room, int id);
    void deleteRoom(int id);
    Optional<Room> getRoomById(int id);
}
