package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.RoomDto;
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
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService RoomService;

    @GetMapping("/rooms/{id}")
    public ResponseEntity<ErrorResponse> getRoom(@PathVariable int id) {
        RoomDto roomDto = RoomService.getRoomById(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, roomDto), HttpStatus.OK);
    }

    @GetMapping("/rooms")
    public ResponseEntity<ErrorResponse> getAllRoom() {
        List<RoomDto> rooms = RoomService.getAllRoom();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, rooms), HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<ErrorResponse> insertRoom(@RequestBody RoomDto roomDto) {
        RoomService.insertRoom(roomDto);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<ErrorResponse> updateRoom(@PathVariable int id, @RequestBody RoomDto roomDto) {
        if (RoomService.updateRoom(roomDto, id)) {
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<ErrorResponse> deleteRoom(@PathVariable int id) {
        RoomService.deleteRoom(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @GetMapping("/properties/{propertyId}/rooms")
    public ResponseEntity<?> getRoomByPropertyId(@PathVariable int propertyId) {
        List<RoomDto> rooms = RoomService.getByPropertyId(propertyId);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, rooms), HttpStatus.OK);
    }
}
