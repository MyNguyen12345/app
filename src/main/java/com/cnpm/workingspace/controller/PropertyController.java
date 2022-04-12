package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
<<<<<<< Updated upstream
=======
import com.cnpm.workingspace.dto.PropertyDto;
>>>>>>> Stashed changes
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
@RequestMapping("/api/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/{id}")
    public ResponseEntity<ErrorResponse> getProperty(@PathVariable int id) {
        Optional<Property> property = propertyService.getPropertyById(id);
        return property.map(value -> new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK));
    }

    @GetMapping("/properties")
    public ResponseEntity<ErrorResponse> getAllProperty() {
        List<Property> properties = propertyService.getAllProperty();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, properties), HttpStatus.OK);
    }

    @PostMapping("/property")
    public ResponseEntity<ErrorResponse> insertProperty(@RequestBody Property property) {
        propertyService.insertProperty(property);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponse> updateProperty(@PathVariable int id, @RequestBody Property property) {
        if (propertyService.updateProperty(property, id)) {
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> deleteProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, null), HttpStatus.OK);
    }

<<<<<<< Updated upstream
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.NOT_FOUND, e.getMessage()), HttpStatus.OK);
    }
=======
    @GetMapping("/getByCity")
    @ResponseBody
    public ResponseEntity<ErrorResponse> getPropertyByCity(@RequestParam String city){
        List<Property> properties = propertyService.getPropertyByCity(city);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, properties), HttpStatus.OK);
    }


>>>>>>> Stashed changes
}