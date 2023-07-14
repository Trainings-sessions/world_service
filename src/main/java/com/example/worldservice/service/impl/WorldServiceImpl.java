package com.example.worldservice.service.impl;

import com.example.worldservice.execptions.NoDataFoundException;
import com.example.worldservice.model.City;
import com.example.worldservice.repo.CityRepository;
import com.example.worldservice.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class WorldServiceImpl implements WorldService {

    @Autowired
    CityRepository cityRepository;


    @Override
    public List<City> getAllCities() {
        List<City> cities= cityRepository.findAll();
        if(CollectionUtils.isEmpty(cities))
                  throw  new NoSuchElementException("No Data Found");
        return cities;
    }

    @Override
    public City getCityById(Integer id) {
        Optional<City> cityOptional = cityRepository.findById(id);
       return cityOptional.orElseThrow();
    }

    @Override
    public City getCityByName(String cityName) {
        Optional<City> cityOptional = cityRepository.findByName(cityName);
        return cityOptional.orElseThrow();
    }
}
