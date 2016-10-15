package de.laboranowitsch.common.pservice;

import de.laboranowitsch.common.sservice.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Demonstration of {@link org.springframework.context.annotation.Scope} = Prototype
 * Spring Bean what could get used during runtime.
 */
@Component
@Scope(scopeName = "prototype")
public class Country {

    private final CountryService countryService;
    private String code;

    @Autowired
    public Country(final CountryService countryService) {
        this.countryService = countryService;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return code != null ? code.equals(country.code) : country.code == null;

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("countryService=").append(countryService);
        sb.append(", code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
