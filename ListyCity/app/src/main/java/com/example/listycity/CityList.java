package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This removes a city from the list if it exists
     * else throws an exception
     * @param city
     * this is the city to be removed
     * @return
     * return the size of the list after removing
     */
    public int hasCity(City city) {
        if (cities.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (cities.contains(city)) {
            cities.remove(city);
            return cities.size();
        }
        throw new IllegalArgumentException();

    }
}