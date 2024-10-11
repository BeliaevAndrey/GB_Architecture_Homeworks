package Implements;

import models.Customer;

import java.util.Collection;

public interface ICustomerGenerator {

    void generateCustomers(int customersCount);
    Collection<Customer> getCustomers();
}
