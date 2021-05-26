package com.wartsila.camelcase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamelCaseTest {

    @Test
    public void camelCase_emptyInput() {
        String input = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_noDelimiter() {
        String input = "digitalproduct";
        System.out.println("input: " + input);
        assertEquals(input, CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_stringWithUnderscoresLowerStart_success() {
        String input = "digital_Product_Development";
        System.out.println("input: " + input);
        assertEquals("digitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeDashLowerStart_success() {
        String input = "digital-Product-Development";
        System.out.println("input: " + input);
        assertEquals("digitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_firstLetterUpperCase_success() {
        String input = "Digital_Product_Development";
        System.out.println("input: " + input);
        assertEquals("DigitalProductDevelopment", CamelCase.toCamelCase(input));
    }
}
