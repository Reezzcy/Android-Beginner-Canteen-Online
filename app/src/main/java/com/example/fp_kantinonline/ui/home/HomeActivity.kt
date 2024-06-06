package com.example.fp_kantinonline.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fp_kantinonline.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {
//            val navHostFragment = supportFragmentManager.findFragmentById(fcvMain.id) as NavHostFragment
//            bnvMain.setupWithNavController(navHostFragment.navController)

            val navHostFragment = supportFragmentManager.findFragmentById(fcvMain.id) as NavHostFragment
            val navController = navHostFragment.navController
            // Ambil data dari Intent
            val name = intent.getStringExtra("name")
            // Buat Bundle dan tambahkan data
            val bundle = Bundle()
            bundle.putString("name", name)
            // Set data ke fragment yang akan dipanggil
            navHostFragment.navController.setGraph(navHostFragment.navController.graph, bundle)
            bnvMain.setupWithNavController(navController)
        }
    }
}