package service;

import Implements.ITicketGenerator;
import models.Database;
import models.Direction;
import models.Ticket;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class GenerateTicketsSvc implements ITicketGenerator {

    private final Database database;
    private final Date today ;

    {
        today = new Date();
    }

    public GenerateTicketsSvc(Database database) {
        this.database = database;
    }

    @Override
    public void generateTickets(int ticketsCount) {
        for (int i = 0; i < ticketsCount; i++) {
            Ticket t = new Ticket();
            t.setDirection(Direction.values()[Math.abs(new Random().nextInt() % 4)]);
            database.getTickets().add(t);
        }
    }


    @Override
    public Collection<Ticket> getTickets() {
        return database.getTickets();
    }
}
