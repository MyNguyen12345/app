package com.cnpm.workingspace.service;

<<<<<<< Updated upstream
=======
import com.cnpm.workingspace.dto.PropertyDto;
>>>>>>> Stashed changes
import com.cnpm.workingspace.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
<<<<<<< Updated upstream
    List<Property> getAllProperty();
    void insertProperty(Property property);
    boolean updateProperty(Property property, int id);
    void deleteProperty(int id);
    Optional<Property> getPropertyById(int id);
=======
    List<PropertyDto> getAllProperty();

    void insertProperty(PropertyDto propertyDto);

    boolean updateProperty(PropertyDto propertyDto, int id);

    void deleteProperty(int id);

    PropertyDto getPropertyById(int id);

    List<Property> getPropertyByCity(String city);
>>>>>>> Stashed changes
}