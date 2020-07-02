package com.my.countryroom.view;

import com.my.countryroom.domain.dto.RoomDTO;
import com.my.countryroom.mapper.AbstractRoomMapper;
import com.my.countryroom.mapper.AbstractRoomMapperImpl;
import com.my.countryroom.service.impl.RoomServiceImpl;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainPage extends VerticalLayout {
    @Autowired
    private final RoomServiceImpl roomServiceImpl;
    private final AbstractRoomMapper abstractRoomMapper = new AbstractRoomMapperImpl();
    private Grid<RoomDTO> gridRoom = new Grid<>(RoomDTO.class);


    public MainPage(final RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
        add(gridRoom);
        gridRoom.setItems(abstractRoomMapper.toRoomDTO(this.roomServiceImpl.findAll()));
    }

}
