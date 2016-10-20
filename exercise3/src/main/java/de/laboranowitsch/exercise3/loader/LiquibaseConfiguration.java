package de.laboranowitsch.exercise3.loader;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Example of integrating Liquibase
 */
@Configuration
public class LiquibaseConfiguration {


    /**
     * We are going to create a managed Liquibase Bean what gives us the opportunity to
     * call Liquibase operations whenever we need it during the lifecycle of our test
     * or even when we need to set up a DEV server.
     * The idea here is that we load the data with traditional insert scripts and
     * let Liquibase handle the drop (for test/dev server) and the creation of the database.
     * Exercise: Add a master changelog according to http://www.liquibase.org/bestpractices.html
     * Make the master-changelog injectable with @Value from the property files.
     *
     * @param dataSource
     * @return {@link Liquibase}
     * @throws SQLException
     * @throws LiquibaseException
     */
    @Bean
    public Liquibase luiquibase(DataSource dataSource) throws SQLException, LiquibaseException {
        Liquibase liquibase = new liquibase.Liquibase("db-changelog.xml",
                new ClassLoaderResourceAccessor(),
                DatabaseFactory.getInstance()
                        .findCorrectDatabaseImplementation(
                                new JdbcConnection(dataSource.getConnection()))
        );
        return liquibase;
    }
}
