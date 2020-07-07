package com.my.countryroom.repositories;

import com.my.countryroom.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepo extends JpaRepository<Country, Long> {
    @Query("from Country  c where c.name  like :name")
    Country findByName(@Param("name") String name);
}
