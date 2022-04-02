package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.model.Person;
import com.cnpm.workingspace.model.PropertyType;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.PersonService;
import com.cnpm.workingspace.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/property_type")
public class PropertyTypeController {
    @Autowired
    private PropertyTypeService propertyTypeService;

    @GetMapping(value = "property_type/{id}")
    public ResponseEntity<?> getPropertyType(@PathVariable(value = "id") int id){
        Optional<PropertyType> propertyType=propertyTypeService.getPropertyTypeById(id);
        if(propertyType.isPresent()){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,propertyType.get()),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND,null),HttpStatus.OK);
        }
    }

    @GetMapping(value = "property_types")
    public ResponseEntity<?> getAllPropertyTypes(){
        List<PropertyType> propertyTypes=propertyTypeService.getAllPropertyType();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,propertyTypes),HttpStatus.OK);
    }

    @PostMapping(value = "property_type")
    public ResponseEntity<?> insertPropertyType(@RequestBody PropertyType propertyType){
        try{
            System.out.println("post method");
            System.out.println("propertyType : "+propertyType);
            propertyTypeService.insertPropertyType(propertyType);
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,null),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.ERROR,e.getMessage()),HttpStatus.OK);
        }
    }

    @PutMapping(value = "property_type/{id}")
    public ResponseEntity<?> updatePropertyType(@PathVariable int id,@RequestBody PropertyType propertyType){
        try{
            boolean status=propertyTypeService.updatePropertyType(propertyType,id);
            if(status){
                return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,null),HttpStatus.OK);
            } else{
                return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND,null),HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage()),HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "property_type/{id}")
    public ResponseEntity<?> deletePropertyType(@PathVariable int id){
        try{
            propertyTypeService.deletePropertyType(id);
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS,null),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage()),HttpStatus.OK);
        }
    }
}
