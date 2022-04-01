package com.cnpm.workingspace.service;

import com.cnpm.workingspace.model.Person;
import com.cnpm.workingspace.model.PropertyType;
import com.cnpm.workingspace.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTypeServiceImp implements PropertyTypeService{

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Override
    public List<PropertyType> getAllPropertyType() {
        return propertyTypeRepository.findAll();
    }

    @Override
    public void insertPropertyType(PropertyType propertyType) {
        propertyTypeRepository.save(propertyType);
    }

    @Override
    public boolean updatePropertyType(PropertyType propertyType, int id) {
        Optional<PropertyType> curPropertyType=getPropertyTypeById(id);
        if(curPropertyType.isPresent()){
            PropertyType curPropertyTypeV=curPropertyType.get();
            curPropertyTypeV.setPropertyTypeName(propertyType.getPropertyTypeName());
            curPropertyTypeV.setImage(propertyType.getImage());
            propertyTypeRepository.save(curPropertyTypeV);
            return true;
        }
        return false;
    }

    @Override
    public void deletePropertyType(int id) {
        propertyTypeRepository.deleteById(id);
    }

    @Override
    public Optional<PropertyType> getPropertyTypeById(int id) {
        return propertyTypeRepository.findById(id);
    }
}
