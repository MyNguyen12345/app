package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImp implements RoomService{
    @Autowired
    private RoomRepository RoomRepository;

    @Override
    public List<Room> getAllRoom() {
        return RoomRepository.findAll();
    }

    @Override
    public void insertRoom(Room Room) {
        RoomRepository.save(Room);
    }

    @Override
    public boolean updateRoom(Room Room, int id) {
        Optional<Room> r = RoomRepository.findById(id);
        if (r.isPresent()) {
            RoomRepository.save(Room);
            return true;
        }
        return false;
    }

    @Override
    public void deleteRoom(int id) {
        RoomRepository.deleteById(id);
    }

    @Override
    public Optional<Room> getRoomById(int id) {
        return RoomRepository.findById(id);
    }
}
