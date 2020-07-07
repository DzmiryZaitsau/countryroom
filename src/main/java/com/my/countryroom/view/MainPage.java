package com.my.countryroom.view;

import com.my.countryroom.components.RoomEditor;
import com.my.countryroom.domain.Country;
import com.my.countryroom.domain.Room;
import com.my.countryroom.domain.dto.RoomDTO;
import com.my.countryroom.mapper.AbstractRoomMapper;
import com.my.countryroom.mapper.AbstractRoomMapperImpl;
import com.my.countryroom.service.impl.CountryServiceImpl;
import com.my.countryroom.service.impl.RoomServiceImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route
public class MainPage extends VerticalLayout {
    @Autowired
    private RoomServiceImpl roomServiceImpl;
    @Autowired
    private  final CountryServiceImpl countryServiceImpl;
    private final RoomEditor roomEditor;
    private final AbstractRoomMapper abstractRoomMapper = new AbstractRoomMapperImpl();
    private final Button addNewRoom = new Button("New room", VaadinIcon.PLUS.create());
    private Grid<RoomDTO> gridRoom = new Grid<>(RoomDTO.class);
    ComboBox<Country> select = new ComboBox<>("Select a Country");
    private final HorizontalLayout toolbar = new HorizontalLayout(addNewRoom, select);
    private List<Country> allCountry;



    public MainPage(final RoomServiceImpl roomServiceImpl, final CountryServiceImpl countryServiceImpl, final RoomEditor roomEditor) {
        this.roomServiceImpl = roomServiceImpl;
        this.countryServiceImpl = countryServiceImpl;
        this.roomEditor = roomEditor;
        allCountry = countryServiceImpl.findAll();
        select.setItems(allCountry);
        select.setItemLabelGenerator(Country::getName);
        add(toolbar, gridRoom, roomEditor);
        gridRoom.setItems(abstractRoomMapper.toRoomDTO(this.roomServiceImpl.findAll()));
        addNewRoom.addClickListener(e -> this.roomEditor.createRoom(new Room()));
    }
}
