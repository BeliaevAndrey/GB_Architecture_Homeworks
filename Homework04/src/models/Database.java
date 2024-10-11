package models;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Database simulator class
 */
public class Database {

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Database() { }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Get actual ticket price
     *
     * @return int price
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Get identifier for ticket purchase
     *
     * @param clientId -- client idenyifier
     * @return counter -- order id
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

}
