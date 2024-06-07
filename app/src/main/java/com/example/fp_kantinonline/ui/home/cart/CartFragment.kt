package com.example.fp_kantinonline.ui.home.cart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fp_kantinonline.R
import com.example.fp_kantinonline.data.retrofit.APIConfig
import com.example.fp_kantinonline.databinding.FragmentCartBinding
import com.example.fp_kantinonline.databinding.FragmentDashboardBinding
import com.example.fp_kantinonline.ui.home.HomeActivity
import okhttp3.ResponseBody

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val client = APIConfig.getAPIService()
//        client.getFoodImageRandom().enqueue(object : Callback<ResponseBody> {
//            override fun onResponse(
//                call: Call<ResponseBody>,
//                response: Response<ResponseBody>
//            ) {
//                if (response.isSuccessful) {
//                    val name:  = response.body() ?: arrayListOf()
//
//                    with(binding) {
//                        rvCharacter.setHasFixedSize(true)
//                        rvCharacter.layoutManager= LinearLayoutManager(requireContext())
//                        rvCharacter.adapter = CharacterAdapter(characterList)
//                    }
//                } else {
//                    Toast.makeText(requireContext(), "onResponse: FAILURE!", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBody>>, t: Throwable) {
//                Toast.makeText(requireContext(), "onFailure: FAILURE!", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}