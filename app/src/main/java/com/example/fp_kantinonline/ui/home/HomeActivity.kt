package com.example.fp_kantinonline.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.fp_kantinonline.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("name")
        Log.d("HomeActivity", "Username: $username")

        with(binding) {
            val navHostFragment = supportFragmentManager.findFragmentById(fcvMain.id) as NavHostFragment
            val navController = navHostFragment.navController

            bnvMain.setOnItemSelectedListener { item ->
                val bundle = Bundle().apply {
                    putString("name", username)
                }
                navController.navigate(item.itemId, bundle)
                true
            }
        }
    }
}