package com.example.worldservice.service;

import com.example.worldservice.model.City;

import java.util.List;

public interface WorldService {

    public List<City> getAllCities();

    public City getCityById(Integer id);

    public City getCityByName(String cityName);
}
