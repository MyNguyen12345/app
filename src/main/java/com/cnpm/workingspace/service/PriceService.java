package com.cnpm.workingspace.service;

import java.util.List;
import java.util.Optional;

import com.cnpm.workingspace.model.Person;
import com.cnpm.workingspace.model.Price;

public interface PriceService {
	List<Price> getAll();
	
	void insertPrice(Price price);
	
    boolean updatePerson(Price price, int id);
    
    void deletePerson(int id);
    
    Optional<Price> getPriceById(int id);
}
