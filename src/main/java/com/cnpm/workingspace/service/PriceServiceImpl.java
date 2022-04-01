package com.cnpm.workingspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
    private PriceRepository priceRepository;

	@Override
	public List<Price> getAll() {
		return priceRepository.findAll();
	}

	@Override
	public void insertPrice(Price price) {
		priceRepository.save(price);
	}

	@Override
	public boolean updatePrice(Price price, int id) {
		Optional<Price> curPrice = getPriceById(id);
		if (curPrice.isPresent()) {
			Price curPriceNew = curPrice.get();
			curPriceNew.setHourPrice(price.getHourPrice());
            curPriceNew.setDayPrice(price.getDayPrice());
            curPriceNew.setWeekPrice(price.getWeekPrice());
            curPriceNew.setMonthPrice(price.getMonthPrice());
            priceRepository.save(curPriceNew);
            return true;
		}
		return false;
	}

	@Override
	public void deletePrice(int id) {
		priceRepository.deleteById(id);
	}
	
	@Override
	public Optional<Price> getPriceById(int id) {
		return priceRepository.findById(null);
	}
	
}
