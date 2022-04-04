package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.RoomService;
import java.util.List;

public interface RoomServiceService {
    public List<RoomService> getAllRoomServices();
    public Integer testQuery(Integer number);
}
