package de.laboranowitsch.exercise3;

import de.laboranowitsch.common.test.DbLoaderConfiguration;
import de.laboranowitsch.common.test.Profiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * {@link org.springframework.context.annotation.Configuration} class
 */
@Configuration
@Profile(value = {Profiles.DEV_DERBY, Profiles.DEV_H2, Profiles.PROD})
@Import(value = {DbLoaderConfiguration.class})
@EnableSwagger2
public class Exercise3Configuration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
