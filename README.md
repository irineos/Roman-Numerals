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

The front end design is inspired by google translate app.

It's a simple [React](https://reactjs.org/) app that consists of two text-boxes. The left text-box is the input and the right one is the output.

It uses [Axios](https://axios-http.com/docs/intro) library to send the input as a GET requests to the corresponding API endpoint. The response from the backend will be then rendered in the output text-box.

## Back-End

The backend consist of two main packages. 

- [com.converter.restservice]()
- [com.converter.romannumerals]()

In the first one lives the API and all the server handling stuff, while the second package is responsible for the business logic of the app.

### Api Endpoints

- To convert from Roman numeral to Integer 
```
{BASE URL}/2int?number=<enter_a_roman_number>
```

- To convert from Integer to Roman numeral
```
{BASE URL}/2roman?number=<enter_a_integer_number>
```

The API is written in Java with the help of Spring Boot framework.
