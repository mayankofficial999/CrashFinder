package com.example.crashfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import com.example.analyticsreport.CrashReporter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity_main)
        //Add api url to get data
        CrashReporter().init("http://10.0.2.2:4000")
        //Uncomment Test Cases to test crash report
        //throw InterruptedException("Custom Exception !")
        //val x=10/0
    }
}