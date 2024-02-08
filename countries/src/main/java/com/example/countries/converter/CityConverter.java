package com.example.countries.converter;

import com.example.countries.dto.CityPageableDTO;
import com.example.countries.model.City;
import com.example.countries.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityConverter {
    @Autowired
    private CityRepository cityRepository;

    public CityPageableDTO convertCityPageableDTO(Pageable pageable){
        Page<City> page = cityRepository.findAll(pageable);
        List<City> cities = page.getContent();
        int totalPages = page.getTotalPages();
        int elementsPerPage = page.getNumberOfElements();
        List<String> citiesString = new ArrayList<>();
        cities.forEach(city -> {
            citiesString.add(city.getCityName());
        });

        CityPageableDTO cityPageableDTO = CityPageableDTO.builder()
                .cities(citiesString)
                .numElementsPerPage(elementsPerPage)
                .totalPages(totalPages)
                .build();

        return cityPageableDTO;
    }
}
