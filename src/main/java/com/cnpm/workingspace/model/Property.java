package com.cnpm.workingspace.model;

public class Property {

	private int propertyId;
	
	private int customerId;
	
	private  propertyId;
    property_type_id INT          NOT NULL,
    property_name    VARCHAR(255) NOT NULL,
    address          VARCHAR(255) NOT NULL,
    room_quantity    INT          NOT NULL,
    createDate       DATETIME     NOT NULL,
    description      TEXT,
    rating           DOUBLE,
    lat 			 DOUBLE,
    longg			 DOUBLE,
    image    		 VARCHAR(255) NOT NULL,
}
