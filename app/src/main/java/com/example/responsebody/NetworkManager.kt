package com.example.responsebody

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {

    private var gson : Gson? = null
    get() {
        if (field == null){
            val gsonBuilder = GsonBuilder()
            gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            gsonBuilder.serializeNulls()
            gson = gsonBuilder.create()

        }
        return field
    }

    var retrofit : Retrofit? = null
    get() {
        if (field == null){
            field = Retrofit.Builder()
                .baseUrl("http://185.97.114.171:50055/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson!!))
                .client(client!!)
                .build()
        }
        return field
    }

    private var client : OkHttpClient? = null
    get() {
        if (field == null){
            val builder = OkHttpClient.Builder()
                builder.addInterceptor(AuthorizationInterceptor())
            field = builder.build()
        }
        return field
    }

    companion object {
        var instance: NetworkManager? = null
            get() {
                if (field == null) {
                    field = NetworkManager()
                }
                return field
            }
    }
}