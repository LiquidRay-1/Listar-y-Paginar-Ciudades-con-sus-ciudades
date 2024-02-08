package com.example.countries.controller;

import com.example.countries.dto.CountryCitiesDTO;
import com.example.countries.model.Country;
import com.example.countries.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Country save(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    /*@GetMapping
    public List<Country> list(){
        return countryService.listofCountries();
    }*/

    @GetMapping
    public List<CountryCitiesDTO> listDTO(){
        return countryService.countriesCities();
    }

}
