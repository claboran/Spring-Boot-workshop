package de.laboranowitsch.common.sservice;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Nothing gets Exposed at all
 */
public class CountryServiceImpl implements CountryService {
    @Override
    public List<String> getIsoCodes() {
        return Arrays.asList(Locale.getISOCountries());
    }
}
