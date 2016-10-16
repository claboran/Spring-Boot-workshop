package de.laboranowitsch.common.test;

/**
 * Definition of profiles for spring.profiles.active.
 */
public class Profiles {
    /**
     * Integration testing on H2
     */
    public static final String INT_TEST_H2 = "int-test-h2";
    /**
     * Integration testing on Derby
     */
    public static final String INT_TEST_DERBY = "int-test-derby";
    /**
     * Development server on H2
     */
    public static final String DEV_H2 = "dev-h2";
    /**
     * Development server on Derby
     */
    public static final String DEV_DERBY = "dev-derby";
    /**
     * Production server on Derby
     */
    public static final String PROD = "prod";

}
