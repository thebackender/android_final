package com.example.afinal.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.R
import com.example.afinal.repositories.CountryRepository
import com.example.afinal.databinding.RecyclerBinding
import com.example.afinal.MyRecyclerViewAdapter
import com.example.afinal.CountryViewModel

class FragmentList : Fragment(R.layout.recycler) {
    private lateinit var binding: RecyclerBinding
    private lateinit var countryViewModel: CountryViewModel
    private lateinit var rvCountriesAdapter: MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = RecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observe()
    }

    private fun initUI() {
        countryViewModel = CountryViewModel(CountryRepository.getInstance())
        rvCountriesAdapter = MyRecyclerViewAdapter(countryViewModel)
        binding.countries.apply {
            adapter = rvCountriesAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observe() {
        countryViewModel.getCountries().observe(viewLifecycleOwner) {countries ->
            if (countries != null) {
                rvCountriesAdapter.countries = countries
                rvCountriesAdapter.notifyDataSetChanged()
            }
        }
    }
}