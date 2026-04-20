package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.AuditoriumNotFoundException;
import dev.gunjan.BookMyShow.model.Auditorium;
import dev.gunjan.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public Auditorium createAuditorium(Auditorium auditorium){
        return auditoriumRepository.save(auditorium);

    }

    public Auditorium findAuditoriumById(int id){
        return auditoriumRepository.findById(id).orElseThrow(
                ()-> new AuditoriumNotFoundException("Audi with given id not found")
        );
    }

    public List<Auditorium> getAllAuditoriums(){
        return auditoriumRepository.findAll();
    }

    public void deleteAuditoriumById(int id){
        auditoriumRepository.deleteById(id);
    }

}
