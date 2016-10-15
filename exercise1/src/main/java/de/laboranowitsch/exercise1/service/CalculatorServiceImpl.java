package de.laboranowitsch.exercise1.service;

import de.laboranowitsch.common.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Exercise 1 - Class path scan
 * The service is detected by:
 *
 * {@link Service}
 *
 * a value as Bean Name can be taken into account
 *
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    /**
     * Use Strategy pattern with Spring Beans and
     * make a decision at runtime what to do
     */
    private final Map<String, VatService> vatServiceMap;

    // A pure Autowired does not help the CoponentScan is not present...
    @Autowired
    public CalculatorServiceImpl(final Map<String, VatService> vatServiceMap) {
        this.vatServiceMap = vatServiceMap;
    }
    @Override
    public Double calcVat(Double amount, String countryCode) {
        return amount + (amount * vatServiceMap.get("constVatService").getVatValue(countryCode));
    }
}
