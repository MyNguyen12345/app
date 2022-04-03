package com.cnpm.workingspace.service;

import java.util.List;
import java.util.Optional;

import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Property;

public interface PropertyService {
	List<Property> getAll();

	void insertProperty(Property property);

	boolean updateProperty(PropertyDto propertyDto, int id);

	void deleteProperty(int id);

	Optional<Property> getPropertyById(int id);
}
