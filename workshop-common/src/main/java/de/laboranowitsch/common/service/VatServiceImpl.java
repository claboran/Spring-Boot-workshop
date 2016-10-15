package de.laboranowitsch.common.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Vat Service exposed via {@link Service} annotation
 */
@Service
public class VatServiceImpl implements VatService {

    private static final Map<String, Double> VAT_MAP;

    static {
        Map<String, Double> vatMap = new HashMap<>();
        vatMap.put("DE", 0.19);
        vatMap.put("FR", 0.20);
        VAT_MAP = Collections.unmodifiableMap(vatMap);
    }
    @Override
    public Double getVatValue() {
        return getVatValue("DE");
    }

    @Override
    public Double getVatValue(String countryCode) {
        return VAT_MAP.get(countryCode);
    }
}
