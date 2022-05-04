package com.cnpm.workingspace.dao;

import com.cnpm.workingspace.mapper.DateStatusMapper;
import com.cnpm.workingspace.sdo.DateStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcReservationDao implements ReservationDao {
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public JdbcReservationDao(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    @Override
    public List<DateStatus> getDateStatus(int roomId, int month, int year) {
        List<DateStatus> ret=new ArrayList<>();
        final String sql="WITH RECURSIVE days AS\n" +
                "(\n" +
                "   SELECT 1 AS day UNION ALL SELECT day + 1 FROM days WHERE day < DAY(LAST_DAY('"+year+"-"+month+"-01'))\n" +
                ")\n" +
                "\n" +
                "SELECT d.day, IF(d.day >= DAY(r.start_date) AND d.day <= DAY(r.end_date),TRUE,FALSE) AS status FROM days AS d\n" +
                "LEFT JOIN reservation AS r\n" +
                "ON (\n" +
                "    d.day >= DAY(r.start_date) AND d.day <= DAY(r.end_date)\n" +
                "    AND r.reservation_status_id = 1\n" +
                "    AND MONTH(r.start_date) = "+month+"\n" +
                "    AND YEAR(r.start_date) = "+year+"\n" +
                "    AND r.room_id = "+roomId+"\n" +
                ")\n" +
                "ORDER BY day\n";
        ret.addAll(jdbcTemplateObject.query(sql,new DateStatusMapper()));
        return ret;
    }

    @Override
    public String getFurthestValidDate(int roomId, Date fromDate) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String from=format.format(fromDate);
        final String sql="SELECT DATE(create_date) - INTERVAL 1 DAY AS furthest_date FROM reservation \n" +
                "WHERE room_id = "+roomId+"\n" +
                "AND '"+from+"' < DATE(create_date)\n" +
                "ORDER BY DATE(create_date)\n" +
                "LIMIT 1\n";
        System.out.println("###### sql : "+sql);
        String ret=jdbcTemplateObject.queryForObject(sql,String.class);
        return ret;
    }
}
