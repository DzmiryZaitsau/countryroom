package com.my.countryroom.view;

import com.my.countryroom.domain.Room;
import com.my.countryroom.service.impl.RoomServiceImpl;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainPage extends VerticalLayout {
    @Autowired
    private final RoomServiceImpl roomServiceImpl;
    private Grid<Room> gridRoom = new Grid<>(Room.class);


    public MainPage(final RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
        add(gridRoom);
        gridRoom.removeColumnByKey("country");
        gridRoom.setItems(this.roomServiceImpl.findAll());
    }

}
