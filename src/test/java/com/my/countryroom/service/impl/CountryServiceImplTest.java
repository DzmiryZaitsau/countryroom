package com.my.countryroom.service.impl;

import com.my.countryroom.CountryroomApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SqlGroup({
        @Sql("/countries-table.sql"),
        @Sql("/countries-data.sql"),

})

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CountryroomApplication.class)
class CountryServiceImplTest {
    @Autowired
    CountryServiceImpl countryServiceImpl;

    @Test
    void findAll()  { assertEquals(5, countryServiceImpl.findAll().size()); }

    @Test
    void findByName() { assertEquals(4, countryServiceImpl.findByName("USA").getId());}

    @Test
    void findById() { assertTrue(countryServiceImpl.findById(4).isPresent()); }
}