package de.laboranowitsch.exercise1;

import de.laboranowitsch.common.service.VatService;
import de.laboranowitsch.common.sservice.CountryService;
import de.laboranowitsch.common.sservice.CountryServiceImpl;
import de.laboranowitsch.exercise1.service.CalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Service Configuration for External Spring Beans.
 * Gets scanned from the {@link org.springframework.context.annotation.ComponentScan}
 * of Spring Boot.
 */
@Configuration
public class ExternalServiceConfiguration {

    /**
     * External Dependency to an Bean what is injected.
     *
     * @param mapVatService
     * @return {@link CountryService}
     */
    @Bean
    public CountryService countryService(Map<String, VatService> mapVatService) {
        return new CountryServiceImpl(mapVatService.get("constVatService"));
    }
}
