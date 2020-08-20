package com.jbc7ag.luckypinata.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.adviceslip.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AdviceApiServiceApiService{

    @GET("advice")
    fun getProperty():
            Call<AdviceProperty>
}

object  AdviceApi {
    //create only once
    val retrofitService : AdviceApiServiceApiService by lazy {
        retrofit.create(AdviceApiServiceApiService::class.java)
    }
}

