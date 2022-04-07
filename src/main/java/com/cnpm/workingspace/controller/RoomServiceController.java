package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.adapter.RoomServiceAdapter;
import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.RoomServiceDto;
import com.cnpm.workingspace.model.RoomService;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.RoomServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findRoomServiceById(@PathVariable int id){
        try{
            Optional<RoomService> roomServiceOptional=roomServiceService.getRoomServiceById(id);
            if(roomServiceOptional.isPresent()){
                RoomService roomService=roomServiceOptional.get();
                RoomServiceDto roomServiceDto= RoomServiceAdapter.toRoomServiceDto(roomService);
                return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,roomServiceDto),HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND,null),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,null),HttpStatus.OK);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<?> insertRoomService(@RequestBody RoomServiceDto roomServiceDto){
        try{
            RoomService roomService=RoomServiceAdapter.toRoomService(roomServiceDto);
            roomServiceService.insertRoomService(roomService);
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,null),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,null),HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateRoomService(@PathVariable int id,@RequestBody RoomServiceDto roomServiceDto){
        try{
            Optional<RoomService> roomServiceOptional=roomServiceService.getRoomServiceById(id);
            if(roomServiceOptional.isPresent()){
                RoomService roomService= roomServiceOptional.get();
                RoomService newRoomService=RoomServiceAdapter.toRoomService(roomServiceDto);
                roomService.setRoom(newRoomService.getRoom());
                roomService.setRoomServiceName(newRoomService.getRoomServiceName());
                roomService.setQuantityAvailable(newRoomService.getQuantityAvailable());
                roomService.setPrice(newRoomService.getPrice());
                roomServiceService.updateRoomService(roomService,id);
                return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,null),HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND,null),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage()),HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "")
    public ResponseEntity<?> deleteRoomService(@PathVariable int id){
        try{
            roomServiceService.deleteRoomService(id);
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,null),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage()),HttpStatus.OK);
        }
    }
}
