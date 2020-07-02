package com.my.countryroom.service;

import com.my.countryroom.domain.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(long id);
}
