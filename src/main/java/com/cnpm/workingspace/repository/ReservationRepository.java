package com.cnpm.workingspace.repository;

import com.cnpm.workingspace.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
