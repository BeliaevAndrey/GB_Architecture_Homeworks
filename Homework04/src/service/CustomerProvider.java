package service;

import Excptions.CustomerLoginError;
import models.Customer;
import models.Database;

public class CustomerProvider {

    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    /**
     * authentication and authorization
     *
     * @param login    -- login
     * @param password -- password
     * @return Customer     -- authorized customer entity
     */
    public Customer getCustomer(String login, String password) throws CustomerLoginError {

        for (Customer c : database.getCustomers()) {
            if (c.getLogin().equals(login) && c.getPassword().equals(password))
                return c;
        }
        throw new CustomerLoginError();
    }

}
