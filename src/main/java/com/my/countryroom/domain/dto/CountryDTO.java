package com.my.countryroom.domain.dto;

import com.my.countryroom.domain.Room;
import lombok.Data;

import java.util.List;
@Data
public class CountryDTO {
    private long id;
    private String name;
    private List<Room> rooms;
}
