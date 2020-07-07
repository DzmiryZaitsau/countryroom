package com.my.countryroom.service;

import com.my.countryroom.domain.Country;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Country findByName(@Param("name") String name);
    Optional<Country> findById(final long id);

}
