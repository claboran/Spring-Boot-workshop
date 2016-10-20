package de.laboranowitsch.exercise3.service;

import de.laboranowitsch.common.test.DbLoader;
import de.laboranowitsch.exercise3.TesConfiguration;
import de.laboranowitsch.persistence.entity.Contract;
import de.laboranowitsch.persistence.entity.Customer;
import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
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
 * Test class for {@link CustomerService}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TesConfiguration.class})
public class CustomerServiceTests {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DbLoader dbLoader;
    @Autowired
    private Liquibase liquibase;

    @Before
    public void before() throws LiquibaseException {

        //liquibase.update("test"); // use it instead of dbLoader.prepare
        dbLoader.prepareDatabase();
        dbLoader.loadData();
    }

    @Test
    public void contextWired() {
        assertThat("customerService has been wired properly", customerService, notNullValue());
    }

    @Test
    public void testSimpleRead() {
        Optional<Customer> cust = customerService.findCustomerByName("Christian", "Laboranowitsch");
        assertThat("Customer has the right first name", cust.get().getFirstName(), is(equalTo("Christian")));
        assertThat("Customer has the right last name", cust.get().getLastName(), is(equalTo("Laboranowitsch")));
    }

    @Test
    public void testAddOneContractAndReadBack() {
        Optional<Customer> cust = customerService.findCustomerByName("Christian", "Laboranowitsch");
        Customer customer = cust.get();

        customer.addContract(Contract.builder()
                .withCustomer(cust.get())
                .withValidFrom(LocalDate.of(2015, 01, 01))
                .withValidTo(LocalDate.of(2016, 01, 01)).build());

        customerService.saveOrUpdate(customer);

        cust = customerService.findCustomerByName("Christian", "Laboranowitsch");

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
