# CrashFinder

## Introduction

Crash Finder is a android native library that catches unhandled exceptions in Android application on any activity and sends the crash log with the list of running processes to the provided backend API via POST request.

## Requirements

You need :
- Android Studio
- Emulator/Android Device
- Android Library File (.aar) or the library project directly and add it as dependency/new module.

## Getting Started

To use the library :
-  Open terminal and Clone the repository : <code>git clone https://github.com/mayankofficial999/CrashFinder.git </code>
-  Open the project in Android Studio and run the app.
-  Now uncomment any of the intentional exceptions and restart the app.
-  You'll see the log with process and It is also sent to the server as POST request.

OR

- Create a new project in Android Studio File -> New -> New Project
- Download the .aar file from releases and save in your machine.
- Open app level <code>build.gradle</code> and this in dependencies :
```
dependencies {
...
//Add this line
implementation files('Path_to_aar_file')
...
}
```
- Open <code> AndroidManifest.xml</code> and add these :
```
//Add this inside manifest opening tag
xmlns:tools="http://schemas.android.com/tools"

//Add this inside application opening tag
tools:replace="android:theme"
```
- Add these lines to MainActivity.kt / MainActivity.java to initialise the library :
```
val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
StrictMode.setThreadPolicy(policy)
//Use http://10.0.2.2:4000 for localhost server
CrashReporter().init("API_POST_REQUEST_URL")
```
- Run the application and check error catching on Logcat by calling a custom exceptions such as :
```
throw InterruptedException("Custom Exception !")
val x=10/0
```
- You have successfully imported the library.

If you want to see the request on a local server :
- Create a new folder and make a new index.js file
- Open terminal and run <code>npm init</code> then <code>npm -i express</code>
- Change package.json to this :

```
{
  "name": "sample",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "start": "nodemon index.js",
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "dependencies": {
    "express": "^4.17.3",
    "nodemon": "^2.0.15"
  }
}

```
- Finally run <code>npm install </code>
- Add these lines to index.js :
```
  const express = require('express')
const app = express()

app.use(
  express.urlencoded({
    extended: true
  })
)

app.use(express.json())


app.post("/", (req, res) => {
    console.log(req.body.Crash_Data);
    console.log("Received Request")
    res.send("Hello")
})


app.listen(4000, () => {
    console.log("Sssupppp!")
})
```
- Enter <code> npm start </code>
- Server is now ready.