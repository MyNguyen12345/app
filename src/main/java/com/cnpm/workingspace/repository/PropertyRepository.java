package com.cnpm.workingspace.repository;

import com.cnpm.workingspace.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    final String GET_PROPERTY_BY_CITY="SELECT * FROM property WHERE city LIKE %:city%";

    @Query(value = GET_PROPERTY_BY_CITY, nativeQuery = true)
    List<Property> getPropertyByCity(String city);
}