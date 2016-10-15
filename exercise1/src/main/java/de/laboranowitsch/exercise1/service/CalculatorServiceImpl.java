package de.laboranowitsch.exercise1.service;

import de.laboranowitsch.common.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private final VatService vatService;

    // A pure Autowired does not help the CoponentScan is not present...
    @Autowired
    public CalculatorServiceImpl(final VatService vatService) {
        this.vatService = vatService;
    }
    @Override
    public Double calcVat(Double amount) {
        return amount + (amount * 0.19);
    }
}
