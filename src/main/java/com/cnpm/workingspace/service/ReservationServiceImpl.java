package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dao.ReservationDao;
import com.cnpm.workingspace.dto.PropertyDto;
import com.cnpm.workingspace.dto.ReservationDto;
import com.cnpm.workingspace.dto.RoomDto;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.model.Reservation;
import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.repository.CustomerRepository;
import com.cnpm.workingspace.repository.PriceRepository;
import com.cnpm.workingspace.repository.ReservationRepository;
import com.cnpm.workingspace.repository.RoomRepository;
import com.cnpm.workingspace.sdo.DateStatus;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements  ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private CustomerRepository customerRepository;

    private ModelMapper toDtoMapper;

    private ModelMapper toEntityMapper;

    public ReservationServiceImpl(ModelMapper toDtoMapper){
        this.toDtoMapper = toDtoMapper;
        this.toDtoMapper.createTypeMap(Reservation.class, ReservationDto.class)
                        .addMappings(mapper -> mapper.map(src -> src.getCustomer().getCustomerId(), ReservationDto::setCustomerId))
                        .addMappings(mapper -> mapper.map(src -> src.getRoom().getRoomId(), ReservationDto::setRoomId));
    }

    @Autowired
    public void setToEntityMapper(ModelMapper toEntityMapper){
        Converter<Integer, Customer> customerConverter = context -> customerRepository.getById(context.getSource());
        Converter<Integer, Room> roomConverter = context -> roomRepository.getById(context.getSource());
        this.toEntityMapper = toEntityMapper;
        this.toEntityMapper.createTypeMap(ReservationDto.class, Reservation.class)
                           .addMappings(mapper -> mapper.using(customerConverter).map(ReservationDto::getCustomerId, Reservation::setCustomer))
                           .addMappings(mapper -> mapper.using(roomConverter).map(ReservationDto::getRoomId, Reservation::setRoom));
    }

    @Override
    public List<ReservationDto> getAllReservation() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> toDtoMapper.map(reservation, ReservationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void insertReservation(ReservationDto reservationDto) {
        Reservation reservation = toEntityMapper.map(reservationDto, Reservation.class);
        reservationRepository.save(reservation);
    }

    @Override
    public boolean updateReservation(ReservationDto reservationDto, int id) {
        Optional<Reservation> reservationOpt = reservationRepository.findById(id);
        if(reservationOpt.isPresent()){
            reservationRepository.save(toEntityMapper.map(reservationDto, Reservation.class));
            return true;
        }
        return false;
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public ReservationDto getReservationById(int id) {
        Reservation reservation = reservationRepository.getById(id);
        return toDtoMapper.map(reservation, ReservationDto.class);
    }

    @Override
    public List<DateStatus> getDateStatus(int roomId, int month, int year) {
        return reservationDao.getDateStatus(roomId,month,year);
    }
}
