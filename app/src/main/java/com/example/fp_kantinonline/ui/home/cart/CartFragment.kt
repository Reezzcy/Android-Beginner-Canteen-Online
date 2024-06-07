package com.example.fp_kantinonline.ui.home.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fp_kantinonline.data.remote.DataCart
import com.example.fp_kantinonline.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listCart = mutableListOf<DataCart>(
            DataCart("Burger 1", "Resto Burger 1", 1, "https://foodish-api.com/images/burger/burger12.jpg"),
            DataCart("Burger 2", "Resto Burger 2", 2, "https://foodish-api.com/images/burger/burger13.jpg"),
            DataCart("Burger 3", "Resto Burger 3", 3, "https://foodish-api.com/images/burger/burger14.jpg")
        )

        with (binding) {
            rvCart.layoutManager = LinearLayoutManager(requireContext())
            rvCart.adapter = RVCartAdapter(listCart)
            rvCart.setHasFixedSize(true)
        }
    }
}