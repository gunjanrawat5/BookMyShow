package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.CityNotFoundException;
import dev.gunjan.BookMyShow.model.City;
import dev.gunjan.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City createCity(City city) {return cityRepository.save(city);}

    public City getCityById(int id){
        return cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City with given id not found"));
    }

    public List<City> getAllCities() {return cityRepository.findAll();}

    public void deleteCityById(int id) {cityRepository.deleteById(id);}


}
