package com.example.worldservice;

import com.example.worldservice.model.City;

public class TestUtility {

    public static City getCity()
    {
         City city =new City();
         city.setID(1);
         city.setName("Delhi");
         city.setDistrict("Delhi");
         city.setCountryCode("IN");
         city.setPopulation(1234567890);
         return city;
    }
}
