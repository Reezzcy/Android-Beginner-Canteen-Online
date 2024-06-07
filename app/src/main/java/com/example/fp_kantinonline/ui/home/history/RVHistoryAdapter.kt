package com.example.fp_kantinonline.ui.home.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fp_kantinonline.data.remote.DataHistory
import com.example.fp_kantinonline.databinding.RvHistoryBinding

class RVHistoryAdapter(
    private val dataHistory: MutableList<DataHistory>
): RecyclerView.Adapter<RVHistoryAdapter.HistoryViewHolder>() {
    lateinit var listener: OnItemClickListener

    inner class HistoryViewHolder(private val binding: RvHistoryBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: DataHistory) {
            Glide.with(itemView.context)
                .load(food.foodImage)
                .skipMemoryCache(true)
                .into(binding.ivFood)
            binding.tvFoodName.text = food.foodName
            binding.tvRestaurant.text = food.foodRestaurant
            binding.foodCount.text = food.foodCount.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVHistoryAdapter.HistoryViewHolder {
        return HistoryViewHolder(
            RvHistoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataHistory.size
    }

    override fun onBindViewHolder(holder: RVHistoryAdapter.HistoryViewHolder, position: Int) {
        holder.bind(dataHistory[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(dataHistory[position])
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: DataHistory)
    }
}