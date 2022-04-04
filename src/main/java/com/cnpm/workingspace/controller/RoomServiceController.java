package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.model.RoomService;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.RoomServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/room_service")
public class RoomServiceController {
    @Autowired
    private RoomServiceService roomServiceService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllRoomServices(){
        try {
            List<RoomService> roomServices=roomServiceService.getAllRoomServices();
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, roomServices), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage()),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<?> getNumber(@PathVariable Integer number){
        try {
            System.out.println("number : "+number);
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, roomServiceService.testQuery(number)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage()),HttpStatus.OK);
        }
    }
}
