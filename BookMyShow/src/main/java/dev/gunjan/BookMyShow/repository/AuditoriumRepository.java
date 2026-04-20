package dev.gunjan.BookMyShow.repository;

import dev.gunjan.BookMyShow.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium,Integer> {
}
