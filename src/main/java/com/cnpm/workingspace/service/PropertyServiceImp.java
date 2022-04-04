package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImp implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public void insertProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public boolean updateProperty(Property property, int id) {
        Optional<Property> p = propertyRepository.findById(id);
        if (p.isPresent()) {
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
