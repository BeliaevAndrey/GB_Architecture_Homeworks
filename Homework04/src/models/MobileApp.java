package models;

import Exceptions.CustomerLoginError;
import Exceptions.TicketPurchasedException;
import service.CustomerProvider;
import service.TicketProvider;

import java.util.Collection;
import java.util.Date;

/**
 * Mobile application class
 */
public class MobileApp {

    private Customer customer;

    private final TicketProvider ticketProvider;

    private final CustomerProvider customerProvider;

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
//        customer = customerProvider.getCustomer("<login>", "<password>");   // authorization
    }

    /**
     * Provides access to Mobile app
     * @param login         -- login name
     * @param password      -- login password
     * @return              -- login result true/false
     */
    public boolean login(String login, String password) {

        try {
            customer = customerProvider.getCustomer(login, password);
            return true;
        } catch (CustomerLoginError e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * get a list of available tickets
     * @return Collection:Ticket     -- a collection of tickets
     */
    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }
    /**
     * Search appropriate tickets in base
     * @param date          -- date of ticket
     */
    public void searchTicket(Date date) {

        // get a ticket by <date> and direction
        customer.setTickets(ticketProvider.searchTicket(Direction.North, date));
    }

    /**
     * Search appropriate tickets in base
     * @param date          -- date of ticket
     * @param direction     -- destination of bus
     */
    public void searchTicket(Date date, Direction direction) {

        // get a ticket by <date> and direction
        customer.setTickets(ticketProvider.searchTicket(direction, date));

    }

    /**
     * Operation "buy a ticket"
     * @param cardNo        -- payment card id number
     * @param tickets       -- collection of available tickets
     * @return              -- result of operation true/false
     */
    public boolean buyTicket(String cardNo, Collection<Ticket> tickets) {
        Ticket choice = null;
        for (Ticket ticket : tickets) {
            if (ticket.getCustomerId() == -1) {
                choice = ticket;
                break;
            }
        }

        if (choice == null) return false;

        if (ticketProvider.buyTicket(customer.getId(), cardNo)) {
            try {
                choice.setCustomerId(customer.getId());
                return true;
            } catch (TicketPurchasedException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

}
