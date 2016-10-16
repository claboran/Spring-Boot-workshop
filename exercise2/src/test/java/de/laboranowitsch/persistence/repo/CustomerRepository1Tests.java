package de.laboranowitsch.persistence.repo;

import de.laboranowitsch.persistence.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Tests using {@link org.springframework.test.context.jdbc.SqlGroup} for loading the database
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestH2Configuration.class})
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:sql/create-int-test-h2.sql", "classpath:sql/insert-int-test-h2.sql"})
    }
)
public class CustomerRepository1Tests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextWired() {
        assertThat("customerRepository has been wired properly", customerRepository, notNullValue());
    }

    @Test
    public void testSimpleRead() {
        Optional<Customer> cust = customerRepository.findCustomerByFirstNameAndLastName("Christian", "Laboranowitsch");
        assertThat("Customer has the right first name", cust.get().getFirstName(), is(equalTo("Christian")));
        assertThat("Customer has the right last name", cust.get().getLastName(), is(equalTo("Laboranowitsch")));
    }
}
