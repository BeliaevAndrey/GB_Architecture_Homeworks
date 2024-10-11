package models;

import service.GenerateCustomersSvc;
import service.GenerateTicketsSvc;

import java.util.Collection;

/**
 * Additional class; includes database filling
 */
public class CoreTest extends Core {

    private final GenerateTicketsSvc generateTicketsSvc;
    private final GenerateCustomersSvc generateCustomersSvc;

    public CoreTest() {
        super();
        generateTicketsSvc = new GenerateTicketsSvc(this.getDatabase());
        generateCustomersSvc = new GenerateCustomersSvc(this.getDatabase());
    }

    /**
     * Provides access to fake customers generator; for filling a database
     * @return GenerateCustomersSvc     -- service access
     */
    public GenerateCustomersSvc getGenerateCustomersSvc() {
        return generateCustomersSvc;
    }

    /**
     * Provides access to fake ticket generator; for filling a database
     * @return GenerateTicketsSvc       -- service access
     */
    public GenerateTicketsSvc getGenerateTicketsSvc() {
        return generateTicketsSvc;
    }

    public Collection<Customer> getCustomers() {
        return getDatabase().getCustomers();
    }
}
