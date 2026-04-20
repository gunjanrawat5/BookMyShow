package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.TheatreNotFoundException;
import dev.gunjan.BookMyShow.model.Theatre;
import dev.gunjan.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }

    public Theatre findTheatreById(int id){
        return theatreRepository.findById(id).orElseThrow(
                ()-> new TheatreNotFoundException("Theatre with given id not found")
        );
    }

    public List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }

    public void deleteTheatreById(int id){
        theatreRepository.deleteById(id);
    }

}
