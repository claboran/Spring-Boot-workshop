package de.laboranowitsch.persistence.repo;

import de.laboranowitsch.common.test.DbLoaderConfiguration;
import de.laboranowitsch.persistence.PersistenceConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration for H2 integration tests
 */
@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@EntityScan(basePackages = {"de.laboranowitsch.persistence.entity"}, basePackageClasses = {Jsr310JpaConverters.class})
@Import(value = {PersistenceConfiguration.class, DbLoaderConfiguration.class})
public class TestPersistenceConfiguration {
}
