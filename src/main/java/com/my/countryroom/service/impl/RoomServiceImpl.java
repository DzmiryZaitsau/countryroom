package com.my.countryroom.service.impl;

import com.my.countryroom.domain.Room;
import com.my.countryroom.repositories.RoomRepo;
import com.my.countryroom.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Room> findById(final long id)
    {
        return roomRepo.findById(id);
    }

    @Override
    public void save(final Room room) { roomRepo.save(room);}

    @Override
    public void delete(final Room room) { roomRepo.delete(room);}

}
