package com.my.countryroom.mapper;

import com.my.countryroom.domain.Country;
import com.my.countryroom.domain.Room;
import com.my.countryroom.domain.dto.RoomDTO;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;
@Mapper
public abstract class AbstractRoomMapper {
    public RoomDTO toRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setLampIsOn(room.isLampIsOn());
        roomDTO.setCountry_id(room.getCountry() == null ? 0 : room.getCountry().getId());
        roomDTO.setCountry(room.getCountry() == null ? null : room.getCountry().getName());
        return roomDTO;
    }

    public abstract List<RoomDTO> toRoomDTO(Collection<Room> rooms);

    public Room toRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setLampIsOn(roomDTO.isLampIsOn());
        room.setCountry(new Country(roomDTO.getCountry_id(), roomDTO.getCountry()));
        return room;
    }

    public abstract List<Room> toRoom(Collection<RoomDTO> roomsDTO);


}
