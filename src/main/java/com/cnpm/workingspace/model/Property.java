package com.cnpm.workingspace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public Property(Customer customer,
                    PropertyType propertyType,
                    String propertyName,
                    String address,
                    String city,
                    Integer roomQuantity,
                    LocalDateTime createDate,
                    String description,
                    Double rating,
                    String image,
                    Double lat,
                    Double lon) {
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
}