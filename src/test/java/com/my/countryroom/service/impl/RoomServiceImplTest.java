package com.my.countryroom.service.impl;

import com.my.countryroom.CountryroomApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SqlGroup({
        @Sql("/countries-table.sql"),
        @Sql("/countries-data.sql"),
        @Sql("/room-table.sql"),
        @Sql("/room-data.sql")

})

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CountryroomApplication.class)
class RoomServiceImplTest {
    @Autowired
    RoomServiceImpl roomServiceImpl;

    @Test
    void findAll() { assertEquals(6, roomServiceImpl.findAll().size()); }


    @Test
    void findById() { assertTrue(roomServiceImpl.findById(4).isPresent()); }

}