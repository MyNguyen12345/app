package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.PropertyDto;;
import com.cnpm.workingspace.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<PropertyDto> getAllProperty();

    void insertProperty(PropertyDto propertyDto);

    boolean updateProperty(PropertyDto propertyDto, int id);

    void deleteProperty(int id);

    PropertyDto getPropertyById(int id);

    List<Property> getPropertyByCity(String city);

    List<Property> getPropertyByCityTypeName(String city, int typeId, String name);
}