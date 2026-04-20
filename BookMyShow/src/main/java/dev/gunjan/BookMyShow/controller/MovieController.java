package dev.gunjan.BookMyShow.controller;

import dev.gunjan.BookMyShow.model.Movie;
import dev.gunjan.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/{id}")
    public ResponseEntity findMovieById(@PathVariable("id") int id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/movie")
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id")int id){
        movieService.deleteMovieById(id);
        return ResponseEntity.ok(true);
    }
}
