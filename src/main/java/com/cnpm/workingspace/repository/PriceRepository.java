package com.cnpm.workingspace.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cnpm.workingspace.model.Price;

import java.util.List;

@Qualifier("price")
@Repository
public interface PriceRepository extends JpaRepository<Price,Integer> {
    List<Price> getPriceOrder(String nameCol, String sort);
}
