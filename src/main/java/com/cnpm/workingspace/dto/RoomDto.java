package com.cnpm.workingspace.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDto {
    private Integer roomId;
    private Integer propertyId;
    private Integer priceId;
    private Integer roomStatusId;
    private String roomName;
    private String size;
    private String capacity;
    private String image;
    private String description;
}
