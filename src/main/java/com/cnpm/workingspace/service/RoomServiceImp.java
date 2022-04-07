package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.RoomDto;
import com.cnpm.workingspace.model.Price;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.model.RoomStatus;
import com.cnpm.workingspace.repository.PriceRepository;
import com.cnpm.workingspace.repository.PropertyRepository;
import com.cnpm.workingspace.repository.RoomRepository;
import com.cnpm.workingspace.repository.RoomStatusRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImp implements RoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private RoomStatusRepository roomStatusRepository;

    private ModelMapper toDtoMapper;

    private ModelMapper toEntityMapper;

    public RoomServiceImp(ModelMapper toDtoMapper) {
        this.toDtoMapper = toDtoMapper;
        this.toDtoMapper.createTypeMap(Room.class, RoomDto.class)
                .addMappings(mapper -> mapper.map(src -> src.getProperty().getPropertyId(), RoomDto::setPropertyId))
                .addMappings(mapper -> mapper.map(src -> src.getPrice().getId(), RoomDto::setPriceId))
                .addMappings(mapper -> mapper.map(src -> src.getRoomStatus().getRoomStatusId(), RoomDto::setRoomStatusId));
    }

    @Autowired
    public void setToEntityMapper(ModelMapper toEntityMapper) {
        Converter<Integer, Property> propertyConverter = context -> propertyRepository.getById(context.getSource());
        Converter<Integer, Price> priceConverter = context -> priceRepository.getById(context.getSource());
        Converter<Integer, RoomStatus> roomStatusConverter = context -> roomStatusRepository.getById(context.getSource());
        this.toEntityMapper = toEntityMapper;
        this.toEntityMapper.createTypeMap(RoomDto.class, Room.class)
                .addMappings(mapper -> mapper.map(RoomDto::getPropertyId, Room::setProperty))
                .addMappings(mapper -> mapper.map(RoomDto::getPriceId, Room::setPrice))
                .addMappings(mapper -> mapper.map(RoomDto::getRoomStatusId, Room::setRoomStatus));
    }

    @Override
    public List<RoomDto> getAllRoom() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                    .map(room -> toDtoMapper.map(room, RoomDto.class))
                    .collect(Collectors.toList());
    }

    @Override
    public void insertRoom(RoomDto roomDto) {
        Room room = toEntityMapper.map(roomDto, Room.class);
        roomRepository.save(room);
    }

    @Override
    public boolean updateRoom(RoomDto roomDto, int id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            roomRepository.save(toEntityMapper.map(roomDto, Room.class));
            return true;
        }
        return false;
    }

    @Override
    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }

    @Override
    public RoomDto getRoomById(int id) {
        Room room = roomRepository.getById(id);
        return toDtoMapper.map(room, RoomDto.class);
    }
}
