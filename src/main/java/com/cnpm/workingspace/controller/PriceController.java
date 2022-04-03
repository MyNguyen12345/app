package com.cnpm.workingspace.controller;

import java.util.List;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.security.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.service.PriceService;
import com.cnpm.workingspace.service.PriceServiceImpl;

@RestController
@RequestMapping(value = "/api/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@GetMapping(value = "/pricee")
	public ResponseEntity<?> getAllPrice(){
        List<Price> prices = priceService.getAll();
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, prices),HttpStatus.OK);
    }
	
	@PostMapping(value = "/pricee")
	public ResponseEntity<String> insertPrice(@RequestBody Price price){
		try {
			priceService.insertPrice(price);
			return new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error : "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/pricee/{priceId}")
	public ResponseEntity<String> updatePrice(@PathVariable int priceId, @RequestBody Price price){
		try{
			boolean status = priceService.updatePrice(price, priceId);
			if(status){
				return new ResponseEntity<>("success",HttpStatus.OK);
			} else{
				return new ResponseEntity<>("not found price",HttpStatus.NOT_FOUND);
			}
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/pricee/{priceId}")
	public ResponseEntity<String> deletePrice(@PathVariable int priceId){
		try{
			priceService.deletePrice(priceId);
            return new ResponseEntity<String>("Delete success", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

}
