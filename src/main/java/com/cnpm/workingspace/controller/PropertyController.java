package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/{id}")
    public ResponseEntity<ErrorResponse> getProperty(@PathVariable int id) {
        PropertyDto propertyDto = propertyService.getPropertyById(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, propertyDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ErrorResponse> getAllProperty() {
        List<PropertyDto> properties = propertyService.getAllProperty();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, properties), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ErrorResponse> insertProperty(@RequestBody PropertyDto propertyDto) {
        propertyService.insertProperty(propertyDto);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponse> updateProperty(@PathVariable int id, @RequestBody PropertyDto PropertyDto) {
        if (propertyService.updateProperty(PropertyDto, id)) {
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> deleteProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @GetMapping("/getByCity")
    @ResponseBody
    public ResponseEntity<ErrorResponse> getPriceOrder(@RequestParam String city){
        List<Property> properties = propertyService.getPropertyByCity(city);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, properties), HttpStatus.OK);
    }
}