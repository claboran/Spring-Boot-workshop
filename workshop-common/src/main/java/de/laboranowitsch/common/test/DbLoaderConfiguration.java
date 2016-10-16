package de.laboranowitsch.common.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * DBLoader Configuration to enable Classpath Scanning of annotated Beans.
 */
@Configuration
@Profile(value = {Profiles.DEV_DERBY, Profiles.INT_TEST_H2, Profiles.INT_TEST_DERBY})
@ComponentScan(basePackageClasses = {DbLoaderConfiguration.class})
public class DbLoaderConfiguration {
}
