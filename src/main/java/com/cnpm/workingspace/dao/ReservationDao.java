package com.cnpm.workingspace.dao;

import com.cnpm.workingspace.sdo.DateStatus;

import java.util.*;

public interface ReservationDao {
    List<DateStatus> getDateStatus(int roomId,int month,int year);
    String getFurthestValidDate(int roomId,Date from);
}
