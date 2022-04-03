package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.PriceService;
import com.cnpm.workingspace.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "/propertyy")
    public ResponseEntity<?> getAllProperty(){
        System.out.println("get all property");
        List<Property> properties = propertyService.getAll();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, properties), HttpStatus.OK);
    }

    @PostMapping(value = "/propertyy")
    public ResponseEntity<?> insertProperty(@RequestBody Property property){
        System.out.println("aaaaaaaaaaaa");
        try {
            propertyService.insertProperty(property);
            return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, property), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error : "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/propertyy/{propertyId}")
    public ResponseEntity<?> updateProperty(@PathVariable int propertyId, @RequestBody PropertyDto propertyDto){
        try{
            boolean status = propertyService.updateProperty(propertyDto, propertyId);
            if(status){
                return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, propertyDto), HttpStatus.OK);
            } else{
                return new ResponseEntity<>("not found price",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/propertyy/{propertyId}")
    public ResponseEntity<String> deletePrice(@PathVariable int propertyId){
        try{
            propertyService.deleteProperty(propertyId);
            return new ResponseEntity<String>("Delete success", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
