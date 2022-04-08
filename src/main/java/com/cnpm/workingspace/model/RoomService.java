package com.cnpm.workingspace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="room_service")
public class RoomService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_service_id", nullable = false)
    private int roomServiceId;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "room_service_name")
    private String roomServiceName;

    @Column(name = "quantity_available")
    private int quantityAvailable;

    @Column(name = "price")
    private double price;

    public RoomService() {
    }

    public int getRoomServiceId() {
        return roomServiceId;
    }

    public void setRoomServiceId(int roomServiceId) {
        this.roomServiceId = roomServiceId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getRoomServiceName() {
        return roomServiceName;
    }

    public void setRoomServiceName(String roomServiceName) {
        this.roomServiceName = roomServiceName;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
