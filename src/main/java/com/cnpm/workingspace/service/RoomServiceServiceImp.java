package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.model.RoomService;
import com.cnpm.workingspace.repository.RoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void insertRoomService(RoomService roomService) {
        roomServiceRepository.save(roomService);
    }

    @Override
    public boolean updateRoomService(RoomService roomService, int id) {
        Optional<RoomService> r = roomServiceRepository.findById(id);
        if (r.isPresent()) {
            roomServiceRepository.save(roomService);
            return true;
        }
        return false;
    }

    @Override
    public void deleteRoomService(int id) {
        roomServiceRepository.deleteById(id);
    }

    @Override
    public Optional<RoomService> getRoomServiceById(int id) {
        return roomServiceRepository.findById(id);
    }
}
