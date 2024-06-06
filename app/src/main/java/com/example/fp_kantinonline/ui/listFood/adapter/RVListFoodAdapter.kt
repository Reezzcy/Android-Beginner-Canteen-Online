package com.example.fp_kantinonline.ui.listFood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fp_kantinonline.data.remote.DataListFood
import com.example.fp_kantinonline.databinding.RvListBinding

class RVListFoodAdapter (
    private val dataListFood: MutableList<DataListFood>
    ): RecyclerView.Adapter<RVListFoodAdapter.ListViewHolder>() {

    lateinit var listener: OnItemClickListener

    inner class ListViewHolder(private val binding: RvListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: DataListFood) {
            binding.ivFood.setImageBitmap(food.foodImage.getBitmap())
            binding.tvFoodName.text = food.foodName
            binding.tvRestaurant.text = food.foodName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        return ListViewHolder(
            RvListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataListFood.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(dataListFood[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(dataListFood[position])
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: DataListFood)
    }
}