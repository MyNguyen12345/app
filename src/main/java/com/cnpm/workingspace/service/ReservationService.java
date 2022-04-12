package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<PropertyDto> getAllProperty();

    void insertProperty(PropertyDto propertyDto);

    boolean updateProperty(PropertyDto propertyDto, int id);

    void deleteProperty(int id);

    PropertyDto getPropertyById(int id);

    Optional<Reservation> getPriceById(int id);
}
