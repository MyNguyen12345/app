package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<Property> getAllProperty();
    void insertProperty(Property property);
    boolean updateProperty(Property property, int id);
    void deleteProperty(int id);
    Optional<Property> getPropertyById(int id);
}
