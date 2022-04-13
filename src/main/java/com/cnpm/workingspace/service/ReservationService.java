package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.dto.ReservationDto;
import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<ReservationDto> getAllReservation();

    void insertReservation(ReservationDto reservationDto);

    boolean updateReservation(ReservationDto reservationDto, int id);

    void deleteReservation(int id);

    ReservationDto getReservationById(int id);
}
