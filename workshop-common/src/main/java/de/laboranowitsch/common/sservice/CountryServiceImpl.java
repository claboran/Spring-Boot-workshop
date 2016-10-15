package de.laboranowitsch.common.sservice;

import de.laboranowitsch.common.service.VatService;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Nothing gets Exposed at all
 */
public class CountryServiceImpl implements CountryService {
    private final VatService vatService;

    public CountryServiceImpl(final VatService vatService) {
        this.vatService = vatService;
    }

    @Override
    public List<String> getIsoCodes() {
        return Arrays.asList(Locale.getISOCountries());
    }
}
