package com.my.countryroom.service.impl;

import com.my.countryroom.domain.Room;
import com.my.countryroom.repositories.RoomRepo;
import com.my.countryroom.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    final
    RoomRepo roomRepo;

    public RoomServiceImpl(final RoomRepo roomRepo)
    {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<Room> findAll()
    {
        return roomRepo.findAll();
    }

    @Override
    public Room findById(final long id)
    {
        return roomRepo.getOne(id);
    }

}
