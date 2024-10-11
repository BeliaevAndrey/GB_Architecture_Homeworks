package service;

/**
 * Payment provider class
 */
public class PaymentProvider {

    public boolean buyTicket(int orderId, String cardNo, double amount) {

        // Here is a call to payment gateway for approval ...

        return true;
    }

}
