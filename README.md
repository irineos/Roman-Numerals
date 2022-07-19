# Roman-Numerals
An application that converts roman numerals to integers and vice versa

[![App demo](https://github.com/irineos/Roman-Numerals/blob/master/demo.gif "App demo")](https://github.com/irineos/Roman-Numerals/blob/master/demo.gif "App demo")

### You can try the App [here](http://146.190.227.11:3000/)

------------

##  Run
First download the project in your computer. 

Open the terminal in any directory you like and type:

```sh
git clone https://github.com/irineos/Roman-Numerals.git
```

Then cd into the project folder

```sh
cd Roman-Numerals
```
The app uses Docker. So the only think you have to do, is to have Docker installed in your system.

Simply type:

```sh
docker-compose up -d
```
and the app will be running at http://localhost:3000


## Front-End

The front end design is inspired by google translate app and was created with the help of this [tutorial](https://www.youtube.com/watch?v=aFISwq3wteY&t=2016s).

It's a simple [React](https://reactjs.org/) app that consists of two text-boxes. The left text-box is the input and the right one is the output.

It uses [Axios](https://axios-http.com/docs/intro) library to send the input as a GET requests to the corresponding API endpoint. The response from the backend will be then rendered in the output text-box.

## Back-End

The backend consist of two main packages. 

- [com.converter.restservice](https://github.com/irineos/Roman-Numerals/tree/master/back-end/src/main/java/com/converter/restservice)
- [com.converter.romannumerals](https://github.com/irineos/Roman-Numerals/tree/master/back-end/src/main/java/com/converter/romannumerals)

In the first one lives the API and all the server handling stuff, while the second package is responsible for the business logic of the app.

### com.converter.restservice (Api Endpoints)

- To convert from Roman numeral to Integer 
```
{BASE URL}/2int?number=<roman number>
```

[![2intScreenshot](https://github.com/irineos/Roman-Numerals/blob/master/2int.png)](https://github.com/irineos/Roman-Numerals/blob/master/2int.png)

- To convert from Integer to Roman numeral
```
{BASE URL}/2roman?number=<integer number>
```

[![2romanScreenshot](https://github.com/irineos/Roman-Numerals/blob/master/2roman.png)](https://github.com/irineos/Roman-Numerals/blob/master/2roman.png)

The API is written in Java with the help of Spring Boot framework.

### com.converter.romannumerals

-----------
In Roman numeral system, numbers are formed by combining letters from the Latin alphabet and adding their respective values.

| Symbol  | I  | V  | X  | L  | C  | D  |  M |
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------ | ------------ | ------------ |
| Value  |  1 | 5  | 10  |  50 |  100 | 500  | 1000  |

Roman numerals are usually written from largest to smallest, and from left to right. However, the numeral for four is not IIII. Instead, it is written as IV. When there is a smaller number placed before a larger number, the values are subtracted. Because the one is placed before the five, we subtract it to get 4. The same principle applies to the number 9, which is written as IX, number 40, which is written as XL, 90 as XC, 400 as CD and 900 as CM.

I call all these values, Base values.

----------

This package contains two classes and one interface. The class NumberConverter implements the RomanNumeralGenerator interface and its two methods:
- String generate(int) : takes an integer as parameter and returns the corresponding Roman Numeral

```java
 public String generate(int decimalNumber) {
        int[] baseValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
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
```

This method checks if decimalNumber is greater than or equal to the highest base value then adds it's corresponding roman numeral to the romanNumeral string and subtracts this base value from decimalNumber.
If decimalNumber is smaller than the highest base value then checks with next highest base value.
Repeats this process till decimalNumber equals 0. 
In the end romanNumeral will be the roman representation of decimalNumber.


- String parse(String) : takes a Roman Numeral in the form of String as parameter and return the corresponding integer value

```java
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
```

This method, loops through each character in the romanNumeral string.
Then compares the value of the current roman symbol with the value of the next roman symbol.
If the current value is greater than or equal to the value of the symbol to the right, adds the current symbol’s value to the total (decimalNumber).
If the current value is smaller than the value of the symbol to the right, subtract the current symbol’s value from the total (decimalNumber).
In the end, return the decimalNumber.

**Note that this algorithm doesn't check if the input roman number is valid.**


PrimitiveRomanNumeral is a helper class with two static methods which map roman numerals to int and int to roman numeral respectively.


# Deployment

I used Docker and docker-compose to deploy this app to Digitalocean.


------------
### [!!! Try the App !!!](http://146.190.227.11:3000/)
------------
