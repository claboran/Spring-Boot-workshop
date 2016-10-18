package de.laboranowitsch.exercise3.service;

import de.laboranowitsch.persistence.entity.Customer;

import java.util.List;
import java.util.Optional;

/**
 * Basic interface for dealing with C{@link de.laboranowitsch.persistence.entity.Customer}
 * and {@link de.laboranowitsch.persistence.entity.Contract}s.
 */
public interface CustomerService {

    /**
     * Retrieves all {@link Customer}.
     *
     * @return List of Customer
     */
    List<Customer> findAllCustomer();

    /**
     * Saves or update a Customer
     * @param customer
     *
     * @return saved Customer
     */
    Customer saveOrUpdate(Customer customer);

    /**
     * Finds a distinct Customer
     * @param firstName
     * @param lastName
     *
     * @return Distinct Customer
     */
    Optional<Customer> findCustomerByName(String firstName, String lastName);
}
