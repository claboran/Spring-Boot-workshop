package de.laboranowitsch.exercise3;

import de.laboranowitsch.common.test.DbLoaderConfiguration;
import de.laboranowitsch.common.test.Profiles;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * {@link org.springframework.context.annotation.Configuration} class
 */
@Configuration
@Profile(value = {Profiles.DEV_DERBY, Profiles.DEV_H2, Profiles.PROD})
@Import(value = {DbLoaderConfiguration.class})
public class Exercise3Configuration {
}
