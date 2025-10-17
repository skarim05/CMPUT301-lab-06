package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        // check and remove Edmonton, Alberta
        assertEquals(0, cityList.hasCity(mockCity()));

        // when its empty
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.hasCity(mockCity());
        });

        // add two new cities
        City city1 = new City("Regina", "Saskatchewan");
        City city2 = new City("Winnipeg", "Manitoba");
        City city3 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city1);
        cityList.add(city2);

        // search for a city not in cityList
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.hasCity(city3);
        });

        // add third city
        cityList.add(city3);

        // remove city1 (Regina, SK) -> size equals 2 after removing
        assertEquals(2, cityList.hasCity(city1));

        // remove city2 (Winnipeg, MB) -> size equals 1 after removing
        assertEquals(1, cityList.hasCity(city2));
    }

}
