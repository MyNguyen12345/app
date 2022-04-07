package com.cnpm.workingspace.dto;

public class RoomServiceDto {
    private int roomServiceId;
    private int roomId;
    private String roomServiceName;
    private int quantityAvailable;
    private double price;

    public RoomServiceDto() {
    }

    public RoomServiceDto(int roomServiceId, int roomId, String roomServiceName, int quantityAvailable, double price) {
        this.roomServiceId = roomServiceId;
        this.roomId = roomId;
        this.roomServiceName = roomServiceName;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public int getRoomServiceId() {
        return roomServiceId;
    }

    public void setRoomServiceId(int roomServiceId) {
        this.roomServiceId = roomServiceId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
