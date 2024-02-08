package com.example.countries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryCitiesDTO {
    private String country;
    private List<String> ciudades;
}
