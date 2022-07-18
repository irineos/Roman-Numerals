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

Simply type

```sh
docker-compose up -d
```
and the app will be running at http://localhost:3000


## Front End

The front end design is inspired by google translate app.

It is a simple [React](https://reactjs.org/) app that uses [Axios](https://axios-http.com/docs/intro) library to send GET requests to the back end.
