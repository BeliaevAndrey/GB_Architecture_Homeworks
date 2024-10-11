package Excptions;

public class TicketPurchasedException extends Exception {
    @Override
    public String getMessage() {
        return "Ticket is already purchased.";
    }
}
