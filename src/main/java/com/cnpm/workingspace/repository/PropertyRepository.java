package com.cnpm.workingspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnpm.workingspace.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
