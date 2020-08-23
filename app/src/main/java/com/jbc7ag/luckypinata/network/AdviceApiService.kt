package com.jbc7ag.luckypinata.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.adviceslip.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface AdviceApiServiceApiService{

    @GET("advice")
    fun getProperty():
            Deferred<AdviceProperty>
}

object  AdviceApi {
    //create only once
    val retrofitService : AdviceApiServiceApiService by lazy {
        retrofit.create(AdviceApiServiceApiService::class.java)
    }
}

