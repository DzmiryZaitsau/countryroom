package com.my.countryroom.service.impl;

import com.my.countryroom.domain.Country;
import com.my.countryroom.repositories.CountryRepo;
import com.my.countryroom.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    final
    CountryRepo countryRepo;

    public CountryServiceImpl(final CountryRepo countryRepo)
    {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> findAll()
    {
        return countryRepo.findAll();
    }
}
