package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Person;
import com.cnpm.workingspace.model.PropertyType;

import java.util.List;
import java.util.Optional;

public interface PropertyTypeService {
    List<PropertyType> getAllPropertyType();
    void insertPropertyType(PropertyType propertyType);
    boolean updatePropertyType(PropertyType propertyType,int id);
    void deletePropertyType(int id);
    Optional<PropertyType> getPropertyTypeById(int id);
}
