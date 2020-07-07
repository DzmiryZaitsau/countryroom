package com.my.countryroom.service.impl;

import com.my.countryroom.domain.Country;
import com.my.countryroom.repositories.CountryRepo;
import com.my.countryroom.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Country findByName(final String name)
    {
        return countryRepo.findByName(name);
    }

    @Override
    public Optional<Country> findById(final long id)
    {
        return countryRepo.findById(id);
    }
}
