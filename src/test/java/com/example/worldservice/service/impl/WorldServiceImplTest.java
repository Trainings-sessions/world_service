package com.example.worldservice.service.impl;

import com.example.worldservice.TestUtility;
import com.example.worldservice.model.City;
import com.example.worldservice.repo.CityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

public class WorldServiceImplTest {
    @Mock
    CityRepository cityRepository;
    @InjectMocks
    WorldServiceImpl worldServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCities() throws Exception {
        when(cityRepository.findAll()).thenReturn(List.of(TestUtility.getCity()));
        List<City> result = worldServiceImpl.getAllCities();
        Assert.assertEquals(List.of(TestUtility.getCity()), result);
    }

    @Test(expected = NoSuchElementException.class )
    public void testGetAllCitiesThrowNoSuchElementException() throws Exception
    {
        List<City> result = worldServiceImpl.getAllCities();
    }

    @Test
    public void testGetCityById() throws Exception {
        City result = worldServiceImpl.getCityById(Integer.valueOf(0));
        Assert.assertEquals(new City(), result);
    }

    @Test
    public void testGetCityByName() throws Exception {
        when(cityRepository.findByName(anyString())).thenReturn(null);

        City result = worldServiceImpl.getCityByName("cityName");
        Assert.assertEquals(new City(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme