package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.model.RoomService;
import java.util.List;
import java.util.Optional;

public interface RoomServiceService {
    public List<RoomService> getAllRoomServices();
    public Integer testQuery(Integer number);
    void insertRoomService(RoomService roomService);
    boolean updateRoomService(RoomService roomService, int id);
    void deleteRoomService(int id);
    Optional<RoomService> getRoomServiceById(int id);
}
