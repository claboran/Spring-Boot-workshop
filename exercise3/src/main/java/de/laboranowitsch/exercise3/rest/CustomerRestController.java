package de.laboranowitsch.exercise3.rest;

import de.laboranowitsch.exercise3.service.CustomerService;
import de.laboranowitsch.persistence.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController for {@link de.laboranowitsch.persistence.entity.Customer} .
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer", method = {RequestMethod.GET})
    public ResponseEntity<List<Customer>> findAllCustomer() {
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }

}
