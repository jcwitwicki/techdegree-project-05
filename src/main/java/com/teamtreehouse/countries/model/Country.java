package com.teamtreehouse.countries.model;

import java.util.Collections;
import java.util.List;

public class Country implements Comparable<Country> {

    private String name;
    private int population;
    private String capital;
    private List<String> languages;

    public Country(String name, int population, String capital, List<String> languages) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public String getPopulationToString() {
        String formattedNumber = String.format("%,d", population);
        return formattedNumber;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getLanguages() {
        Collections.sort(languages);
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int compareTo(Country other) {
        return name.compareToIgnoreCase(other.getName());
    }

}
