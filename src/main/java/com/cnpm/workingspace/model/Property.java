package com.cnpm.workingspace.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="property")
public class Property {

	@Id
	@Column(name="property_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	
	@Column(name="customer_id")
	private int customerId;

	@ManyToOne()
	@JoinColumn(name="property_type_id", referencedColumnName = "property_type_id")
	private PropertyType propertyType;
	
	@Column(name="property_name")
	private String propertyName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="room_quantity")
	private int roomQuantity;
	
	@Column(name="createDate")
	private LocalDate createDate;

	@Column(name="description")
	private String description;
	
	@Column(name="rating")
	private Double rating;

	@Column(name="lat")
	private Double lat;

	@Column(name="lon")
	private Double lon;
	
	@Column(name="image")
	private String image;
	
	public Property() {
	}

	public Property(int customerId, PropertyType propertyType, String propertyName, String address,
			int roomQuantity, LocalDate createDate, String description, Double rating, Double lat, Double lon,
			String image) {
		this.customerId = customerId;
		this.propertyType = propertyType;
		this.propertyName = propertyName;
		this.address = address;
		this.roomQuantity = roomQuantity;
		this.createDate = createDate;
		this.description = description;
		this.rating = rating;
		this.lat = lat;
		this.lon = lon;
		this.image = image;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoomQuantity() {
		return roomQuantity;
	}

	public void setRoomQuantity(int roomQuantity) {
		this.roomQuantity = roomQuantity;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {this.lon = lon;}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
