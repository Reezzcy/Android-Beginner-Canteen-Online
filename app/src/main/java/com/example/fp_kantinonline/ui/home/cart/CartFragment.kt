package com.example.fp_kantinonline.ui.home.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fp_kantinonline.R
import com.example.fp_kantinonline.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val client = APIConfig.getAPIService()
//        client.getFoodImage().enqueue(object : Callback<ArrayList<DataFoodImage>> {
//            override fun onResponse(
//                call: Call<ArrayList<CharactersResponse>>,
//                response: Response<ArrayList<CharactersResponse>>
//            ) {
//                if (response.isSuccessful) {
//                    val characterList: ArrayList<CharactersResponse> = response.body() ?: arrayListOf()
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
//            override fun onFailure(call: Call<ArrayList<CharactersResponse>>, t: Throwable) {
//                Toast.makeText(requireContext(), "onFailure: FAILURE!", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}