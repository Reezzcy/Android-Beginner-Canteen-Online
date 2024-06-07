package com.example.fp_kantinonline.ui.listFood

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide
import com.example.fp_kantinonline.data.remote.DataCart
import com.example.fp_kantinonline.data.remote.DataListFood
import com.example.fp_kantinonline.databinding.ActivityDetailsBinding
import com.example.fp_kantinonline.ui.home.HomeActivity

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodData = getParcelableExtra(
            intent,
            "content",
            DataListFood::class.java
        ) as DataListFood

        with(binding) {
            Glide.with(this@DetailsActivity)
                .load(foodData.foodImage)
                .skipMemoryCache(true)
                .into(binding.foodImage)
            foodTitle.text = foodData.foodName
            tvTitle.text = foodData.foodName

            btnBack.setOnClickListener {
                val intent = Intent(this@DetailsActivity, HomeActivity::class.java)
                startActivity(intent)
            }

            buttonAddCart.setOnClickListener{ item ->
                val bundle = Bundle().apply {
                    val dataCart: DataCart = DataCart(foodData.foodName, foodData.foodRestaurant, 1, foodData.foodImage)
                    putParcelable("content", dataCart)
                }
            }
        }
    }
}