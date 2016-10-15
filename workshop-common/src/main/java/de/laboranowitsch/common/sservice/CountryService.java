package de.laboranowitsch.common.sservice;

import java.util.List;

/**
 * Country Service as an example for not exposing
 * as Spring Bean.
 */
public interface CountryService {

    List<String> getIsoCodes();
}
