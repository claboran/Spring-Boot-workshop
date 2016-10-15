package de.laboranowitsch.exercise1;

import de.laboranowitsch.common.sservice.CountryService;
import de.laboranowitsch.common.sservice.CountryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Service Configuration for External Spring Beans.
 * Gets scanned from the {@link org.springframework.context.annotation.ComponentScan}
 * of Spring Boot.
 */
@Configuration
public class ExternalServiceConfiguration {

    @Bean
    public CountryService countryService() {
        return new CountryServiceImpl();
    }
}
