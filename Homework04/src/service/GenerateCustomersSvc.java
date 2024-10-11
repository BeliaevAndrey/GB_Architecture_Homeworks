package service;

import Implements.ICustomerGenerator;
import models.Customer;
import models.Database;

import java.util.Collection;

public class GenerateCustomersSvc implements ICustomerGenerator {

    Database database;

    public GenerateCustomersSvc(Database database) {
        this.database = database;
    }

    @Override
    public void generateCustomers(int customersCount) {
        for (int i = 0; i < customersCount; i++) {
            database.getCustomers().add(new Customer());
        }
    }

    @Override
    public Collection<Customer> getCustomers() {
        return database.getCustomers();
    }
}
