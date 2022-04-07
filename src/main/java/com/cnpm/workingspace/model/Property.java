package com.cnpm.workingspace.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id", nullable = false)
    private Integer propertyId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "property_type_id", nullable = false)
    private PropertyType propertyType;

    @Column(name = "property_name", nullable = false)
    private String propertyName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "room_quantity", nullable = false)
    private Integer roomQuantity;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "image")
    private String image;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    public Property() {
    }

    public Property(Customer customer,
                    PropertyType propertyType,
                    String propertyName,
                    String address,
                    String city,
                    Integer roomQuantity,
                    LocalDateTime createDate,
                    String description,
                    Double rating, String image, Double lat, Double lon) {
        this.customer = customer;
        this.propertyType = propertyType;
        this.propertyName = propertyName;
        this.address = address;
        this.city = city;
        this.roomQuantity = roomQuantity;
        this.createDate = createDate;
        this.description = description;
        this.rating = rating;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer id) {
        this.propertyId = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + propertyId + ", " +
               "propertyName = " + propertyName + ", " +
               "address = " + address + ", " +
               "city = " + city + ", " +
               "roomQuantity = " + roomQuantity + ", " +
               "createDate = " + createDate + ", " +
               "description = " + description + ", " +
               "rating = " + rating + ", " +
               "image = " + image + ", " +
               "lat = " + lat + ", " +
               "lon = " + lon + ")";
    }
}