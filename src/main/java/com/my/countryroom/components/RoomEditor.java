package com.my.countryroom.components;

import com.my.countryroom.domain.Country;
import com.my.countryroom.domain.Room;
import com.my.countryroom.domain.dto.RoomDTO;
import com.my.countryroom.mapper.AbstractRoomMapper;
import com.my.countryroom.mapper.AbstractRoomMapperImpl;
import com.my.countryroom.service.impl.CountryServiceImpl;
import com.my.countryroom.service.impl.RoomServiceImpl;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringComponent
@UIScope
public class RoomEditor extends VerticalLayout implements KeyNotifier
{
    private final RoomServiceImpl roomService;
    private final CountryServiceImpl countryServiceImpl;
    private AbstractRoomMapper abstractRoomMapper = new AbstractRoomMapperImpl();
    private Room room;
    private List<Country> allCountry;
    private TextField name = new TextField("Name", "Name");
    private ComboBox<Country> country = new ComboBox<>("Select a Country");
    private final Checkbox lampIsOn = new Checkbox();
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private HorizontalLayout buttons = new HorizontalLayout(save, delete);

    private Binder<Room> binder = new Binder<>(Room.class);
    @Setter
    private ChangeHandler changeHandler = new ChangeHandler()
    {
        @Override
        public void onChange()
        {

        }
    };

    public interface ChangeHandler
    {
        void onChange();
    }

    @Autowired
    public RoomEditor(RoomServiceImpl roomService, final CountryServiceImpl countryServiceImpl)
    {
        this.roomService = roomService;
        this.countryServiceImpl = countryServiceImpl;
        allCountry = this.countryServiceImpl.findAll();
        country.setItems(allCountry);
        country.setItemLabelGenerator(Country::getName);
        add(name, buttons, lampIsOn, country);
        binder.bindInstanceFields(this);
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        setVisible(false);
    }

    private void save()
    {
        roomService.save(room);
        changeHandler.onChange();
    }

    private void delete()
    {
        roomService.delete(room);
        changeHandler.onChange();
    }

    public void createRoom(Room room) {
        this.room=room;
        binder.setBean(this.room);

        setVisible(true);

        name.focus();

    }

    public void editRoom(RoomDTO roomDTO)
    {
        if (roomDTO == null)
        {
            setVisible(false);
            return;
        }

        if (roomDTO.getId() != 0)
        {
            this.room = roomService.findById(roomDTO.getId()).orElse(abstractRoomMapper.toRoom(roomDTO));
        }
        else
        {
            this.room = abstractRoomMapper.toRoom(roomDTO);
        }

        binder.setBean(this.room);

        setVisible(true);

        name.focus();
    }

}