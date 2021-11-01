package com.example.responsebody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = NetworkManager.instance?.retrofit?.create(Autorization::class.java)

        api?.login(LoginRequest("RobertaLeonce@mail.com", "Roberta"))?.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val headers = response.headers()
                Log.d("TOKEN_TOKEN", headers["authorization"].toString())

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

        })

    }
}