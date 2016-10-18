package de.laboranowitsch.exercise3;

import de.laboranowitsch.common.test.DbLoaderConfiguration;
import de.laboranowitsch.persistence.PersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main Class for the RestWebservice.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {PersistenceConfiguration.class})
@EntityScan(basePackages = {"de.laboranowitsch.persistence.entity"}, basePackageClasses = {Jsr310JpaConverters.class})
@Import(value = {DbLoaderConfiguration.class})
public class Exercise3Application {
    public static void main(String[] args) {
        SpringApplication.run(Exercise3Application.class, args);
    }

}
