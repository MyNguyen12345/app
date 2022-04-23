package com.cnpm.workingspace;

import com.cnpm.workingspace.dto.SavedRoomDto;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.model.Room;
import com.cnpm.workingspace.model.SavedRoom;
import com.cnpm.workingspace.repository.CustomerRepository;
import com.cnpm.workingspace.repository.RoomRepository;
import com.cnpm.workingspace.repository.SavedRoomRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class WorkingSpaceApplicationTests {

    @Autowired
    SavedRoomRepository savedRoomRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoomRepository roomRepository;
    ModelMapper toEntityMapper;
    ModelMapper toDtoMapper;

    @Autowired
    public WorkingSpaceApplicationTests(ModelMapper toEntityMapper, ModelMapper toDtoMapper) {
        // Converter<Integer, Customer> customerConverter = context -> customerRepository.findById(context.getSource()).orElseThrow();
        // Converter<Integer, Room> roomConverter = context -> roomRepository.findById(context.getSource()).orElseThrow();
        Converter<Integer, Customer> customerConverter = context -> customerRepository.getById(context.getSource());
        Converter<Integer, Room> roomConverter = context -> roomRepository.getById(context.getSource());

        this.toEntityMapper = toEntityMapper;
        this.toEntityMapper.createTypeMap(SavedRoomDto.class, SavedRoom.class)
                           .addMappings(mapper -> mapper.using(customerConverter).map(SavedRoomDto::getCustomerId, SavedRoom::setCustomer))
                           .addMappings(mapper -> mapper.using(roomConverter).map(SavedRoomDto::getRoomId, SavedRoom::setRoom));

        this.toDtoMapper = toDtoMapper;
        this.toDtoMapper.createTypeMap(SavedRoom.class, SavedRoomDto.class)
                        .addMappings(mapper -> mapper.map(savedRoom -> savedRoom.getCustomer().getCustomerId(),SavedRoomDto::setCustomerId))
                        .addMappings(mapper -> mapper.map(savedRoom -> savedRoom.getRoom().getRoomId(), SavedRoomDto::setRoomId));
    }

    @Test
    @Transactional
    public void test() {
        SavedRoomDto savedRoomDto = new SavedRoomDto(1, 1);
        SavedRoom savedRoom = toEntityMapper.map(savedRoomDto, SavedRoom.class);
        System.out.println(savedRoom.getRoom().getCapacity());
        System.out.println(savedRoom.getCustomer().getCustomerId());
        System.out.println();
    }
}
