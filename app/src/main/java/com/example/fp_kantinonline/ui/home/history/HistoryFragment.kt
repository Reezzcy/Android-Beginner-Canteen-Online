package com.example.fp_kantinonline.ui.home.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fp_kantinonline.data.remote.DataCart
import com.example.fp_kantinonline.data.remote.DataHistory
import com.example.fp_kantinonline.databinding.FragmentHistoryBinding
import com.example.fp_kantinonline.ui.home.cart.RVCartAdapter

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listHistory = mutableListOf<DataHistory>(
            DataHistory("Burger 1", "Resto Burger 1", 1, "https://foodish-api.com/images/burger/burger12.jpg"),
            DataHistory("Burger 2", "Resto Burger 2", 2, "https://foodish-api.com/images/burger/burger13.jpg"),
            DataHistory("Burger 3", "Resto Burger 3", 3, "https://foodish-api.com/images/burger/burger14.jpg")
        )

        with (binding) {
            rvHistory.layoutManager = LinearLayoutManager(requireContext())
            rvHistory.adapter = RVHistoryAdapter(listHistory)
            rvHistory.setHasFixedSize(true)
        }
    }
}