package com.example.countries.converter;

import com.example.countries.dto.CountryCitiesDTO;
import com.example.countries.model.City;
import com.example.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryCitiesConverter {
    public CountryCitiesDTO convertEntityToCountryCityDTO(Country country){
        CountryCitiesDTO countryCitiesDTO = new CountryCitiesDTO();
        countryCitiesDTO.setCountry(country.getName());
        List<City> cities = country.getCities();
        List<String> citiesForCountry = new ArrayList<>();
        cities.forEach( city -> {
            citiesForCountry.add(city.getCityName());
        });
        countryCitiesDTO.setCiudades(citiesForCountry);
        return countryCitiesDTO;
    }
}
