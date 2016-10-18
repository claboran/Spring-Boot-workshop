package de.laboranowitsch.exercise3;

import de.laboranowitsch.common.test.DbLoaderConfiguration;
import de.laboranowitsch.common.test.Profiles;
import de.laboranowitsch.persistence.PersistenceConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration for H2 integration tests
 */
@Configuration
@Import(value = { Exercise3Application.class})
@Profile(value = {Profiles.INT_TEST_H2, Profiles.INT_TEST_DERBY})
public class TesConfiguration {
}
