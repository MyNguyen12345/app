package com.cnpm.workingspace.model;

import javax.persistence.*;

@Entity
@Table(name = "room_status")
public class RoomStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_status_id", nullable = false)
    private Integer roomStatusId;

    @Column(name = "room_status_name", nullable = false)
    private String roomStatusName;

    public RoomStatus() {
    }

    public RoomStatus(String roomStatusName) {
        this.roomStatusName = roomStatusName;
    }

    public String getRoomStatusName() {
        return roomStatusName;
    }

    public void setRoomStatusName(String roomStatusName) {
        this.roomStatusName = roomStatusName;
    }

    public Integer getRoomStatusId() {
        return roomStatusId;
    }

    public void setRoomStatusId(Integer roomStatusId) {
        this.roomStatusId = roomStatusId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "roomStatusId = " + roomStatusId + ", " +
               "roomStatusName = " + roomStatusName + ")";
    }
}