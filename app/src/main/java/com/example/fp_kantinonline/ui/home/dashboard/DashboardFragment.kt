package com.example.fp_kantinonline.ui.home.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fp_kantinonline.data.remote.DataIconDashboard
import com.example.fp_kantinonline.databinding.FragmentDashboardBinding
import com.example.fp_kantinonline.ui.listFood.ListFoodActivity

class DashboardFragment : Fragment(), RVIconAdapter.OnItemClickListener {
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listIconName = mutableListOf<String>("biryani", "burger", "butter-chicken", "dessert", "dosa", "idly", "pasta", "pizza", "rice", "samosa")
        var listIconDashboard = mutableListOf<DataIconDashboard>()

        for (foodName in listIconName) {
            val imageUrl = "https://foodish-api.com/images/${foodName}/${foodName}1.jpg"
            listIconDashboard.add(DataIconDashboard(foodName, imageUrl))
        }

        with (binding) {
            rvIcon.layoutManager = GridLayoutManager(rvIcon.context, 5)
            rvIcon.setHasFixedSize(true)
            val adapter = RVIconAdapter(listIconDashboard)
            rvIcon.adapter = adapter.apply { listener = this@DashboardFragment }
        }
    }

    override fun onItemClicked(item: DataIconDashboard) {
        val intent = Intent(requireActivity(), ListFoodActivity::class.java)
        intent.putExtra("content", item.foodName)
        startActivity(intent)
    }
}