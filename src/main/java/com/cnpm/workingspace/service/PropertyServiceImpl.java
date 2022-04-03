package com.cnpm.workingspace.service;

import java.util.List;
import java.util.Optional;

import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.model.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyTypeService propertyTypeService;
	
	@Override
	public List<Property> getAll() {
		return propertyRepository.findAll();
	}
	
	@Override
	public void insertProperty(Property property) {
		propertyRepository.save(property);
	}
	
	@Override
	public boolean updateProperty(PropertyDto propertyDto, int id) {
		Optional<PropertyType> propertyType = propertyTypeService.getPropertyTypeById(propertyDto.getPropertyTypeId());
		if (propertyType.isPresent() && getPropertyById(id).isPresent()) {
			PropertyType propertyTypeNew = propertyType.get();
			Property property = getPropertyById(id).get();
			property.setPropertyName(propertyDto.getPropertyName());
			property.setPropertyType(propertyTypeNew);
			property.setAddress(propertyDto.getAddress());
			property.setImage(propertyDto.getImage());
			property.setDescription(propertyDto.getDescription());
			property.setCreateDate(propertyDto.getCreateDate());
			property.setLat(propertyDto.getLat());
			property.setLon(propertyDto.getLon());
			property.setRating(propertyDto.getRating());
			property.setRoomQuantity(propertyDto.getRoomQuantity());
			propertyRepository.save(property);
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteProperty(int id) {
		propertyRepository.deleteById(id);
	}
	
	@Override
	public Optional<Property> getPropertyById(int id) {
		return propertyRepository.findById(id);
	}
	
	
}
