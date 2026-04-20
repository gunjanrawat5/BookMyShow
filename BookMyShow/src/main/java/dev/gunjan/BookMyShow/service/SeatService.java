package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.SeatNotFoundException;
import dev.gunjan.BookMyShow.model.Seat;
import dev.gunjan.BookMyShow.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat createSeat(Seat seat){
        return seatRepository.save(seat);
    }

    public Seat findSeatById(int id){
        return seatRepository.findById(id).orElseThrow(
                ()-> new SeatNotFoundException("Seat with given id not found")
        );
    }

    public List<Seat> getAllSeats(){
        return seatRepository.findAll();
    }

    public void deleteSeatById(int id){
        seatRepository.deleteById(id);
    }

}
