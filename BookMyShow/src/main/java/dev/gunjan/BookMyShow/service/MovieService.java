package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.MovieNotFoundException;
import dev.gunjan.BookMyShow.model.Movie;
import dev.gunjan.BookMyShow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie getMovieById(int id){
        return movieRepository.findById(id).orElseThrow(
                () -> new MovieNotFoundException("Movie not found with id " + id)
        );

    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void deleteMovieById(int id){
        movieRepository.deleteById(id);
    }
}
