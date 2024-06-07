package com.example.fp_kantinonline.ui.listFood

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fp_kantinonline.data.remote.DataListFood
import com.example.fp_kantinonline.data.retrofit.APIConfig
import com.example.fp_kantinonline.databinding.ActivityListFoodBinding
import com.example.fp_kantinonline.ui.home.HomeActivity
import com.example.fp_kantinonline.ui.listFood.adapter.RVListFoodAdapter

class ListFoodActivity : AppCompatActivity(), RVListFoodAdapter.OnItemClickListener {
    private lateinit var binding: ActivityListFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityListFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("content")
        Log.d("ListFoodActivity", "Food: $foodName")

        val client = APIConfig.getAPIService()
        var listFood = mutableListOf<DataListFood>()

        for (i in 1..10) {
            listFood.add(DataListFood("${foodName} ${i}",
                "Restaurant ${foodName} ${i}",
                "https://foodish-api.com/images/${foodName}/${foodName}${i}.jpg"))
        }

        with (binding) {
            rvList.layoutManager = LinearLayoutManager(rvList.context)
            rvList.setHasFixedSize(true)
            val adapter = RVListFoodAdapter(listFood)
            rvList.adapter = adapter.apply { listener = this@ListFoodActivity }
            btnBack.setOnClickListener {
                val intent = Intent(this@ListFoodActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onItemClicked(item: DataListFood) {
        val intent = Intent(this@ListFoodActivity, DetailsActivity::class.java)
        intent.putExtra("content", item)
        startActivity(intent)
    }
}