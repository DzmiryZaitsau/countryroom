package com.my.countryroom.mapper;

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
        roomDTO.setCountry(room.getCountry().getName());
        return roomDTO;
    }

    public abstract List<RoomDTO> toRoomDTO(Collection<Room> rooms);

}
