package de.laboranowitsch.common.test;

/**
 * DBLoader keeps track of the different loading strategy for H2 and Derby.
 *
 */
public interface DbLoader {
    /**
     * prepares the database
     */
    void prepareDatabase();
    void loadData();
}
