package com.example.afinal.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.afinal.retrofit.Client
import com.example.afinal.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository private constructor() {
    companion object {
        private var instance: CountryRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: CountryRepository()
        }
    }

    fun getCountries(): LiveData<List<Country>> {
        val result = MutableLiveData<List<Country>>()

        val call = Client.getApiService()?.getCountries()
        call?.enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                result.value = if (response.isSuccessful) response.body() else emptyList()
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })

        return result
    }
}