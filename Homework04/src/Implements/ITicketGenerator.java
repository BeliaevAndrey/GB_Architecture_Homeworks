package Implements;

import models.Ticket;

import java.util.Collection;

public interface ITicketGenerator {


    void generateTickets(int ticketsCount);

    Collection<Ticket> getTickets();
}
