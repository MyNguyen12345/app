package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dao.PropertyDao;
import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.model.PropertyType;
import com.cnpm.workingspace.repository.CustomerRepository;
import com.cnpm.workingspace.repository.PropertyRepository;
import com.cnpm.workingspace.repository.PropertyTypeRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImp implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    private PropertyDao propertyDao;

    @Autowired
    PropertyServiceImp (PropertyDao propertyDao, ModelMapper toDtoMapper, ModelMapper toEntityMapper){
        this.propertyDao = propertyDao;
        this.toDtoMapper = toDtoMapper;
        this.toEntityMapper = toEntityMapper;
    }

    private ModelMapper toDtoMapper;

    private ModelMapper toEntityMapper;

    public PropertyServiceImp(ModelMapper toDtoMapper) {
        this.toDtoMapper.createTypeMap(Property.class, PropertyDto.class)
                        .addMappings(mapper -> mapper.map(src -> src.getCustomer().getCustomerId(), PropertyDto::setCustomerId))
                        .addMappings(mapper -> mapper.map(src -> src.getPropertyType().getPropertyTypeId(), PropertyDto::setPropertyTypeId));
    }

    @Autowired
    public void setToEntityMapper(ModelMapper toEntityMapper) {
        Converter<Integer, Customer> customerConverter = context -> customerRepository.getById(context.getSource());
        Converter<Integer, PropertyType> propertyTypeConverter = context -> propertyTypeRepository.getById(context.getSource());
        this.toEntityMapper.createTypeMap(PropertyDto.class, Property.class)
                           .addMappings(mapper -> mapper.using(customerConverter).map(PropertyDto::getCustomerId, Property::setCustomer))
                           .addMappings(mapper -> mapper.using(propertyTypeConverter).map(PropertyDto::getPropertyTypeId, Property::setPropertyType));

    }

    @Override
    public List<PropertyDto> getAllProperty() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream().map(property -> toDtoMapper.map(property, PropertyDto.class))
                         .collect(Collectors.toList());
    }

    @Override
    public void insertProperty(PropertyDto propertyDto) {
        Property property = toEntityMapper.map(propertyDto, Property.class);
        propertyRepository.save(property);
    }

    @Override
    public boolean updateProperty(PropertyDto propertyDto, int id) {
        Optional<Property> p = propertyRepository.findById(id);
        if (p.isPresent()) {
            propertyRepository.save(toEntityMapper.map(propertyDto, Property.class));
            return true;
        }
        return false;
    }

    @Override
    public void deleteProperty(int id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public PropertyDto getPropertyById(int id) {
        Property property = propertyRepository.getById(id);
        return toDtoMapper.map(property, PropertyDto.class);
    }

    @Override
    public List<Property> getPropertyByCity(String city) {
        return propertyRepository.getPropertyByCity(city);
    }

    @Override
    public List<Property> getPropertyByCityTypeName(String city, int typeId, String name) {
        return propertyDao.getPropertyByCityTypeName(city, typeId, name);
    }
}