package dev.gunjan.BookMyShow.service;

import dev.gunjan.BookMyShow.exception.SelectedSeatsNotAvailableException;
import dev.gunjan.BookMyShow.model.ShowSeat;
import dev.gunjan.BookMyShow.model.Ticket;
import dev.gunjan.BookMyShow.model.User;
import dev.gunjan.BookMyShow.model.constant.ShowSeatStatus;
import dev.gunjan.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private ShowService showService;

    public Ticket createTicket(int userId, List<Integer> showSeatIds){
        User user = userService.getUserById(userId);
        List<ShowSeat> showSeats = new ArrayList<>();
        int totalCost = 0;

        // Lock selected seats
       showSeats = checkAnLockShowSeats(showSeatIds);

        //TODO : Payment done here logic

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShowSeats(showSeats);
        ticket.setTotalCost(totalCost);
        ticket.setShow(null);

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.updateShowSeat(showSeat);
        }

        return ticketRepository.save(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> checkAnLockShowSeats(List<Integer> showSeatsIds){
        // Check if all seats are available
        List<ShowSeat> showSeats = new ArrayList<>();
        for(int showSeatId : showSeatsIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SelectedSeatsNotAvailableException("Seat selected for booking are not available");
            }

        }

        for(int showSeatId : showSeatsIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeats.add(showSeat);
            showSeatService.updateShowSeat(showSeat);
        }
        return showSeats;
    }
}
