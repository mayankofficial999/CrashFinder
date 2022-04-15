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
        //Log.e("Dekho Processs ko ek baar : ",CrashReporter().getCurrentProcesses())
        //external fun ps_main()
        //Uncomment Test Cases for crash
        //throw InterruptedException("Custom Exception !")
        //val y=Math.pow(999999999.0, 999.0)
        //val z=2/"hello"
        //val x=10/0

    }
}