package com.cnpm.workingspace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "price_id", nullable = false)
    private Price price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_status_id", nullable = false)
    private RoomStatus roomStatus;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "size")
    private String size;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "image")
    private String image;

    @Lob
    @Column(name = "description")
    private String description;

    public Room(Property property,
                Price price,
                RoomStatus roomStatus,
                String roomName,
                String size,
                String capacity,
                String image,
                String description) {
        this.property = property;
        this.price = price;
        this.roomStatus = roomStatus;
        this.roomName = roomName;
        this.size = size;
        this.capacity = capacity;
        this.image = image;
        this.description = description;
    }
}