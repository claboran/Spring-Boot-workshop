package de.laboranowitsch.common.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * CommonServiceConfiguration exposing the whole bunch of Spring Beans to the outside world.
 */
@Configuration
@ComponentScan(basePackageClasses = {CommonServiceConfiguration.class})
public class CommonServiceConfiguration {
}
