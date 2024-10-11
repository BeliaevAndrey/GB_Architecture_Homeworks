import models.*;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билета не автобус в час пик"
     *
     * 1. Предусловия.
     * 2. Постусловия.
     * 3. Инвариант.
     * 4. Определить абстрактные и конкретные классы.
     * 5. Определить интерфейсы.
     * 6. Реализовать наследование.
     * 7. Выявить компоненты.
     * 8. Разработать диаграмму компонент используя нотацию UML 2.0. Общая, без деталей.
     */
    public static void main(String[] args) {

        int count = 0;

        Collection<Customer> customers;

        CoreTest core = new CoreTest();

        core.getGenerateCustomersSvc().generateCustomers(310);

        customers = core.getCustomers();

        core.getGenerateTicketsSvc().generateTickets(300);

        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        Random rnd = new Random();

        for (Customer customer : customers) {
            System.out.printf("%d\n", ++count);
            if (!mobileApp.login(customer.getLogin(), customer.getPassword())) { continue; }
            mobileApp.searchTicket(new Date(), Direction.values()[(Math.abs(rnd.nextInt(4)))]);
            Collection<Ticket> tickets = mobileApp.getTickets();

            if (mobileApp.buyTicket("1100000221", tickets)) {
                System.out.println("Client has purchased a ticket successfully.");
                if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                    System.out.println("Client has set on a bus successfully.");
                }
            } else {
                System.out.println("No appropriate ticket for client found.");
            }
        }

    }
}



