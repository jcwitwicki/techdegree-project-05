package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import com.teamtreehouse.countries.model.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CountryRepository  {

    private static final List<Country> ALL_COUNTRIES = Arrays.asList(

            new Country("Bhutan", 742737, "Thimphu", Arrays.asList("Dzonglha")),
            new Country("Belize", 387879, "Belmopan", Arrays.asList("English")),
            new Country("Lebanon", 6184701, "Beirut", Arrays.asList("Arabic")),
            new Country("Belgium", 11250585, "Brussels", Arrays.asList("French","Dutch","German")),
            new Country("Cyprus", 1141166, "Nicosia", Arrays.asList("Greek","Turkish"))
            );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findByName(String name) {
        return ALL_COUNTRIES.stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    public List<Country> sortByName() {
        List<Country> countries = new ArrayList<>(ALL_COUNTRIES);
        Collections.sort(countries);
        return countries;
    }

    public List<Country> sortByPopulation() {
        List<Country> countries = new ArrayList<>(ALL_COUNTRIES);
        Collections.sort(countries, (o1, o2) -> o2.getPopulation() - o1.getPopulation());
        return countries;
    }
}
