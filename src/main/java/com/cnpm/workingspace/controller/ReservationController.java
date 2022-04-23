package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.ReservationDto;
import com.cnpm.workingspace.sdo.DateStatus;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{id}")
    public ResponseEntity<ErrorResponse> getReservation(@PathVariable int id) {
        ReservationDto reservationDto = reservationService.getReservationById(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, reservationDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ErrorResponse> getAllReservation() {
        List<ReservationDto> reservationDtos = reservationService.getAllReservation();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, reservationDtos), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ErrorResponse> insertProperty(@RequestBody ReservationDto reservationDto) {
        reservationService.insertReservation(reservationDto);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponse> updateReservation(@PathVariable int id, @RequestBody ReservationDto reservationDto) {
        if (reservationService.updateReservation(reservationDto, id)) {
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @GetMapping(value = "/date_status/{roomId}")
    public ResponseEntity<?> getDateStatus(@PathVariable int roomId, @RequestParam int month, @RequestParam int year){
        List<DateStatus> cur=reservationService.getDateStatus(roomId,month,year);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, cur), HttpStatus.OK);
    }
}
