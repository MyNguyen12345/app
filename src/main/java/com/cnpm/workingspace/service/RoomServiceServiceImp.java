package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.RoomService;
import com.cnpm.workingspace.repository.RoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceServiceImp implements RoomServiceService {

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    @Override
    public List<RoomService> getAllRoomServices() {
        return roomServiceRepository.getAllRoomServices();
    }

    @Override
    public Integer testQuery(Integer number) {
        return roomServiceRepository.testQuery(number);
    }
}
