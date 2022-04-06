package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService RoomService;

    @GetMapping("/{id}")
    public ResponseEntity<ErrorResponse> getRoom(@PathVariable int id) {
        Optional<Room> Room = RoomService.getRoomById(id);
        return Room.map(value -> new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, value), HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK));
    }

    @GetMapping("/rooms")
    public ResponseEntity<ErrorResponse> getAllRoom() {
        List<Room> properties = RoomService.getAllRoom();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, properties), HttpStatus.OK);
    }

    @PostMapping("/room")
    public ResponseEntity<ErrorResponse> insertRoom(@RequestBody Room Room) {
        RoomService.insertRoom(Room);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponse> updateRoom(@PathVariable int id, @RequestBody Room Room) {
        if (RoomService.updateRoom(Room, id)) {
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> deleteRoom(@PathVariable int id) {
        RoomService.deleteRoom(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, e.getMessage()), HttpStatus.OK);
    }
}
