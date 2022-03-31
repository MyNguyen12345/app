package com.cnpm.workingspace.controller;

import java.util.List;

import com.cnpm.workingspace.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.service.PriceService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "/api/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@GetMapping(value = "/pricee")
	public ResponseEntity<List<Price>> getAllPrice(){
		System.out.println("Price list");
        List<Price> prices = priceService.getAll();
        if(prices.size()>0){
            return new ResponseEntity<List<Price>>(prices,HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping(value = "/pricee")
	public ResponseEntity<String> insertPrice(@RequestBody Price price){
		System.out.println("aaaaaaaaaaaa");
		try {
			priceService.insertPrice(price);
			return new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error : "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PutMapping(value = "/pricee/{priceId}")
//	public ResponseEntity<String> updatePrice(@PathVariable int priceId){
//		System.out.println("put");
//		return  new ResponseEntity<>("success",HttpStatus.OK);
////		try{
////			boolean status=priceService.updatePrce(price, priceId);
////			if(status){
////				return new ResponseEntity<>("success",HttpStatus.OK);
////			} else{
////				return new ResponseEntity<>("not found price",HttpStatus.NOT_FOUND);
////			}
////		} catch (Exception e){
////			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
////		}
//	}

	@PutMapping("/pricee/{**priceId**}")
	public ResponseEntity<?> updatePrice(@PathVariable Integer id){
		return new ResponseEntity<>("put + "+id,HttpStatus.OK);
	}
}
