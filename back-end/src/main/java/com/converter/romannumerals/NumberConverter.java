package com.converter.romannumerals;

public class NumberConverter implements RomanNumeralGenerator {

    @Override
    public String generate(int decimalNumber) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String romanNumeral = "";
        if(decimalNumber > 3999 || decimalNumber<=0) return "Integer must be between 1 and 3999";
        while(decimalNumber>0) {
            for (int value : values) {
                if (decimalNumber >= value) {
                    romanNumeral += PrimitiveRomanNumeral.parse(value);
                    decimalNumber -= value;
                    break;
                }
            }
        }
        return romanNumeral;
    }

    @Override
    public String parse(String romanNumeral) {
        if(romanNumeral == "" || romanNumeral == null) return "Enter a number";
        romanNumeral = romanNumeral.toUpperCase().strip();
        int decimalNumber = 0;
        char symbol = romanNumeral.charAt(0);
        char nextSymbol = romanNumeral.charAt(0);
        for(int i=0; i<romanNumeral.length()-1; i++){
            symbol = romanNumeral.charAt(i);
            nextSymbol = romanNumeral.charAt(i+1);
            if(PrimitiveRomanNumeral.parse(symbol) == -1) return "Not a valid character";
            if(PrimitiveRomanNumeral.parse(symbol) >= PrimitiveRomanNumeral.parse(nextSymbol)) decimalNumber += PrimitiveRomanNumeral.parse(symbol);
            if(PrimitiveRomanNumeral.parse(symbol) < PrimitiveRomanNumeral.parse(nextSymbol)) decimalNumber -= PrimitiveRomanNumeral.parse(symbol);

        }
        if(PrimitiveRomanNumeral.parse(nextSymbol) == -1) return "Not a valid character";
        decimalNumber += PrimitiveRomanNumeral.parse(nextSymbol);
        if(decimalNumber >= 3999) return "Max number is MMMCMXCIX = 3999";
        return String.valueOf(decimalNumber);
    }
}
