package com.example.countries.services;

import com.example.countries.converter.CityConverter;
import com.example.countries.dto.CityPageableDTO;
import com.example.countries.model.City;
import com.example.countries.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityConverter cityConverter;

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public List<City> listofCities(){
        return cityRepository.findAll();
    }

    public Page cityPageable(Pageable pageable){
        return cityRepository.findAll(pageable);
    }

    public CityPageableDTO cityPageableDTO(Pageable page){
        Page<City> cities = cityRepository.findAll(page);
        Pageable citiesPageable = cities.getPageable();
        return cityConverter.convertCityPageableDTO(citiesPageable);
    }

}
