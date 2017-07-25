package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping({"/", "/index", "/countries"})
    public String listCountries(ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/countries/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-details";
    }

    @RequestMapping("/countries/by-name")
    public String countriesByName(ModelMap modelMap) {
        List<Country> countries = countryRepository.sortByName();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/countries/by-population")
    public String countries(ModelMap modelMap) {
        List<Country> countries = countryRepository.sortByPopulation();
        modelMap.put("countries", countries);
        return "index";
    }

}
