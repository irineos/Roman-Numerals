package com.converter.romannumerals;

public interface RomanNumeralGenerator {
    public String generate(int decimalNumber); // convert from int -> roman
    public String parse(String romanNumeral); // convert from roman -> int
}
