package com.example.responsebody

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Autorization {

    @Headers("x-profile-type: BASE")
    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest) : Call<ResponseBody>
}