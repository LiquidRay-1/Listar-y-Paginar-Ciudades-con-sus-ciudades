package com.example.countries.controller;

import com.example.countries.converter.CityConverter;
import com.example.countries.dto.CityPageableDTO;
import com.example.countries.model.City;
import com.example.countries.model.Country;
import com.example.countries.repository.CityRepository;
import com.example.countries.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private CityConverter cityConverter;

    @PostMapping
    public City save(@RequestBody City city){
        return cityService.saveCity(city);
    }

    //Añadir GetMapping si se quiere descomentar
    /*public List<City> list(){
        return cityService.listofCities();
    }*/

    //@GetMapping
    /*public Page<City> pageableCity(@PageableDefault(page = 0, size = 2)Pageable pageable){
        return cityService.cityPageable(pageable);
    }*/

    @GetMapping("page2")
    public CityPageableDTO pageableListDTO(@PageableDefault(page = 0, size = 2)Pageable pageable) {
        return cityService.cityPageableDTO(pageable);
    }
}
