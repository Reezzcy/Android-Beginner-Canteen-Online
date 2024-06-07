package com.example.fp_kantinonline.ui.listFood

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fp_kantinonline.data.remote.DataFoodImageRandom
import com.example.fp_kantinonline.data.remote.DataIconDashboard
import com.example.fp_kantinonline.data.remote.DataListFood
import com.example.fp_kantinonline.data.retrofit.APIConfig
import com.example.fp_kantinonline.databinding.ActivityListFoodBinding
import com.example.fp_kantinonline.ui.home.HomeActivity
import com.example.fp_kantinonline.ui.listFood.adapter.RVListFoodAdapter
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream

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

        for (i in 0..9) {
            client.getFoodImageRandom("${foodName}/${foodName}${i}.jpg").enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { responseBody ->
                            val inputStream = responseBody.byteStream()
                            val bitmap = BitmapFactory.decodeStream(inputStream)
                            val dataFoodImageRandom = DataFoodImageRandom.fromBitmap(bitmap)
                            listFood.add(DataListFood("${foodName} ke ${i + 1}", dataFoodImageRandom))
                        }
                    } else {
                        TODO("Masih rusakkkkkkk aaaaaaaaaaa")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@ListFoodActivity, "onFailure: FAILURE!", Toast.LENGTH_SHORT)
                        .show()
                }
            })
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