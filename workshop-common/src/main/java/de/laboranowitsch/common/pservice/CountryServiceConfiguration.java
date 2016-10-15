package de.laboranowitsch.common.pservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Package scan...
 */
@Configuration
@ComponentScan(basePackageClasses = {CountryServiceConfiguration.class})
public class CountryServiceConfiguration {
}
