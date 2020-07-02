package com.my.countryroom.mapper;

import com.my.countryroom.domain.Country;
import com.my.countryroom.domain.dto.CountryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper
{
    CountryDTO toCountryDTO(Country country);

    Country toCountry(CountryDTO countryDTO);
}
