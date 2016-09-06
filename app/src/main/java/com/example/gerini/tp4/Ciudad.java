package com.example.gerini.tp4;

/**
 * Created by 41665767 on 9/8/2016.
 * Roto by 41665569 on 23/8/2016}
 */

public class Ciudad {

    String clase;
    String countrycode;
    double lat;
    double lng;
    String name;
    int population;

    public Ciudad(String clase, String countrycode, double lat, double lng, String name, int population) {
        this.clase = clase;
        this.countrycode = countrycode;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.population = population;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
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

    public void setPopulation(int population) {
        this.population = population;
    }
}



