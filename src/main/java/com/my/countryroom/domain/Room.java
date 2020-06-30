package com.my.countryroom.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private boolean lampIsOn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    Country country;

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

    public Country getCountry()
    {
        return country;
    }

    public void setCountry(final Country country)
    {
        this.country = country;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Room))
        {
            return false;
        }
        final Room room = (Room) o;
        return id == room.id &&
                lampIsOn == room.lampIsOn &&
                name.equals(room.name) &&
                country.equals(room.country);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, lampIsOn, country);
    }
}
