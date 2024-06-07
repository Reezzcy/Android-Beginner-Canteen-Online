package com.example.fp_kantinonline.ui.home.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fp_kantinonline.data.remote.DataCart
import com.example.fp_kantinonline.databinding.RvCartBinding

class RVCartAdapter (
    private val dataCart: MutableList<DataCart>
    ): RecyclerView.Adapter<RVCartAdapter.CartViewHolder>() {

    lateinit var listener: OnItemClickListener

    inner class CartViewHolder(private val binding: RvCartBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: DataCart) {
            Glide.with(itemView.context)
                .load(food.foodImage)
                .skipMemoryCache(true)
                .into(binding.ivFood)
            binding.tvFoodName.text = food.foodName
            binding.tvRestaurant.text = food.restaurant
            binding.tvFoodCount.text = food.foodCount.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVCartAdapter.CartViewHolder {
        return CartViewHolder(
            RvCartBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataCart.size
    }

    override fun onBindViewHolder(holder: RVCartAdapter.CartViewHolder, position: Int) {
        holder.bind(dataCart[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(dataCart[position])
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: DataCart)
    }
}