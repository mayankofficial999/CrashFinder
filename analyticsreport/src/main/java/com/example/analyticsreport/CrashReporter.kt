package com.example.analyticsreport

import android.util.Log
import okhttp3.*
import java.io.IOException


class CrashReporter {

    init {
        System.loadLibrary("analyticsreport")
    }

    private var client = OkHttpClient()
    private external fun getCurrentProcesses(): String
    @Throws(IOException::class)
    private fun sendPostRequest(url: String?, json : String): String {
        val body: RequestBody = FormBody.Builder()
            .add("Crash_Data", json)
            .build()

        val request: Request = Request.Builder()
            .url(url.toString())
            .post(body)
            .build()
        Log.i("Request sent : ",json)
        client.newCall(request).execute().use { response ->
            Log.i("Response: ",response.body!!.string())
            return response.body!!.string()
        }
    }

    fun init(api_url:String) {
        //Log.e("Dekho Processs ko ek baar : ",CrashReporter().getCurrentProcesses().length.toString())
        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler { _, exc ->
            var reqData=""
            reqData+=exc.message.toString()
            for(data in exc.stackTrace) {
                reqData += data.toString()
                reqData += "\n"
            }
            val temp=getCurrentProcesses();
            //Log.e("Dekho Processs ko ek baar : ",temp)
            reqData+="\n";
            reqData+=temp;
            sendPostRequest(api_url,reqData)
        }
    }
}