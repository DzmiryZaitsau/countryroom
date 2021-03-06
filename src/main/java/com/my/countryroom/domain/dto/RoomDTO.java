package com.my.countryroom.domain.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private long id;
    private String name;
    private boolean lampIsOn;
    private long country_id;
    private String country;

    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public boolean isLampIsOn()
    {
        return lampIsOn;
    }

    public void setLampIsOn(final boolean lampIsOn)
    {
        this.lampIsOn = lampIsOn;
    }

    public long getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(final long country_id)
    {
        this.country_id = country_id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(final String country)
    {
        this.country = country;
    }
}
