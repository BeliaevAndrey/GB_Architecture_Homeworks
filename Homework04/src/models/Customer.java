package models;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

/**
 * Customer class
 */
public class Customer {
    private static int counter;

    private final int id;

    private final String login;       // MobileApp credentials
    private final String password;    // MobileApp credentials

    private Collection<Ticket> tickets;

    {
        id = ++counter;
        login = String.format("login # %d", id);
        password = String.format("pwd%d", (new Random().nextLong() + new Date().getTime()) >>> 31);
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
