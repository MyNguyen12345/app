package com.cnpm.workingspace.model;

import javax.persistence.*;

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

    public Room() {
    }

    public Room(Property property,
                Price price,
                RoomStatus roomStatus,
                String roomName,
                String size,
                String capacity, String image, String description) {
        this.property = property;
        this.price = price;
        this.roomStatus = roomStatus;
        this.roomName = roomName;
        this.size = size;
        this.capacity = capacity;
        this.image = image;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer id) {
        this.roomId = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + roomId + ", " +
               "roomName = " + roomName + ", " +
               "size = " + size + ", " +
               "capacity = " + capacity + ", " +
               "image = " + image + ", " +
               "description = " + description + ")";
    }
}