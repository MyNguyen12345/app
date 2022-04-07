package com.cnpm.workingspace.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "property")
public class Property implements Serializable {
    private static final long serialVersionUID = 8024425894957681666L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id", nullable = false)
    private Integer propertyId;


    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "property_type_id", nullable = false)
    private PropertyType propertyType;

    @Column(name = "property_name", nullable = false)
    private String propertyName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "room_quantity", nullable = false)
    private Integer roomQuantity;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "property")
    private List<Room> rooms = new ArrayList<>();

    public Property() {
    }

    public Property(Customer customer,
                    PropertyType propertyType,
                    String propertyName,
                    String address,
                    Integer roomQuantity,
                    String description,
                    Double rating,
                    String image) {
        this.customer = customer;
        this.propertyType = propertyType;
        this.propertyName = propertyName;
        this.address = address;
        this.roomQuantity = roomQuantity;
        this.description = description;
        this.rating = rating;
        this.image = image;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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

    public void setDescription(String description) {this.description = description;}

    public Integer getRoomQuantity() {return roomQuantity;}

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
               "propertyId = " + propertyId + ", " +
               "propertyName = " + propertyName + ", " +
               "address = " + address + ", " +
               "roomQuantity = " + roomQuantity + ", " +
               "description = " + description + ", " +
               "rating = " + rating + ", " +
               "image = " + image + ")";
    }
}