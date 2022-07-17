package com.converter.restservice;

import com.converter.romannumerals.NumberConverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    private NumberConverter converter = new NumberConverter();

    @GetMapping("/2roman")
    public String convertToRoman(@RequestParam(value = "number", defaultValue = "0") String number){
        number = number.strip();
        int numberToConvert = 0;
        try {
            numberToConvert = Integer.parseInt(number);
        }catch (NumberFormatException nfe) {
            return "Not an Integer";
        }
        return converter.generate(numberToConvert);
    }

    @GetMapping("/2int")
    public String convertToInt(@RequestParam(value = "number") String romanNumeral){
        return converter.parse(romanNumeral);
    }

}
