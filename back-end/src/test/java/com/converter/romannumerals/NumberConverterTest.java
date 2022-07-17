package com.converter.romannumerals;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberConverterTest {

    @Test
    void testGenerate(){
        NumberConverter converter = new NumberConverter();
        int decimalNumber = -12;
        String expectedRomanNumber = "Integer must be between 1 and 3999";

        assertThat(converter.generate(decimalNumber)).isEqualTo(expectedRomanNumber);

    }

    @Test
    void testParse(){
        NumberConverter converter = new NumberConverter();
        String romanNumber = "";
        String expectedDecimalNumber = "Enter a number";

        assertThat(converter.parse(romanNumber)).isEqualTo(expectedDecimalNumber);

    }
}
