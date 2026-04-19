package dev.gunjan.BookMyShow.repository;

import dev.gunjan.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
