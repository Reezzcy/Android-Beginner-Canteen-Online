package com.example.fp_kantinonline.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fp_kantinonline.databinding.ActivityHomeBinding
import com.example.fp_kantinonline.ui.home.profile.ProfileFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("name")
        Log.d("HomeActivity", "Username: $username")

//        with (binding) {
//            val navHostFragment = supportFragmentManager.findFragmentById(fcvMain.id) as NavHostFragment
//            val navController = navHostFragment.navController
//
//            bnvMain.setOnItemSelectedListener { item ->
//                val bundle = Bundle().apply {
//                    putString("name", username)
//                }
//
//                val profileFragment = ProfileFragment()
//                profileFragment.arguments = bundle
//
//                supportFragmentManager.beginTransaction()
//                    .replace(fcvMain.id, profileFragment)
//                    .commit()
//
//                navController.navigate(item.itemId, bundle)
//                true
//            }
//
//            val bundle = Bundle()
//            bundle.putString("name", username)
//            val destinationBundle = ProfileFragment()
//            destinationBundle.setArguments(bundle)
//
//            bnvMain.setupWithNavController(navHostFragment.navController)

        with(binding) {
            val navHostFragment = supportFragmentManager.findFragmentById(fcvMain.id) as NavHostFragment
            val navController = navHostFragment.navController

//            bnvMain.setOnNavigationItemSelectedListener { item ->
//                val bundle = Bundle().apply {
//                    putString("name", username)
//                }
//                navController.navigate(item.itemId, bundle)
//                true
//            }

            val mFragmentManager = supportFragmentManager
            val mFragmentTransaction = mFragmentManager.beginTransaction()
            val mFragment = ProfileFragment()

            val mBundle = Bundle()
            mBundle.putString("name", username)
            mFragment.arguments = mBundle
            mFragmentTransaction.add(fcvMain.id, mFragment).commit()

            bnvMain.setupWithNavController(navHostFragment.navController)
        }
    }
}