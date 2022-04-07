package com.cnpm.workingspace.repository;

import com.cnpm.workingspace.model.RoomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomService, Integer> {
    final String GET_ALL_ROOM_SERVICES="SELECT * FROM room_service";
    final String TEST_QUERY="SELECT :number";

    @Query(value = GET_ALL_ROOM_SERVICES,nativeQuery = true)
    List<RoomService> getAllRoomServices();

    @Query(value = TEST_QUERY,nativeQuery = true)
    Integer testQuery(
            @Param("number") Integer number
    );

}
