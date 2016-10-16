package de.laboranowitsch.persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Persistence Configuration
 */
@Configuration
@ComponentScan(basePackageClasses = {PersistenceConfiguration.class})
public class PersistenceConfiguration {
}
