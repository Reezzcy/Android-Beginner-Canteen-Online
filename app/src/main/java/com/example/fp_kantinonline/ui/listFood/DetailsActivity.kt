package com.example.fp_kantinonline.ui.listFood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import com.bumptech.glide.Glide
import com.example.fp_kantinonline.data.remote.DataListFood
import com.example.fp_kantinonline.databinding.ActivityDetailsBinding

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
            buttonAddCart.setOnClickListener{
                
            }
        }
    }
}