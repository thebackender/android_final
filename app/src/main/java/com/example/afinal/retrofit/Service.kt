package com.example.afinal.retrofit

import com.example.afinal.models.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("countries")
    fun getCountries(): Call<List<Country>>
}