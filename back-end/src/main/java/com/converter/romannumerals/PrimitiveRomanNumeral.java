package com.converter.romannumerals;

public class PrimitiveRomanNumeral {

    protected static int parse(char romanNumeralSymbol){
        switch (romanNumeralSymbol){
            case 'I':
                return 1;

            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;

            case 'C':
                return 100;

            case 'D':
                return 500;

            case 'M':
                return 1000;

            default:
                System.out.println("no match");

        }
        return -1;
    }

    protected static String parse(int baseValue){
        switch (baseValue){
            case 1:
                return "I";

            case 4:
                return "IV";

            case 5:
                return "V";

            case 9:
                return "IX";

            case 10:
                return "X";

            case 40:
                return "XL";

            case 50:
                return "L";

            case 90:
                return "XC";

            case 100:
                return "C";

            case 400:
                return "CD";

            case 500:
                return "D";

            case 900:
                return "CM";

            case 1000:
                return "M";

            default:
                System.out.println("no match");

        }
        return null;
    }
}
