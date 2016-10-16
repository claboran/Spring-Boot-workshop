package de.laboranowitsch.persistence.repo;

import de.laboranowitsch.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Data access {@link org.springframework.data.jpa.repository.JpaRepository} for
 * {@link de.laboranowitsch.persistence.entity.Customer}.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds a {@link Customer} based on the first- and lats name.
     *
     * @param firstName
     * @param lastName
     * @return Customer or an Optional
     */
    Optional<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
}
