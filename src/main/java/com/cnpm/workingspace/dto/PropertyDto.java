package com.cnpm.workingspace.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyDto implements Serializable {
    private Integer propertyId;
    private Integer customerId;
    private Integer propertyTypeId;
    private String propertyName;
    private String address;
    private String city;
    private Integer roomQuantity;
    private LocalDateTime createDate;
    private String description;
    private Double rating;
    private String image;
    private Double lat;
    private Double lon;
}
