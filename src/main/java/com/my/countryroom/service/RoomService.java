package com.my.countryroom.service;

import com.my.countryroom.domain.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAll();
    Optional<Room> findById(long id);
    void save(Room room);
    void delete(Room room);
}
