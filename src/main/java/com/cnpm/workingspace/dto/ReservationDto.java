package com.cnpm.workingspace.dto;

import java.io.Serializable;
import java.util.Date;

public class ReservationDto implements Serializable {
    private int reservationId;
    private int roomId;
    private int customerId;
    private Date createDate;
    private Date startDate;
    private Date endDate;
    private int quantity;
    private int reservationStatusId;
    private Double total;
    private Double deposit;
}
