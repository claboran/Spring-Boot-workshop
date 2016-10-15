package de.laboranowitsch.exercise1.service;

import org.springframework.stereotype.Service;

/**
 * Exercise 1 - Class path scan
 * The service is detected by
 *
 */
@Service(value = "calcService")
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Double calcVat(Double amount) {
        return amount + (amount * 0.19);
    }
}
