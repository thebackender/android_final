package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.afinal.R
import com.example.afinal.fragments.FragmentList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, FragmentList(), null)
            .commit()
    }
}