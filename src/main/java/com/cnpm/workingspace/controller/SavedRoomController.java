package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.SavedRoomDto;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.SavedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SavedRoomController {

    @Autowired
    SavedRoomService savedRoomService;

    @GetMapping("/saved_rooms")
    public ResponseEntity<?> getAll() {
        List<SavedRoomDto> savedRoomDtos = savedRoomService.getAll();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, savedRoomDtos), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}/saved_rooms")
    public ResponseEntity<?> getByCustomerId(@PathVariable int customerId) {
        List<SavedRoomDto> savedRoomDtos = savedRoomService.getByCustomerId(customerId);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, savedRoomDtos), HttpStatus.OK);
    }

    @PostMapping("/saved_rooms")
    public ResponseEntity<?> insert(@RequestBody SavedRoomDto savedRoomDto) {
        savedRoomService.insert(savedRoomDto);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @DeleteMapping("/saved_rooms")
    public ResponseEntity<?> delete(@RequestBody SavedRoomDto savedRoomDto) {
        savedRoomService.delete(savedRoomDto);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }
}
