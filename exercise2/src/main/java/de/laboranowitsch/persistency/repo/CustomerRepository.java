package de.laboranowitsch.persistency.repo;

import de.laboranowitsch.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Data access {@link org.springframework.data.jpa.repository.JpaRepository} for
 * {@link de.laboranowitsch.persistence.entity.Customer}.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
