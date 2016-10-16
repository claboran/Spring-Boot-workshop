package de.laboranowitsch.persistence.repo;

import de.laboranowitsch.common.test.DbLoader;
import de.laboranowitsch.persistence.entity.Contract;
import de.laboranowitsch.persistence.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Tests are using  for loading the database
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class CustomerRepository1Tests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DbLoader dbLoader;

    @Before
    public void before() {
        dbLoader.prepareDatabase();
        dbLoader.loadData();
    }

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

    @Test
    public void testAddOneContractAndReadBack() {
        Optional<Customer> cust = customerRepository.findCustomerByFirstNameAndLastName("Christian", "Laboranowitsch");
        Customer customer = cust.get();

        customer.addContract(Contract.builder()
                .withCustomer(cust.get())
                .withValidFrom(LocalDate.of(2015, 01, 01))
                .withValidTo(LocalDate.of(2016, 01, 01)).build());

        customerRepository.save(customer);

        cust = customerRepository.findCustomerByFirstNameAndLastName("Christian", "Laboranowitsch");

        assertThat("We have on contract assigned", cust.get().getContracts().size(), is(equalTo(1)));
        assertThat("We have a contract with the right validFrom", cust.get().getContracts()
            .stream()
                .filter(contract -> contract.getValidFrom()
                        .equals(LocalDate.of(2015, 01, 01)))
                .count(),
                is(equalTo(1L)));
        assertThat("We have a contract with the right validTo", cust.get().getContracts()
                        .stream()
                        .filter(contract -> contract.getValidTo()
                                .equals(LocalDate.of(2016, 01, 01)))
                        .count(),
                is(equalTo(1L)));

    }


}
