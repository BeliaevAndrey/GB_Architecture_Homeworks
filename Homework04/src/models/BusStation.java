package models;

import service.TicketProvider;

/**
 * Bus Station class
 */
public class BusStation {

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    /**
     * Ticket validation at from ticket provider
     * @param qrCode        -- ticket QR-code string
     * @return              -- result true/false
     */
    public boolean checkTicket(String qrCode) {
        return ticketProvider.checkTicket(qrCode);
    }
}
