package dev.gunjan.BookMyShow.model;

import dev.gunjan.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private double totalCost;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    @ManyToOne
    private User user;
    private LocalDateTime bookingTime;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
