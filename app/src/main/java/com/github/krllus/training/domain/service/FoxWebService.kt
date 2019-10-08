package com.github.krllus.training.domain.service

import com.github.krllus.training.data.Fox
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoxWebService {

    @GET
    fun getFox(@Query("i") foxId: String): Call<Fox>

    @GET("floof")
    fun getRandomFox(): Call<Fox>
}