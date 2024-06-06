package com.example.fp_kantinonline.ui.home.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fp_kantinonline.data.remote.DataIconDashboard
import com.example.fp_kantinonline.databinding.RvIconBinding

class RVIconAdapter(
    private val dataIcon: MutableList<DataIconDashboard>
    ): RecyclerView.Adapter<RVIconAdapter.IconViewHolder>() {

    lateinit var listener: OnItemClickListener

    inner class IconViewHolder(private val binding: RvIconBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: DataIconDashboard) {
            Glide.with(itemView.context)
                .load(food.foodImage)
                .skipMemoryCache(true)
                .into(binding.ivFood)
            binding.tvFoodName.text = food.foodName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IconViewHolder {
        return IconViewHolder(
            RvIconBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataIcon.size
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        holder.bind(dataIcon[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(dataIcon[position])
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: DataIconDashboard)
    }
}