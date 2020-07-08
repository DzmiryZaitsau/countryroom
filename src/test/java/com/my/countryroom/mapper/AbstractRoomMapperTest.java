package com.my.countryroom.mapper;

import com.my.countryroom.domain.Country;
import com.my.countryroom.domain.Room;
import com.my.countryroom.domain.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AbstractRoomMapperTest {
    private AbstractRoomMapper mapper
            = Mappers.getMapper(AbstractRoomMapper.class);
    @Test
    public void testToRoomDTO()
    {
        Room room = new Room();
        room.setId((long) 1);
        room.setName("BeninRoom");
        room.setLampIsOn(true);
        room.setCountry(new Country(1, "Benin"));
        RoomDTO roomDTO = mapper.toRoomDTO(room);

        assertEquals(room.getId(), roomDTO.getId());
        assertEquals(room.getName(), roomDTO.getName());
        assertEquals(room.isLampIsOn(), roomDTO.isLampIsOn());
        assertEquals(room.getCountry().getId(), roomDTO.getCountry_id());
        assertEquals(room.getCountry().getName(), roomDTO.getCountry());
    }

    @Test
    public void testToRoom()
    {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId((long) 1);
        roomDTO.setName("BeninRoom");
        roomDTO.setLampIsOn(true);
        roomDTO.setCountry_id(1);
        roomDTO.setCountry("Japan");
        Room room = mapper.toRoom(roomDTO);

        assertEquals(roomDTO.getId(), room.getId());
        assertEquals(roomDTO.getName(), room.getName());
        assertEquals(roomDTO.isLampIsOn(), room.isLampIsOn());
        assertEquals(roomDTO.getCountry_id(), room.getCountry().getId());
        assertEquals(roomDTO.getCountry(), room.getCountry().getName());
    }


}