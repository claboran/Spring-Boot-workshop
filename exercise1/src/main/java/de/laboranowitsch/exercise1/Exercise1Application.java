package de.laboranowitsch.exercise1;

import de.laboranowitsch.exercise1.service.CalculatorService;
import de.laboranowitsch.exercise1.service.CalculatorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Spring Boot main class
 * Exercise 1 - Bean configuration
 *
 * {@link SpringBootApplication} is a meta annotation what enables {@link org.springframework.context.annotation.ComponentScan}
 * downwards the package hierarchy.
 */
@Slf4j
@SpringBootApplication
public class Exercise1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Exercise1Application.class, args);
        // Beans can be retrieved by
        // Type: Either by Interface or Implementation class
        // By Name and (Type)
        log.info("Calculator Service: {}", context.getBean("calcService", CalculatorService.class));
    }

}