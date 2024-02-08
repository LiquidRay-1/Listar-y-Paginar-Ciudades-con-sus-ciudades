package com.example.countries.services;

import com.example.countries.converter.CountryCitiesConverter;
import com.example.countries.dto.CountryCitiesDTO;
import com.example.countries.model.City;
import com.example.countries.model.Country;
import com.example.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryCitiesConverter countryCitiesConverter;

    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }

    public List<Country> listofCountries(){
        return countryRepository.findAll();
    }

    public List<CountryCitiesDTO> countriesCities(){
        List<Country> countries = countryRepository.findAll();
        List<CountryCitiesDTO> countryCitiesDTO = new ArrayList<>();
        countries.forEach( country -> {
            countryCitiesDTO.add(countryCitiesConverter.convertEntityToCountryCityDTO(country));
        });
        return countryCitiesDTO;
    }

}
