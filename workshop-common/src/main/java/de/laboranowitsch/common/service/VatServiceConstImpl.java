package de.laboranowitsch.common.service;

import org.springframework.stereotype.Service;

/**
 * Created by cla on 10/15/16.
 */
@Service(value = "constVatService")
public class VatServiceConstImpl implements VatService {
    @Override
    public Double getVatValue() {
        return getVatValue("DE");
    }

    @Override
    public Double getVatValue(String countryCode) {
        return 0.21;
    }
}
