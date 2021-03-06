package de.laboranowitsch.exercise1;

import de.laboranowitsch.common.pservice.Country;
import de.laboranowitsch.common.pservice.CountryFactory;
import de.laboranowitsch.common.service.CommonServiceConfiguration;
import de.laboranowitsch.common.sservice.CountryService;
import de.laboranowitsch.exercise1.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Spring Boot main class
 * Exercise 1 - Bean configuration
 *
 * {@link SpringBootApplication} is a meta annotation what enables {@link org.springframework.context.annotation.ComponentScan}
 * downwards the package hierarchy.
 */
@Slf4j
@SpringBootApplication
@Import(value = {CommonServiceConfiguration.class}) // Spring Beans imported from Common Module
public class Exercise1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Exercise1Application.class, args);
        // Beans can be retrieved by
        // Type: Either by Interface or Implementation class
        // By Name and (Type)
        log.info("Calculator Service: {}", context.getBean(CalculatorService.class).calcVat(100.0, "DE"));
        context.getBean(CountryService.class).getIsoCodes().forEach(c -> log.info("Country Code: {}", c));
        CountryFactory countryFactory = context.getBean(CountryFactory.class);
        Country c1 = countryFactory.getInstance();
        c1.setCode("DE");
        Country c2 = countryFactory.getInstance();
        c2.setCode("FR");
        log.info("Country 1: {}, Country 2: {}", c1.toString(), c2.toString());
    }

}