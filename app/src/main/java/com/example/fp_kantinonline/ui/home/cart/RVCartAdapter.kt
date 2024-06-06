package com.example.fp_kantinonline.ui.home.cart

import androidx.recyclerview.widget.RecyclerView
import com.example.fp_kantinonline.data.remote.DataCart
import com.example.fp_kantinonline.databinding.RvCartBinding

class RVCartAdapter {
    inner class CustomViewHolder(private val binding: RvCartBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bindData(food: DataCart) {
            with (binding) {
                tvFoodName.text = food.foodName
                tvRestaurant.text = food.restaurant
                ivFood.setImageResource(food.foodImage)
            }
        }
    }
}