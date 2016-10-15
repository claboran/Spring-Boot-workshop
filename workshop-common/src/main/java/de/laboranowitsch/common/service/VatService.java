package de.laboranowitsch.common.service;

/**
 * VatService delivers country dependent Vat values
 */
public interface VatService {

    Double getVatValue();
    Double getVatValue(String countryCode);
}
