package com.example.worldservice.controller;

import com.example.worldservice.model.City;
import com.example.worldservice.service.WorldService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

public class WorldControllerTest {
    @Mock
    WorldService worldService;
    @InjectMocks
    WorldController worldController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllCities() throws Exception {
        when(worldService.getAllCities()).thenReturn(List.of(new City()));

        ResponseEntity<List<City>> result = worldController.fetchAllCities();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetCityById() throws Exception {
        when(worldService.getCityById(anyInt())).thenReturn(new City());

        ResponseEntity<City> result = worldController.getCityById(Integer.valueOf(0));
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme