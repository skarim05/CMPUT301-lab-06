package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the city name
     * @return
     * Return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This returns the province name
     * @return
     * Return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * This compares two cities based on their names
     * used for sorting cities in CityList class
     * @param o the object to be compared.
     * @return
     * Return a negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * This is used to compare two cities
     * based on their names and province
     * (necessary for hasCity method in CityList class)
     * @param
     * o the object to be compared.
     * @return
     * Return true if the cities names and provine names are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return this.city.equals(city.getCityName()) &&
                this.province.equals(city.getProvinceName());
    }
    /**
     * This is used to hash a city
     * @return
     * Return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

}
