package com.example.afinal

import androidx.lifecycle.ViewModel
import com.example.afinal.repositories.CountryRepository

class CountryViewModel(private val repository: CountryRepository): ViewModel() {
    fun getCountries() = repository.getCountries()
}