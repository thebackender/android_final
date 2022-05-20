package com.example.afinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R
import com.example.afinal.models.Country
import com.example.afinal.databinding.RecyclerBinding
import com.example.afinal.databinding.RecyclerItemBinding
import com.example.afinal.fragments.FragmentList
import com.example.afinal.CountryViewModel

class MyRecyclerViewAdapter(
    private val countryViewModel: CountryViewModel
): RecyclerView.Adapter<MyRecyclerViewAdapter.CountryViewHolder>() {
    var countries: List<Country> = emptyList()

    inner class CountryViewHolder(
        private val binding: RecyclerItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.apply {
                name.text = country.Country
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount() = countries.size
}